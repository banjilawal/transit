package com.lawal.transit.fx;

public class Stylerizer implements Stylerizerable {

    private String backgroundStyle;
    private String borderStyle;

    public Stylerizer () {
        this("", "");
    }

    public Stylerizer (String backgroundStyle, String borderStyle) {
        this.backgroundStyle = backgroundStyle;
        this.borderStyle = borderStyle;
    }

    @Override
    public String getBackgroundStyle () {
        return backgroundStyle;
    }

    @Override
    public String getBorderStyle () {
        return borderStyle;
    }

    @Override
    public void setBackgroundStyle (String style) {
        backgroundStyle = style;
    }

    @Override
    public void setBorderStyle (String style) {
        borderStyle = style;
    }

    @Override
    public String toString () {
        return backgroundStyle + "\n " + borderStyle;
    }
}
