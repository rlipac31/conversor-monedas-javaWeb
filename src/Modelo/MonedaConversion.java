package Modelo;

public class MonedaConversion {
    private  String time_last_update_utc;
    private  String time_next_update_utc;
    private  String base_code;
    private  String target_code;
    private  double conversion_rate;
    private  double conversion_result;

    public MonedaConversion(String time_last_update_utc, String time_next_update_utc, String base_code, String target_code, double conversion_rate, double conversion_result) {
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    @Override
    public String toString() {
        return "MonedaConversion{" +
                "time_last_update_utc= " + time_last_update_utc +
                ", time_next_update_utc= " + time_next_update_utc +
                ", base_code= " + base_code +
                ", target_code= " + target_code +
                ", conversion_rate= " + conversion_rate +
                ", conversion_result= " + conversion_result +
                '}';
    }
}
