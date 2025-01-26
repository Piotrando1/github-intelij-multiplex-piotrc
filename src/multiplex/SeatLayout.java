package multiplex;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatLayout {
    private final Map<String, List<SeatConfig>> layoutMap;
    private final List<String> rows;
    private final int seatsPerRow;

    public SeatLayout(List<String> rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.layoutMap = new HashMap<>();
    }


    public void addConfigsForRow(String row, List<SeatConfig> configs) {
        layoutMap.put(row, configs);
    }

    public void addConfigsForRows(List<String> rowLetters, List<SeatConfig> configs) {
        for (String row : rowLetters) {
            addConfigsForRow(row, configs);
        }
    }

    public SeatStandard getStandardFor(String row, int seatNumber) {

        List<SeatConfig> configs = layoutMap.get(row);
        if (configs == null) {
            return SeatStandard.STANDARD;
        }

        for (SeatConfig c : configs) {
            if (seatNumber >= c.getFromSeat() && seatNumber <= c.getToSeat()) {
                return c.getStandard();
            }
        }

        return SeatStandard.STANDARD;
    }

    public boolean isSeatAvailable(String row, int seatNumber) {
        if (!rows.contains(row)) return false;
        return seatNumber >= 1 && seatNumber <= seatsPerRow;
    }

    public List<String> getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }
}