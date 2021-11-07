package com.ysb;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LocalDateTimeTest {
    public static void main(String[] args) {

        System.out.println("数字之间可以加下划线，符合美国人阅读习惯的下划线");
        int a = 999_999_999;
        System.out.println(a);
        System.out.println("数字之间可以加下划线，符合中国人阅读习惯的下划线");
        int b = 999_0000;
        System.out.println(b);

        System.out.println("==========新旧日期api的对比======================");
        System.out.println(new Date());
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println("==========date的拆解===========================");
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int monthValue = localDate.getMonthValue();
        int dayOfMonth = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfYear = localDate.getDayOfYear();
        System.out.println(year);
        System.out.println(month);
        System.out.println(monthValue);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
        System.out.println(dayOfYear);

        System.out.println("===========自己造date===========================");
        LocalDate d = LocalDate.of(1997, 11, 3);
        System.out.println(d);

        System.out.println("============比较两日期是否相等=====================");
        System.out.println("============日期相等吗： " + localDate.equals(d));

        System.out.println("=============当前time===========================");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println("=============当前time的拆解======================");
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        int nano = localTime.getNano();
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        System.out.println(nano);

        System.out.println("=============当前instant========================");
        Instant instant = Instant.now();
        Instant chinaInstant = Instant.now().plus(8, ChronoUnit.HOURS);
        System.out.println(instant);
        System.out.println("中国的瞬时时间:" + chinaInstant);
        System.out.println("=============当前instant的拆解===================");
        int instantNano = instant.getNano();
        long epochSecond = instant.getEpochSecond();
        System.out.println(instantNano);
        System.out.println(epochSecond);//纪元秒，从1970-1-1到当前时间总秒数

        System.out.println("=============可在当前时间上加到未来或减到过去某个时间==");
        System.out.println("=============当前time===========================");
        System.out.println(localTime);
        System.out.println("=============两小时后的time======================");
        System.out.println(localTime.plusHours(2));
        System.out.println("=============两分钟后的time======================");
        System.out.println(localTime.plusMinutes(2));
        System.out.println("=============两秒后的time========================");
        System.out.println(localTime.plusSeconds(2));
        System.out.println("=============两纳秒后的time======================");
        System.out.println(localTime.plusNanos(2));
        System.out.println("=============半天前的time========================");
        System.out.println(localTime.minus(1, ChronoUnit.HALF_DAYS));

        System.out.println("=============当前date===========================");
        System.out.println(localDate);
        System.out.println("=============一周后的date========================");
        System.out.println(localDate.plus(1, ChronoUnit.WEEKS));
        System.out.println("=============一年前的date========================");
        System.out.println(localDate.minus(1, ChronoUnit.YEARS));
        System.out.println("=============一年后的date========================");
        System.out.println(localDate.plus(1, ChronoUnit.YEARS));

        System.out.println("=============系统的UTC==========================");
        Clock systemUTC = Clock.systemUTC();
        System.out.println(systemUTC);
        System.out.println("=============系统的默认时区======================");
        Clock systemDefaultZone = Clock.systemDefaultZone();
        System.out.println(systemDefaultZone);

        System.out.println("=============判断两个日期的前后===================");
        LocalDate date1 = LocalDate.of(2021, 11, 11);
        LocalDate date2 = LocalDate.now();
        System.out.println(date1.isAfter(date2));
        System.out.println(date1.isBefore(date2));

        System.out.println("===========LocalDateTime+ZoneId = ZonedDateTime");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of(ZoneId.SHORT_IDS.get("ACT"));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);

        System.out.println("===========LocalDateTime+ZoneOffset = OffsetDateTime");
        System.out.println("===========OffsetDateTime主要是用来给机器理解的，平时使用就用前面的ZoneDateTime类就可以了");
        ZoneOffset zoneOffset = ZoneOffset.of("+12:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        System.out.println(localDateTime);
        System.out.println(offsetDateTime);

        System.out.println("===========月+日的api和应用=======================");
        MonthDay birth = MonthDay.of(d.getMonth(), d.getDayOfMonth());
        MonthDay todayMonthDay = MonthDay.from(LocalDate.now());
        if (birth.equals(todayMonthDay)) {
            System.out.println("今天是你的生日，生日快乐呀");
        } else {
            System.out.println("今天不是你的生日哟");
        }

        System.out.println("===========年+月的api和应用=======================");
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println("===========月的长度返回这个月有多少天================");
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println("===========年的长度返回这年有多少天==================");
        System.out.println(yearMonth.lengthOfYear());
        System.out.println("===========今年2月的长度===========================");
        System.out.println(yearMonth.minus(9, ChronoUnit.MONTHS).lengthOfMonth());
        System.out.println("===========还可以这样表示今年2月的长度================");
        System.out.println(YearMonth.of(2021, Month.FEBRUARY).lengthOfMonth());
        System.out.println(yearMonth.of(2021, Month.FEBRUARY).lengthOfMonth());
        //不用C里面的占位符就得用Java里的字符串拼接
        System.out.printf("%d年%d月有%d天%n", LocalDateTime.now().getYear(), Month.FEBRUARY.getValue(), YearMonth.of(2021, Month.FEBRUARY).lengthOfMonth());
        System.out.printf("yearMonth %s %n", yearMonth);
        System.out.printf("yearMonth %n");
        System.out.printf("yearMonth \t");
        System.out.printf("yearMonth \n");

        System.out.println("===========判断是否是闰年的函数（方法）================");
        System.out.printf("%d年是闰年吗？-> %s %n", localDate.getYear(), localDate.isLeapYear());

        System.out.println("===========判断两个日期间隔几天,周,月,年===============");
        LocalDate workDate = LocalDate.of(2021, 9, 8);
        Period period = Period.between(workDate, localDate);
        Period between1 = Period.between(LocalDateTime.of(2021, 9, 8, 10, 50, 0).toLocalDate(), LocalDateTime.now().toLocalDate());
        Period between2 = Period.between(LocalDateTime.of(2021, Month.SEPTEMBER, 8, 10, 50, 0).toLocalDate(), LocalDateTime.now().toLocalDate());
        System.out.println(period);
        System.out.println(between1);
        System.out.println(between2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        //System.out.println(period.get(ChronoUnit.WEEKS));
        System.out.println(period.get(ChronoUnit.DAYS));

        System.out.println("===========String利用DateTimeFormatter.ISO_LOCAL_DATE和DateTimeFormatter.ISO_LOCAL_DATE_TIME两种格式化器格式成LocalDate和LocalDateTime===============");
        String dateString = "2021-11-03";
        String dateTimeString = "2021-11-03T10:10:10";
        LocalDate dateStringParse = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDateTime dateTimeStringParse = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(dateStringParse);
        System.out.println(dateTimeStringParse);

        System.out.println("===========根据不同格式日期自定义格式化器===============");
        String otherFormString = "11 03 2021";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
            LocalDate otherFormStringParse = LocalDate.parse(otherFormString, formatter);
            System.out.printf("%s is parsed as %s %n", otherFormString, otherFormStringParse);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("%s can not be parsed");
        }

        System.out.println("===========将标准日期转化成自己喜欢的格式===============");
        LocalDateTime toBeParsedString = LocalDateTime.now();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss:SSS");
            String format = toBeParsedString.format(formatter);
            System.out.println(format);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("%s格式化错误", toBeParsedString);
        }

        /*All letters 'A' to 'Z' and 'a' to 'z' are reserved as pattern letters. The following pattern letters are defined:

        Symbol  Meaning                     Presentation      Examples
        ------  -------                     ------------      -------
                G       era                         text              AD; Anno Domini; A
        u       year                        year              2004; 04
        y       year-of-era                 year              2004; 04
        D       day-of-year                 number            189
        M/L     month-of-year               number/text       7; 07; Jul; July; J
        d       day-of-month                number            10

        Q/q     quarter-of-year             number/text       3; 03; Q3; 3rd quarter
        Y       week-based-year             year              1996; 96
        w       week-of-week-based-year     number            27
        W       week-of-month               number            4
        E       day-of-week                 text              Tue; Tuesday; T
        e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
        F       week-of-month               number            3

        a       am-pm-of-day                text              PM
        h       clock-hour-of-am-pm (1-12)  number            12
        K       hour-of-am-pm (0-11)        number            0
        k       clock-hour-of-am-pm (1-24)  number            0

        H       hour-of-day (0-23)          number            0
        m       minute-of-hour              number            30
        s       second-of-minute            number            55
        S       fraction-of-second          fraction          978
        A       milli-of-day                number            1234
        n       nano-of-second              number            987654321
        N       nano-of-day                 number            1234000000

        V       time-zone ID                zone-id           America/Los_Angeles; Z; -08:30
        z       time-zone name              zone-name         Pacific Standard Time; PST
        O       localized zone-offset       offset-O          GMT+8; GMT+08:00; UTC-08:00;
        X       zone-offset 'Z' for zero    offset-X          Z; -08; -0830; -08:30; -083015; -08:30:15;
        x       zone-offset                 offset-x          +0000; -08; -0830; -08:30; -083015; -08:30:15;
        Z       zone-offset                 offset-Z          +0000; -0800; -08:00;

        p       pad next                    pad modifier      1

        '       escape for text             delimiter
        ''      single quote                literal           '
        [       optional section start
        ]       optional section end
        #       reserved for future use
        {       reserved for future use
        }       reserved for future use*/
    }
}
