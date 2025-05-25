package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercentage;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше 0: " + basePrice);
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100%: " + discount);
        }
        this.basePrice = basePrice;
        this.discountPercentage = discount;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discountPercentage) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getStringRepresentation() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString() + " (" + discountPercentage + "%)";
    }
}