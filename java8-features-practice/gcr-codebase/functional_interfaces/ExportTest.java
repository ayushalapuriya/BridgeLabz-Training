interface DataExporter {
    void exportToCSV();
    void exportToPDF();
    default void exportToJSON() {
        System.out.println("Exported data to JSON");
    }
}

class ReportModule implements DataExporter {
    public void exportToCSV() {
        System.out.println("Exported data to CSV");
    }
    public void exportToPDF() {
        System.out.println("Exported data to PDF");
    }
}

public class ExportTest {
    public static void main(String[] args) {
        DataExporter exporter = new ReportModule();
        exporter.exportToCSV();
        exporter.exportToPDF();
        exporter.exportToJSON();
    }
}
