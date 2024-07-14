package com.lawal.transit.fx;

public class Styler implements StylerInterface {

    private String bodyStyling;
    private String padStyling;
    private String borderStyling;
//    private String topHorizontalBorderStyling;
//    private String bottomHorizontalBorderStyling;
//    private String leftVerticalBorderStyling;
//    private String rightVerticalBorderStyling;

    public Styler () {
        this("", "", "");
    }

    public Styler (
        String bodyStyling,
        String padStyling,
        String borderStyling
    ) {
        this.bodyStyling = bodyStyling;
        this.padStyling = padStyling;
        this.borderStyling = borderStyling;
//        this.topHorizontalBorderStyling = borderStyling;
//        this.bottomHorizontalBorderStyling = borderStyling;
//        this.leftVerticalBorderStyling = borderStyling;
//        this.rightVerticalBorderStyling = borderStyling;
    }

    @Override
    public String getBodyStyling () {
        return bodyStyling;
    }

    @Override
    public String getPadStyling () {
        return padStyling;
    }

    @Override
    public String getBorderStyling () {
        return borderStyling;
    }
//
//    @Override
//    public String getTopHorizontalBorderStyling () {
//        return topHorizontalBorderStyling;
//    }
//
//    @Override
//    public String getBottomHorizontalBorderStyling () {
//        return bottomHorizontalBorderStyling;
//    }
//
//    @Override
//    public String getLeftVerticalBorderStyling () {
//        return leftVerticalBorderStyling;
//    }
//
//    @Override
//    public String getRightVerticalBorderStyling () {
//        return rightVerticalBorderStyling;
//    }

    @Override
    public void setBodyStyling (String styling) {
        bodyStyling = styling;
    }

    @Override
    public void setPadStyling (String styling) {
        padStyling = styling;
    }

    @Override
    public void setBorderStyling (String styling) {
        borderStyling = styling;
    }
//
//    @Override
//    public void setTopHorizontalBorderStyling (String styling) {
//        topHorizontalBorderStyling = styling;
//    }
//
//    @Override
//    public void setBottomHorizontalBorderStyling (String styling) {
//        bottomHorizontalBorderStyling = styling;
//    }
//
//    @Override
//    public void setLeftVerticalBorderStyling (String styling) {
//        leftVerticalBorderStyling = styling;
//    }
//
//    @Override
//    public void setRightVerticalBorderStyling (String styling) {
//        rightVerticalBorderStyling = styling;
//    }

    @Override
    public String toString () {
        return bodyStyling + "\n " + borderStyling + "\n " + padStyling;
    }
}
