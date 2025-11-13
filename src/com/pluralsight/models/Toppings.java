package com.pluralsight.models;

import java.util.Arrays;
import java.util.List;

public class Toppings {
    public static final List<String> REGULAR = Arrays.asList(
            "\uD83E\uDD66 Cabbage", "\uD83C\uDF3F Dill", "\uD83E\uDD52 Pickles", "\uD83E\uDDC4 Onions", "\uD83E\uDD52 Cucumbers"
    );
    public static final List<String> MEATS = Arrays.asList(
            "\uD83D\uDC37 Kielbasa", "\uD83C\uDF57 Chicken", "\uD83E\uDD53 Bacon", "\uD83D\uDC16 Roast Pork"
    );
    public static final List<String> CHEESES = Arrays.asList(
            "\uD83D\uDFE8 Bryndza", "\uD83D\uDFE8 Swiss", "\uD83E\uDDC0 Cheddar", "\uD83E\uDDC8 Tvorog"
    );
    public static final List<String> SAUCES = Arrays.asList(
            "\uD83C\uDF76 Smetana", "⚱\uFE0F Adjika", "\uD83E\uDDC4 Garlic Sauce", "\uD83E\uDDF4 Mustard"
    );
}