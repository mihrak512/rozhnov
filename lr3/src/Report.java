class Report {
    public static void generateReport(Employee[] employees) {
        System.out.printf("%-15s | %15s%n", "Фамилия", "Зарплата");
        System.out.println("-".repeat(33));
        for (Employee e : employees) {
            System.out.printf("%-15.15s | %15.2f%n",
                    e.getFullname(), e.getSalary());
        }
    }
}
