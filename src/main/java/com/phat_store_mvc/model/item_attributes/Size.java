package com.phat_store_mvc.model.item_attributes;

import java.util.List;

public enum Size {
    HATS(List.of("S", "M", "L")),
    CLOTHES(List.of("XS", "S", "M", "L", "XL")),
    SHOES(List.of("36", "37", "38", "39", "40", "41", "41", "43", "44"));

    private final List<String> sizes;

    public List<String> getSizes() {
        return sizes;
    }

    Size(List<String> sizes) {
        this.sizes = sizes;
    }
}
