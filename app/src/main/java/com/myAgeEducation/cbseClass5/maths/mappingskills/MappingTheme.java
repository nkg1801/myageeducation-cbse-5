package com.myAgeEducation.cbseClass5.maths.mappingskills;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MappingTheme
{
    private final String subject;
    private final String verb;
    private final String startImage;
    private final DirectionObject[] objects;

    public MappingTheme(String subject, String verb, String startImage, DirectionObject[] objects)
    {
        this.subject = subject;
        this.verb = verb;
        this.startImage = startImage;
        this.objects = objects;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getVerb()
    {
        return verb;
    }

    public String getStartImage()
    {
        return startImage;
    }

    public DirectionObject[] getObjects()
    {
        return objects;
    }

    private static final MappingTheme[] THEMES = {
            new MappingTheme("ant", "crawl", "ant", new DirectionObject[]{
                    new DirectionObject("laddoos"),
                    new DirectionObject("sugarcubes"),
                    new DirectionObject("bread"),
                    new DirectionObject(getRandomFruitName())
            }),
            new MappingTheme("ant", "crawl", "ant", new DirectionObject[]{
                    new DirectionObject("laddoos"),
                    new DirectionObject(getRandomFruitName()),
                    new DirectionObject("bread"),
                    new DirectionObject("toffee")
            }),
            /*new MappingTheme("honeybee", "fly", "honeybee", new DirectionObject[]{
                    new DirectionObject("rose", "rose"),
                    new DirectionObject("sunflower", "sunflower"),
                    new DirectionObject("tulip", "tulip"),
                    new DirectionObject("lily", "lily")
            }),
            new MappingTheme("rabbit", "hop", "rabbit", new DirectionObject[]{
                    new DirectionObject("carrot", "carrot"),
                    new DirectionObject("cabbage", "cabbage"),
                    new DirectionObject("lettuce", "lettuce"),
                    new DirectionObject("turnip", "turnip")
            }),
            new MappingTheme("mouse", "scurry", "mouse", new DirectionObject[]{
                    new DirectionObject("cheese", "cheese"),
                    new DirectionObject("cake", "cake"),
                    new DirectionObject("cookie", "cookie"),
                    new DirectionObject("corn", "corn")
            })*/
    };

    public static MappingTheme getRandomTheme(Random random)
    {
        return THEMES[random.nextInt(THEMES.length)];
    }

    public static String getRandomFruitName()
    {
        final String[] FRUIT_NAMES_WITH_CORRESPONDING_RESOURCE_FILE = {
                "apple", "mango", "orange", "pear", "strawberry", "watermelon"
        };

        List<String> list = Arrays.asList(FRUIT_NAMES_WITH_CORRESPONDING_RESOURCE_FILE);
        Collections.shuffle(list);
        return list.get(0);
    }
}
