package com.ysb;

import jdk.jfr.Unsigned;

import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class StringTest {
    public static void main(String[] args) {
        /*String s = "123456";
        String s1 = s.substring(0,4);
        System.out.println(s1);
        */
//        LocalDateTime time = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
//        if (time.isBefore(LocalDateTime.now())){
//            System.out.println("可以比较");
//        }
//        System.out.println(time);

        String s = String.valueOf(100);
        Integer integer = Integer.valueOf("100");
        System.out.println(s);
        System.out.println(integer);
        System.out.println("=========================");
        System.out.println("“子打碎般，睡不倒的，只害疼，一时先要预备下送终衣服。难得一个财主官人，常在贫家吃茶，但凡他宅里看病，买使女，说亲，见老身这般本分，大小事儿无不管顾老身。又布施了老身一套送终衣料，绸绢表里俱全，又有若干好绵，放在家里一年有余，不能勾做得。今年觉得好生不济，不想又撞着闰月，趁着两日倒闲，要做又被那裁缝勒掯，只推生活忙，不肯来做。老身说不得这苦也！”那妇人听了笑道：“只怕奴家做得不中意。若是不嫌时，奴这几日倒闲，出手与干娘做如何？”那婆子听了，堆下笑来说道：“若得娘子贵手做时，老身便死也得好处去。久闻娘子好针指，只是不敢来相央。”那妇人道：“这个何妨！既是许了干娘，务要与干娘做了，将历日去交[…]”\n" +
                "\n" +
                "摘录来自\n" +
                "金瓶梅完整版（古版 崇祯年间版本）\n" +
                "COAY.COM\n" +
                "此材料可能受版权保护。".length());
        String s1 = "“子打碎般，睡不倒的，只害疼，一时先要预备下送终衣服。难得一个财主官人，常在贫家吃茶，但凡他宅里看病，买使女，说亲，见老身这般本分，大小事儿无不管顾老身。又布施了老身一套送终衣料，绸绢表里俱全，又有若干好绵，放在家里一年有余，不能勾做得。今年觉得好生不济，不想又撞着闰月，趁着两日倒闲，要做又被那裁缝勒掯，只推生活忙，不肯来做。老身说不得这苦也！”那妇人听了笑道：“只怕奴家做得不中意。若是不嫌时，奴这几日倒闲，出手与干娘做如何？”那婆子听了，堆下笑来说道：“若得娘子贵手做时，老身便死也得好处去。久闻娘子好针指，只是不敢来相央。”那妇人道：“这个何妨！既是许了干娘，务要与干娘做了，将历日去交[…]”\n" +
                "\n" +
                "摘录来自\n" +
                "金瓶梅完整版（古版 崇祯年间版本）\n" +
                "COAY.COM\n" +
                "此材料可能受版权保护。";
        System.out.println(s1.length());

        String todayDate = LocalDate.now().toString();
        System.out.println(todayDate);

        List<String> list = new ArrayList<>();
        list.add("今日");
        list.add("10:00");
        list.add("11:00");
        list.add("09:00");
        list.add("13:00");
        list.add("明日");
        list.add("啊");
        list.add("波");
        list.add("超");
        list.add("中");
        list.add("白日依山尽");
        List<String> collect = list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).collect(Collectors.toList());
        System.out.println(collect);

        LocalTime now = LocalTime.now();
        System.out.println(now);
        now = now.minusMinutes(30);
        System.out.println(now);

        String[] split = "1H|\\^&|||XC8001|||||LIS||SRLT|E1394-97|20160503143342{".split("\\|");
        System.out.println(Arrays.asList(split));

        //探究中文破折号——的字符编码
        System.out.println(Integer.valueOf('-'));
        System.out.println(Integer.valueOf('_'));
        System.out.println(Integer.valueOf("——".charAt(0)));
        System.out.println(Integer.valueOf("——".charAt(1)));
        System.out.println(Integer.valueOf('—'));

        //Java正则表达式去掉标点符号
        String str = ",.!，，D_NAME。！；‘’”“**dfs  #$%^&()-+1431221\"\"中           国123漢字かどうかのjavaを決定";
        str = str.replaceAll("[\\pP\\pS\\pZ]", "");
        System.out.println(str);

        List<String> chineseList = Arrays.asList(new String[]{"张三", "李四", "王五"});
        chineseList.sort(Comparator.comparing(String::valueOf));
        System.out.printf(chineseList.toString());

        List<String> englishList = Arrays.asList(new String[]{"a", "c", "b"});
        englishList.sort(Comparator.comparing(String::valueOf));
        System.out.printf(englishList.toString());



    }
}
