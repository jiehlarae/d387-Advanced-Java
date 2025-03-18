package edu.wgu.d387_sample_code;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DisplayTimeZone{
    public String[] timeZone() {

        ZoneId etZone = ZoneId.of("America/New_York");
        ZoneId mtZone = ZoneId.of("America/Denver");
        ZoneId utZone = ZoneId.of("UTC");

        ZonedDateTime convertEtTime = ZonedDateTime.now(etZone);
        ZonedDateTime convertMtTime = ZonedDateTime.now(etZone).withZoneSameInstant(mtZone);
        ZonedDateTime convertUtTime = ZonedDateTime.now(etZone).withZoneSameInstant(utZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");

        String formattedEtTime = formatter.format(convertEtTime) + " " + convertEtTime.getZone().getDisplayName(TextStyle.FULL, Locale.US);
        String formattedMtTime = formatter.format(convertMtTime) + " " + convertMtTime.getZone().getDisplayName(TextStyle.FULL, Locale.US);
        String formattedUtTime = formatter.format(convertUtTime) + " " + convertUtTime.getZone().getDisplayName(TextStyle.SHORT , Locale.US);

        String displayTime = String.join(" | ", formattedEtTime, formattedMtTime, formattedUtTime);

        return new String[]{displayTime};
     }
}
