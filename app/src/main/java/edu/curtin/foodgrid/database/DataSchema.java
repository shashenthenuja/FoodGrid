package edu.curtin.foodgrid.database;

public class DataSchema {

    /* *******************************************************************
     * File:       DataSchema.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Database schema class containing database tables
     ***********************************************************************/

    public static class restaurantTable{
        public static final String NAME = "restaurants";
        public static class Cols{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String IMAGE = "image";
        }
    }

    public static class foodTable{
        public static final String NAME = "food";
        public static class Cols{
            public static final String ID = "id";
            public static final String RES_ID = "resId";
            public static final String NAME = "name";
            public static final String IMAGE = "image";
            public static final String PRICE = "price";
        }
    }

    public static class customer{
        public static final String NAME = "customer";
        public static class Cols{
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
        }
    }

    public static class orderHistory{
        public static final String NAME = "orders";
        public static class Cols{
            public static final String EMAIL = "email";
            public static final String ORDER_NUMBER = "order_number";
            public static final String FOOD = "food";
            public static final String PRICE = "price";
            public static final String QTY = "qty";
        }
    }
}
