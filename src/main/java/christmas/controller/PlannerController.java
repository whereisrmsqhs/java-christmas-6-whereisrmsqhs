package christmas.controller;

import christmas.domain.*;
import christmas.service.PlannerService;
import christmas.validation.VisitDateValidation;
import christmas.view.View;

import static christmas.constant.ErrorMessage.ERROR;


public class PlannerController {

    private final View view;
    private final PlannerService service;

    public PlannerController(View view, PlannerService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        try {
            Integer visitDate = receiveVisitingDate();
            MyOrder myOrder = receiveMenuOrders();
            MyRequirement myRequirement = new MyRequirement(myOrder, visitDate);
            Receipt myReceipt = calculateAllBenefits(myRequirement);
            previewAllBenefits(myReceipt);
        } catch (Exception e) {
            // 에러 형식 지키면서 출력
            System.out.println(e.getMessage());
        }
    }

    private void previewAllBenefits(Receipt myReceipt) {
        view.printPreviewBenefits(myReceipt);
    }

    private Receipt calculateAllBenefits(MyRequirement requirement) {
        Price totalAmountBeforeDiscount = requirement.calculateTotalAmountBeforeDiscount();
        Result eachDiscountAmount = getEachDiscount(requirement, totalAmountBeforeDiscount);
        Price totalDiscountAmount = service.calculateTotalDiscount(eachDiscountAmount.christmasEventDiscountAmount(),
                eachDiscountAmount.weekDayDiscountAmount(),
                eachDiscountAmount.weekEndDiscountAmount(), eachDiscountAmount.specialDiscountAmount(),
                eachDiscountAmount.champaigneAmount());
        Badge eventBadge = service.calculateBadge(totalDiscountAmount);
        return new Receipt(requirement, totalAmountBeforeDiscount, eachDiscountAmount, totalDiscountAmount, eventBadge);
    }

    private Result getEachDiscount(MyRequirement requirement, Price totalAmountBeforeDiscount) {
        Price christmasEventDiscountAmount = service.calculateDDayDiscount(requirement, December.getInstance());
        Price weekDayDiscountAmount = service.calculateWeekDayDiscount(requirement, December.getInstance());
        Price weekEndDiscountAmount = service.calculateWeekendDiscount(requirement, December.getInstance());
        Price specialDiscountAmount = service.calculateSpecialDiscount(requirement, December.getInstance());
        Price champaigneAmount = service.includeChampaigneGift(totalAmountBeforeDiscount);
        return new Result(christmasEventDiscountAmount, weekDayDiscountAmount,
                weekEndDiscountAmount, specialDiscountAmount, champaigneAmount);
    }

    private MyOrder receiveMenuOrders() {
        String myOrderedFoods = view.printOrderMenuMessageAndReceiveOrders();
        return new MyOrder(myOrderedFoods);
    }

    private Integer receiveVisitingDate() {
        boolean isError = true;
        String visitDate = null;
        view.printIntroMessage();
        while(isError) {
            try {
                visitDate = view.receiveVisitDate();
                isError = VisitDateValidation.validateVisitDate(visitDate);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
                continue;
            }
        }
        return Integer.parseInt(visitDate);
    }
}
