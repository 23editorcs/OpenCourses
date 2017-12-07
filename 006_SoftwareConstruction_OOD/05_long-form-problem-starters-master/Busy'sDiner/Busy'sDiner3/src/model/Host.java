package model;

import java.util.List;

public class Host extends FOHEmployee{

    private static final String PREFIX = "HOST - ";

    public Host(Dish dish) {
        super(dish);
    }

    @Override
    protected String getPrefix() {
        return PREFIX;
    }

}
