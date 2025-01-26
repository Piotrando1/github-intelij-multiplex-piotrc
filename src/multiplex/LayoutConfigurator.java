package multiplex;

import java.util.Arrays;
import java.util.List;

public class LayoutConfigurator {


// -------------------------------------------------------------------------------------------
// LAYOUT SMALL HALL
// -------------------------------------------------------------------------------------------

    public static SeatLayout createSmallHall() {

        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F");
        SeatLayout layout = new SeatLayout(rows, 10);

        layout.addConfigsForRow("A", Arrays.asList(
                new SeatConfig(1, 4,  SeatStandard.SUPER_PROMO),
                new SeatConfig(5, 6,  SeatStandard.DISABLED),
                new SeatConfig(7, 10, SeatStandard.SUPER_PROMO)
        ));

        layout.addConfigsForRow("B", Arrays.asList(
                new SeatConfig(1, 4,  SeatStandard.SUPER_PROMO),
                new SeatConfig(5, 6,  SeatStandard.DISABLED),
                new SeatConfig(7, 10, SeatStandard.SUPER_PROMO)
        ));

        layout.addConfigsForRow("C", List.of(
                new SeatConfig(1, 10, SeatStandard.PROMO)
        ));
        layout.addConfigsForRow("D", List.of(
                new SeatConfig(1, 10, SeatStandard.PROMO)
        ));

        layout.addConfigsForRow("E", Arrays.asList(
                new SeatConfig(1, 3,  SeatStandard.STANDARD),
                new SeatConfig(4, 6,  SeatStandard.VIP),
                new SeatConfig(7, 10, SeatStandard.STANDARD)
        ));

        layout.addConfigsForRow("F", List.of(
                new SeatConfig(1, 10, SeatStandard.STANDARD)
        ));

        return layout;
    }

// -------------------------------------------------------------------------------------------
// LAYOUT MEDIUM HALL
// -------------------------------------------------------------------------------------------

    public static SeatLayout createMediumHall() {

        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        SeatLayout layout = new SeatLayout(rows, 15);

        layout.addConfigsForRow("A", List.of(
                new SeatConfig(1, 15, SeatStandard.DISABLED)
        ));

        layout.addConfigsForRows(
                Arrays.asList("B", "C", "D"),
                List.of(
                        new SeatConfig(1, 15, SeatStandard.SUPER_PROMO)
                )
        );

        layout.addConfigsForRows(
                Arrays.asList("E", "F"),
                List.of(
                        new SeatConfig(1, 15, SeatStandard.PROMO)
                )
        );
        layout.addConfigsForRow("G", Arrays.asList(
                new SeatConfig(1, 4,  SeatStandard.STANDARD),
                new SeatConfig(5, 9,  SeatStandard.VIP),
                new SeatConfig(10, 15, SeatStandard.STANDARD)
        ));

        layout.addConfigsForRows(
                Arrays.asList("H", "I", "J"),
                List.of(
                        new SeatConfig(1, 15, SeatStandard.STANDARD)
                )
        );

        return layout;
    }

// -------------------------------------------------------------------------------------------
// LAYOUT LARGE HALL
// -------------------------------------------------------------------------------------------

    public static SeatLayout createLargeHall() {

        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P");
        SeatLayout layout = new SeatLayout(rows, 20);

        layout.addConfigsForRow("A", List.of(
                new SeatConfig(1, 20, SeatStandard.DISABLED)
        ));

        layout.addConfigsForRows(
                Arrays.asList("B", "C", "D", "E"),
                List.of(
                        new SeatConfig(1, 20, SeatStandard.SUPER_PROMO)
                )
        );

        layout.addConfigsForRows(
                Arrays.asList("F", "G", "H", "I"),
                List.of(
                        new SeatConfig(1, 20, SeatStandard.PROMO)
                )
        );
        layout.addConfigsForRow("J", Arrays.asList(
                new SeatConfig(1, 5,  SeatStandard.STANDARD),
                new SeatConfig(6, 15,  SeatStandard.VIP),
                new SeatConfig(16, 20, SeatStandard.STANDARD)
        ));

        layout.addConfigsForRows(
                Arrays.asList("K", "L", "M", "N", "O", "P"),
                List.of(
                        new SeatConfig(1, 20, SeatStandard.STANDARD)
                )
        );

        return layout;
    }
}

