package co.devskills.springbootboilerplate.sqlite;

public class CreditData {
        private String firstName;
        private String lastName;
        private String address;
        private int assessedIncome;
        private int balanceOfDebt;
        private boolean complaints;

        public CreditData(String firstName, String lastName, String address, int assessedIncome, int balanceOfDebt, boolean complaints) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.address = address;
                this.assessedIncome = assessedIncome;
                this.balanceOfDebt = balanceOfDebt;
                this.complaints = complaints;
        }

        public CreditData() {

        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public int getAssessedIncome() {
                return assessedIncome;
        }

        public void setAssessedIncome(int assessedIncome) {
                this.assessedIncome = assessedIncome;
        }

        public int getBalanceOfDebt() {
                return balanceOfDebt;
        }

        public void setBalanceOfDebt(int balanceOfDebt) {
                this.balanceOfDebt = balanceOfDebt;
        }

        public boolean isComplaints() {
                return complaints;
        }

        public void setComplaints(boolean complaints) {
                this.complaints = complaints;
        }
}
