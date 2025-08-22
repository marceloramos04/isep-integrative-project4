package userManagement.domain;

public enum UserRole {
    ADMINISTRATOR(1) {
        @Override
        public String toString() {
            return String.format("Administrator");
        }
    },
    CUSTOMER_MANAGER(2) {
        @Override
        public String toString() {
            return String.format("Customer_Manager");
        }
    },
    OPERATOR(3) {
        @Override
        public String toString() {
            return String.format("Operator");
        }
    },
    CANDIDATE(4){

        @Override
        public String toString() {
            return String.format("Candidate");
        }
    },

    CUSTOMER(5) {
        @Override
        public String toString () {
            return String.format("Customer");
        }
    };

    private final int value;

    UserRole(int value) {
        this.value = value;
    }

    public int getRoleId() {
        return this.value;
    }

    public static UserRole getRoleById(int id) {

        UserRole[] arr = UserRole.values();

        for (int i = 0; i < arr.length; i++) {

            if(id == arr[i].getRoleId()) {
                return arr[i];
            }
        }
        return null;
    }
}
