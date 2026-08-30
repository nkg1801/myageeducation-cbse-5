package com.myAgeEducation.cbseClass5.science;

import com.myAgeEducation.cbseClass5.utils.ImageCodeType;

import java.util.HashMap;
import java.util.Map;

public class FixedQuestionRepository
{
    private static final Map<Integer, String[][]> FIXED_QUESTIONS = new HashMap<>();

    static {
        // Chapter 1:
        FIXED_QUESTIONS.put(1, new String[][]{
                // ID 1001
                { "The process in which a new plant grows from a seed is called _________", "germination", "sedimentation", "condensation", "evaporation", null},
                // ID 1002
                { "A plant that has light and hairy seeds _________", "Cotton", "Coconut", "Water lily", "Peas", null},
                // ID 1003
                { "A plant whose seeds get dispersed by animals _________", "Berries", "Coconut", "Water lily", "Peas", null},
                // ID 1004
                { "A plant that disperses its seeds by explosion _________", "Peas", "Coconut", "Water lily", "Cotton", null},
                // ID 1005
                { "Roots of _____ have buds from which new plants grow", "Peas", "beetroot", "rose", "", null},
                // ID 1006
                { "_____ can grow into new plants when its stem is cut and plated in soil", "Money plant", "Onions", "", "", null},
                // ID 1007
                { "Horizontal stems in strawberry that form roots at regular intervals and produce new plants are called ______", "runners", "scion", "", "", null},
                // ID 1008
                { "______ produce spores on their leaves which grow into new plants", "Ferns", "Bryophyllum", "", "", null},
                // ID 1009
                { "The part of a seed from which a new plant grows is ______", "Embryo", "Hilum", "Cotyledon", "Seed Coat", null},
                // ID 1010
                { "The seeds of ______ plant is dispersed by wind", "Cotton", "Cocklebur", "Berries", "Mistletoe", null},
                // ID 1011
                { "The plant that can reproduce by stem cutting is ______", "Bougainvillea", "Bryophyllum", "Potato", "Bean", null},
                // ID 1012
                { "Kharif crops are usually grown during the month of ______", "June-October", "November-January", "November-April", "June-August", null},
                // ID 1013
                { "Pea and wheat are ________ crops", "rabi", "kharif", "both rabi and kharif", "none of these", null},
                // ID 1014
                { "_____ seeds have one cotyledon", "Maize", "Pea", "", "", null},
                // ID 1015
                { "Seeds of _____ are dispersed away from the parent plant when their pods burst", "peas", "maple", "", "", null},
                // ID 1016
                { "_____ contain small buds called eyes from which new plant can grow", "Potatoes", "Roses", "", "", null},
                // ID 1017
                { "Tiny powdery structures seen on the leaves of ferns are called ______", "spores", "hooks", "", "", null},
                // ID 1018
                { "A ______ plant can be grown by layering", "raspberry", "rose", "", "", null},
                // ID 1019
                { "TRUE or FALSE. Dispersal of seeds avoids overcrowding of plants in one place", "TRUE", "FALSE", "", "", null},
                // ID 1020
                { "TRUE or FALSE. Rose plants has plantlets on its leaves that grow into new plants", "FALSE", "TRUE", "", "", null},
                // ID 1021
                { "TRUE or FALSE. In onion, new plants can be grown from the stem", "TRUE", "FALSE", "", "", null},
                // ID 1022
                { "TRUE or FALSE. Irrigation is done before sowing the seeds in soil", "FALSE", "TRUE", "", "", null},
                // ID 1023
                { "TRUE or FALSE. Rabi crops depend on the monsoon rains for good yield", "FALSE", "TRUE", "", "", null},
                // ID 1024
                { "A dispersal agent for wing-shaped seeds: _______", "wind", "water", "sun", "moon", null},
                // ID 1025
                { "The process in which a part of the step containing a bud is cut and planted in soil: _______", "stem cutting", "layering", "grafting", "wind dispersal", null},
                // ID 1026
                { "Plants grown in large numbers on a plot of land during a particular season: _______", "crop", "layering", "grafting", "wind dispersal", null},
                // ID 1027
                { "The practice of growing crops on a large scale in fields: _______", "agriculture", "layering", "germination", "crop", null},
                // ID 1028
                { "Identify the missing part of the seed shown in the picture below", "Cotyledon", "Embryo", "Germination", "Roots", ImageCodeType.RESOURCE_IMAGE + ";science_1028" },
                // ID 1029
                { "Identify the missing part of the seed shown in the picture below", "Hilum", "Embryo", "Roots", "Cotyledon", ImageCodeType.RESOURCE_IMAGE + ";science_1029"},
                // ID 1030
                { "Identify the missing part of the seed shown in the picture below", "Seed coat", "Embryo", "Hilum", "Cotyledon", ImageCodeType.RESOURCE_IMAGE + ";science_1030"},
                // ID 1031
                { "Identify the missing part of the seed shown in the picture below", "Baby plant", "Hilum", "Seed coat", "Cotyledon", ImageCodeType.RESOURCE_IMAGE + ";science_1031"},
                // ID 1032
                { "The farmland is protected from pests by spraying chemicals called _________", "pesticides", "fertilizers", "coconut oils", "water", null},
                // ID 1033
                { "Watering the land regularly for the crops to grow well is called _________", "irrigation", "germination", "pesticides", "fertilization", null},
                // ID 1034
                { "The fully grown crops are cut and collected for use. This process is called _________", "harvesting", "germination", "irrigation", "fertilization", null},
                // ID 1035
                { "Which of the following fruit does not have any seed?", "Banana", "Watermelon", "Apple", "Guava", null},
                // ID 1036
                { "Which of the following fruit has only one seed inside it?", "Mango", "Apple", "Guava", "Banana", null},
                // ID 1037
                { "Which of the following fruit has many seeds inside it?", "Guava", "Mango", "Banana", "", null},
                // ID 1038
                { "TRUE or FALSE. Some plants do not produce seeds", "TRUE", "FALSE", "", "", null},
                // ID 1039
                { "TRUE or FALSE. All plants grow from seeds", "FALSE", "TRUE", "", "", null},
                // ID 1040
                { "Which one of the following seeds has only one cotyledon?", "rice", "peas", "pulses", "beans", null},
                // ID 1041
                { "Which one of the following seeds has only one cotyledon?", "maize", "peas", "pulses", "beans", null},
                // ID 1042
                { "Which one of the following seeds has only one cotyledon?", "wheat", "peas", "pulses", "beans", null},
                // ID 1043
                { "Which one of the following seeds has two cotyledon?", "peas", "rice", "maize", "wheat", null},
                // ID 1044
                { "Which one of the following seeds has two cotyledon?", "beans", "rice", "maize", "wheat", null},
                // ID 1045
                { "Which one of the following statements is FALSE?", "Hilum is also known as baby plant", "Beans has two cotyledons", "All plants do not produce seeds", "Dispersal of seeds avoids overcrowding of plants in one place", null},
                // ID 1046
                { "Crops grown from November to April are called _____ crops", "rabi", "kharif", "", "", null},
                // ID 1047
                { "Which of the following plants are grown by the method of stem cutting?", "all of these", "rose", "money plant", "sugarcane", null}
        });

        // Chapter 2:
        FIXED_QUESTIONS.put(2, new String[][]{
                // ID 2001
                { "TRUE or FALSE. Prawns breathe with the help of gills", "TRUE", "FALSE", "", "", null},
                // ID 2002
                { "TRUE or FALSE. Insects have only two spiracles for breathing", "FALSE", "TRUE", "", "", null},
                // ID 2003
                { "TRUE or FALSE. Gills are the breathing organs of mammals", "FALSE", "TRUE", "", "", null},
                // ID 2004
                { "TRUE or FALSE. Seals swim with the help of flippers", "TRUE", "FALSE", "", "", null},
                // ID 2005
                { "TRUE or FALSE. A grasshopper hops with the help of its hind legs", "TRUE", "FALSE", "", "", null},
                // ID 2006
                { "TRUE or FALSE. The thick fur of polar bears keeps them warm in cold weather", "TRUE", "FALSE", "", "", null},
                // ID 2007
                { "TRUE or FALSE. Snakes do not have legs", "TRUE", "FALSE", "", "", null},
                // ID 2008
                {
                        "TRUE or FALSE. All insects have wings",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 2009
                {
                        "TRUE or FALSE. Water boatman swims in water using its legs",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 2010
                {
                        "TRUE or FALSE. None of the birds migrate during the winter season",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 2011
                {
                        "Identify the animal that belongs to the desert habitat",
                        "Camel",
                        "Penguin",
                        "Seal",
                        "Walrus",
                        null},
                // ID 2012
                {
                        "Which of these is considered to be the largest habitat of the world?",
                        "Ocean",
                        "Forest",
                        "Desert",
                        "Freshwater",
                        null},
                // ID 2013
                {
                        "Jellyfish belong to which of these habitats?",
                        "Ocean",
                        "Freshwater",
                        "Desert",
                        "Polar",
                        null},
                // ID 2014
                {
                        "Identify the animal that has shell as its body covering",
                        "Tortoise",
                        "Lizard",
                        "Yak",
                        "Crocodile",
                        null},
                // ID 2015
                {
                        "Which of these animals use flippers for its movement?",
                        "Penguin",
                        "Lizard",
                        "Frog",
                        "Snake",
                        null},
                // ID 2016
                {
                        "The environment where organisms naturally live and reproduce is called ________",
                        "habitat",
                        "atmosphere",
                        "",
                        "",
                        null},
                // ID 2017
                {
                        "The habitat present in Antarctica is ________",
                        "polar",
                        "freshwater",
                        "",
                        "",
                        null},
                // ID 2018
                {
                        "The body covering of fish is ________",
                        "scales",
                        "shell",
                        "",
                        "",
                        null},
                // ID 2019
                {
                        "The habitat with sandy lands and less rainfall is ________",
                        "desert",
                        "forest",
                        "ocean",
                        "freshwater",
                        null},
                // ID 2020
                {
                        "Microscopic organisms breathe using their ________",
                        "body surface",
                        "lungs",
                        "",
                        "",
                        null},
                // ID 2021
                {
                        "________ use hindlimbs to stand, walk and run",
                        "Humans",
                        "Crocodiles",
                        "",
                        "",
                        null},
                // ID 2022
                {
                        "The movement of animals in large groups from one place to another is search of food and warmth is called ______",
                        "migration",
                        "polarization",
                        "",
                        "",
                        null},
                // ID 2023
                {
                        "________ animals move with the help of fins, tail, flippers and webbed feet",
                        "Aquatic",
                        "Land",
                        "",
                        "",
                        null},
                // ID 2024
                {
                        "Reptiles such as lizards and crocodiles crawl using their short _____",
                        "legs",
                        "fins",
                        "skin",
                        "feathers",
                        null},
                // ID 2025
                {
                        "______ habitats usually have a large number of plants and trees.",
                        "Forest",
                        "Desert",
                        "Polar Regions and Mountains",
                        "Ocean",
                        null},
                // ID 2026
                {
                        "______ habitats are sandy lands with scanty rainfall.",
                        "Desert",
                        "Forest",
                        "Polar Regions and Mountains",
                        "Ocean",
                        null},
                // ID 2027
                {
                        "Which one of the following is the largest habitat of the world?",
                        "Oceans",
                        "Forest",
                        "Desert",
                        "Polar Regions and Mountains",
                        null},
                // ID 2028
                {
                        "______ habitat include various ponds, lakes, streams and rivers",
                        "Freshwater",
                        "Forest",
                        "Polar Regions and Mountains",
                        "Oceans",
                        null},
                // ID 2029
                {
                        "Camels belong to which of the following habitat?",
                        "Desert",
                        "Forest",
                        "Polar Regions and Mountains",
                        "Oceans",
                        null},
                // ID 2030
                {
                        "Lions belong to which of the following habitat?",
                        "Forest",
                        "Desert",
                        "Polar Regions and Mountains",
                        "Oceans",
                        null},
                // ID 2031
                {
                        "Whales belong to which of the following habitat?",
                        "Ocean",
                        "Forest",
                        "Desert",
                        "Polar Regions and Mountains",
                        null},
                // ID 2032
                {
                        "Most aquatic animals such as fish and prawns breathe with the help of ______",
                        "gills",
                        "lungs",
                        "skin",
                        "spiracles",
                        null},
                // ID 2033
                {
                        "Insects have special structures for breathing known as the __________",
                        "spiracles",
                        "gills",
                        "lungs",
                        "skin",
                        null},
                // ID 2034
                {
                        "What is blubber?",
                        "A thick layer of fat under the skin of animals that live in very cold places",
                        "The breathing organs of insects",
                        "The process of shedding old skin to replace with new one",
                        "The environment where an organism lives",
                        null},
                // ID 2035
                {
                        "What is moulting?",
                        "The process of shedding old skin to replace with new one",
                        "The breathing organs of insects",
                        "A thick layer of fat under the skin of animals that live in very cold places",
                        "The environment where an organism lives",
                        null},
                // ID 2036
                {
                        "Which of the following animals breathes throught its gills?",
                        "prawns",
                        "earthworm",
                        "cockroach",
                        "dolphin",
                        null},
                // ID 2037
                {
                        "Birds which swim in water have ______",
                        "webbed feet",
                        "broad wings",
                        "long beaks",
                        "toes with claws",
                        null}
        });

        // Chapter 3:
        FIXED_QUESTIONS.put(3, new String[][]{
                // ID 3001
                {
                        "TRUE or FALSE. Bones and musles work together to bring about movement",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 3002
                {
                        "TRUE or FALSE. Gliding joints are found between the small bones in the vetebral column",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 3003
                {
                        "TRUE or FALSE. The medulla controls our intelligence, memory, logic and sense orgrans",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 3004
                {
                        "TRUE or FALSE. The nervous system is made up of the brain, the heart and the nerves",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 3005
                {
                        "TRUE or FALSE. The skin is the largest organ in our body",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 3006
                {
                        "The skeletal system is made up of _____ bones",
                        "206",
                        "600",
                        "606",
                        "238",
                        null},
                // ID 3007
                {
                        "There are about _____ muscles in our body",
                        "600",
                        "206",
                        "606",
                        "238",
                        null},
                // ID 3008
                {
                        "The backbone is made up of ______ small bones",
                        "33",
                        "35",
                        "206",
                        "606",
                        null},
                // ID 3009
                {
                        "________ is a tough cord that connects the muscle to the bone",
                        "tendon",
                        "rib",
                        "bone",
                        "muscle",
                        null},
                // ID 3010
                {
                        "The joint in the ________ allows movement in all directions.",
                        "shoulder",
                        "rib",
                        "muscle",
                        "tendon",
                        null},
                // ID 3011
                {
                        "Voluntary muscles are attached to the ________ in the body.",
                        "skeleton",
                        "rib",
                        "muscle",
                        "tendon",
                        null},
                // ID 3012
                {
                        "______ pairs of ribs are joined to the breastbone.",
                        "10",
                        "11",
                        "13",
                        "15",
                        null},
                // ID 3013
                {
                        "The function of the skeletal system is to give ______ to the body.",
                        "All of these",
                        "support",
                        "shape",
                        "strength",
                        null},
                // ID 3014
                {
                        "The joint between the skull and the backbone is ________.",
                        "pivot",
                        "ball and socket",
                        "hinge",
                        "gliding",
                        null},
                // ID 3015
                {
                        "Ten pairs of ribs are connected in the front to the ________.",
                        "sternum",
                        "backbone",
                        "brain",
                        "nerves",
                        null},
                // ID 3016
                {
                        "Which of these structures protects the brain?",
                        "Skull",
                        "Backbone",
                        "Ribcage",
                        "Forelimb",
                        null},
                // ID 3017
                {
                        "Most reflex actions that take place in our body are controlled by ______",
                        "spinal cord",
                        "brain",
                        "ribs",
                        "joints",
                        null},
                // ID 3018
                {
                        "______ protects the soft internal organs of our body",
                        "Skeleton",
                        "Nerves",
                        "",
                        "",
                        null},
                // ID 3019
                {
                        "The _____ controls everything that the body does",
                        "brain",
                        "bones",
                        "",
                        "",
                        null},
                // ID 3020
                {
                        "_____ muscles are attached to the skeleton",
                        "Voluntary",
                        "Involuntary",
                        "",
                        "",
                        null},
                // ID 3021
                {
                        "Most of the joints in the skull are ______",
                        "immovable",
                        "movable",
                        "",
                        "",
                        null},
                // ID 3022
                {
                        "The nasal cavity is separated from the mouth by a bony structure called ______",
                        "palate",
                        "cranium",
                        "",
                        "",
                        null},
                // ID 3023
                {
                        "The longest bone in the human body:",
                        "femur",
                        "humerus",
                        "",
                        "",
                        null},
                // ID 3024
                {
                        "A place where two bones meet:",
                        "joint",
                        "junction",
                        "",
                        "",
                        null},
                // ID 3025
                {
                        "A type of joint in the shoulder:",
                        "Ball and Socket Joint",
                        "Hinge Joint",
                        "Pivot Joint",
                        "Gliding Joint",
                        null},
                // ID 3026
                {
                        "The system that controls everything you do:",
                        "nervous system",
                        "skeletal system",
                        "",
                        "",
                        null},
                // ID 3027
                {
                        "The part of the brain that helps us to maintain balance of our body:",
                        "Cerebellum",
                        "Cerebrum",
                        "",
                        "",
                        null},
                // ID 3028
                {
                        "Many bones are hollow and filled with a substance called ________",
                        "bone marrow",
                        "blood",
                        "cartiledge",
                        "calcium",
                        null},
                // ID 3029
                {
                        "TRUE or FALSE. Bone marrow produces blood cells",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 3030
                {
                        "The skull has _____ bones",
                        "22",
                        "33",
                        "11",
                        "23",
                        null},
                // ID 3031
                {
                        "Of all the bones in the skull, only the _____________ can move",
                        "lower jawbone",
                        "upper jawbone",
                        "nose bone",
                        "ear bone",
                        null},
                // ID 3032
                {
                        "The backbone is made up of 33 bones called the _______",
                        "vertebrae",
                        "upper jawbone",
                        "lower jawbone",
                        "cartilage",
                        null},
                // ID 3033
                {
                        "The frame of bones that forms a cage-like structure in the chest area is called the _______",
                        "ribcage",
                        "bone marrow",
                        "vertebrae",
                        "cartilage",
                        null},
                // ID 3034
                {
                        "The ribcage is made up of ______ pairs of long curved bones called the rib",
                        "12",
                        "10",
                        "14",
                        "16",
                        null},
                // ID 3035
                {
                        "The breastbone is also called _______",
                        "sternum",
                        "ribcage",
                        "vertebrae",
                        "cartilage",
                        null},
                // ID 3036
                {
                        "The 2 pair of ribs that are not attached to the breastbone are called the _______",
                        "floating ribs",
                        "ribcage",
                        "vertebrae",
                        "cartilage",
                        null},
                // ID 3037
                {
                        "Identify and name the bone marked as '?' in the picture.",
                        "sternum",
                        "ribcage",
                        "vertebrae",
                        "cartilage",
                        ImageCodeType.RESOURCE_IMAGE + ";science_3037"},
                // ID 3038
                {
                        "Identify and name the bone marked as '?' in the picture.",
                        "humerus",
                        "sternum",
                        "vertebrae",
                        "cartilage",
                        ImageCodeType.RESOURCE_IMAGE + ";science_3038"},
                // ID 3039
                {
                        "Identify and name the bone shown in the picture.",
                        "backbone",
                        "sternum",
                        "humerus",
                        "femur",
                        ImageCodeType.RESOURCE_IMAGE + ";science_3039"},
                // ID 3040
                {
                        "The muscles that are under our control are called _______ muscles.",
                        "voluntary",
                        "involuntary",
                        "",
                        "",
                        null},
                // ID 3041
                {
                        "The muscles that are NOT under our control are called _______ muscles.",
                        "involuntary",
                        "voluntary",
                        "",
                        "",
                        null},
                // ID 3042
                {
                        "Muscles in the arms and legs are _______ muscles.",
                        "voluntary",
                        "involuntary",
                        "",
                        "",
                        null},
                // ID 3043
                {
                        "Muscles of the heart are _______ muscles.",
                        "involuntary",
                        "voluntary",
                        "",
                        "",
                        null},
                // ID 3044
                {
                        "Muscles of the digestive system are _______ muscles.",
                        "involuntary",
                        "voluntary",
                        "",
                        "",
                        null},
                // ID 3045
                {
                        "The substance or the tissue that joins two bones or holds together two bones in place is called a ______.",
                        "ligament",
                        "joint",
                        "cartilage",
                        "femur",
                        null},
                // ID 3046
                {
                        "This type of joint is found in the shoulder and hip regions.",
                        "Ball and Socket Joint",
                        "Hinge Joint",
                        "Pivot Joint",
                        "Gliding Joint",
                        null},
                // ID 3047
                {
                        "This type of joint is found in the elbows, fingers, knees and toes.",
                        "Hinge Joint",
                        "Ball and Socket Joint",
                        "Pivot Joint",
                        "Gliding Joint",
                        null},
                // ID 3048
                {
                        "This type of joint is found between the skull and the backbone.",
                        "Pivot Joint",
                        "Ball and Socket Joint",
                        "Hinge Joint",
                        "Gliding Joint",
                        null},
                // ID 3049
                {
                        "This type of joint is present in the ankles and the wrists.",
                        "Gliding Joint",
                        "Ball and Socket Joint",
                        "Hinge Joint",
                        "Pivot Joint",
                        null},
                // ID 3050
                {
                        "The ______ protects the spinal cord inside it, which is connected to the brain in the skull.",
                        "backbone",
                        "femur",
                        "humerus",
                        "Gliding Joint",
                        null},
                // ID 3051
                {
                        "The skull protects the ______.",
                        "brain",
                        "spinal cord",
                        "liver",
                        "heart",
                        null},
                // ID 3052
                {
                        "The part of the skull that protects the brain is called ______.",
                        "cranium",
                        "cerebrum",
                        "cerebellum",
                        "medulla",
                        null},
                // ID 3053
                {
                        "_________ is the largest part of the brain. It controls our intelligence, memory, logic and sense organs.",
                        "Cerebrum",
                        "Cranium",
                        "Cerebellum",
                        "Medulla",
                        null},
                // ID 3054
                {
                        "_________ is the second largest part of the brain and is present behind the cerebrum. It controls balance and posture of our body.",
                        "Cerebellum",
                        "Cranium",
                        "Cerebrum",
                        "Medulla",
                        null},
                // ID 3055
                {
                        "_________ connects the brain to the spinal cord.",
                        "Medulla",
                        "Cranium",
                        "Cerebrum",
                        "Cerebellum",
                        null},
                // ID 3056
                {
                        "Which of the following is not a part of the brain?",
                        "Cranium",
                        "Cerebrum",
                        "Cerebellum",
                        "Medulla",
                        null},
                // ID 3057
                {
                        "_______ is protected inside the the backbone",
                        "Spinal Cord",
                        "Cranium",
                        "Cerebrum",
                        "Cerebellum",
                        null},
                // ID 3058
                {
                        "_______ are bundles of long, thin, thread-like structures that carry messages between the brain or spinal cord and other parts of the body",
                        "Nerves",
                        "Cranium",
                        "Cerebrum",
                        "Spinal Cord",
                        null},
                // ID 3059
                {
                        "The coloured part of our eyes is called the _______",
                        "iris",
                        "cerebrum",
                        "pupil",
                        "nerve",
                        null},
                // ID 3060
                {
                        "The black circle in the center of the eye is called the _______",
                        "pupil",
                        "iris",
                        "cerebrum",
                        "nerve",
                        null},
                // ID 3061
                {
                        "The inner part of our eye has a very think layer of tissues called the _______ which captures the light that enters the eye and sends it to the brain through the optic nerve",
                        "retina",
                        "iris",
                        "pupil",
                        "nerve",
                        null},
                // ID 3062
                {
                        "The nose has two holes called _______",
                        "nostrils",
                        "retina",
                        "pupil",
                        "nerve",
                        null},
                // ID 3063
                {
                        "The outer part of the ear that we can see is called the ______",
                        "pinna",
                        "nostrils",
                        "pupil",
                        "nerve",
                        null},
                // ID 3064
                {
                        "Identify and name the part of the brain marked with '?' in the picture.",
                        "Cerebellum",
                        "Cranium",
                        "Cerebrum",
                        "Medulla",
                        ImageCodeType.RESOURCE_IMAGE + ";science_3064"},
                // ID 3065
                {
                        "Identify and name the part of the brain marked with '?' in the picture.",
                        "Cerebrum",
                        "Cranium",
                        "Cerebellum",
                        "Medulla",
                        ImageCodeType.RESOURCE_IMAGE + ";science_3065"},
                // ID 3066
                {
                        "Identify and name the part of the brain marked with '?' in the picture.",
                        "Brain stem",
                        "Cranium",
                        "Cerebrum",
                        "Cerebellum",
                        ImageCodeType.RESOURCE_IMAGE + ";science_3065"},
                // ID 3067
                {
                        "What are floating ribs?",
                        "The 2 pair of ribs that are not attached to the breastbone",
                        "The top pair of ribs",
                        "The pair of ribs that are attached to the breastbone",
                        "the first 5 pair of ribs",
                        null},
                // ID 3068
                {
                        "The ________ on the tongue help us to identify different tastes by sending signals to the brain.",
                        "taste buds",
                        "medulla",
                        "brain stem",
                        "cranium",
                        null},
                // ID 3069
                {
                        "TRUE or FALSE. Nerves protects the soft internal organs of our body.",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 3070
                {
                        "TRUE or FALSE. Bones control everything that the body does.",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 3071
                {
                        "TRUE or FALSE. Most of the joints in the skull are movable.",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 3072
                {
                        "The ribs marked in green are _________.",
                        "floating ribs",
                        "sternum",
                        "breastbone",
                        "backbone",
                        ImageCodeType.RESOURCE_IMAGE + ";science_3072"},
                // ID 3073
                {
                        "TRUE or FALSE. We have 10 sense organs",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 3074
                {
                        "Which sense organ helps us to feel hot or cold?",
                        "skin",
                        "eyes",
                        "nose",
                        "forehead",
                        null},
                // ID 3075
                {
                        "The five sense organs are ___, ___, ____, ___ and ____.",
                        "eyes, ears, nose, tongue and skin",
                        "hands, legs, eyes, ears and head",
                        "",
                        "",
                        null},
                // ID 3076
                {
                        "The nerves that control digestion and heart beat are ______",
                        "motor nerves",
                        "sensory nerves",
                        "mixed nerves",
                        "automatic nerves",
                        null},
                // ID 3077
                {
                        "Muscles are attached to the bones by strong tissues called _______",
                        "tendons",
                        "ligaments",
                        "ribs",
                        "joint",
                        null},
                // ID 3078
                {
                        "Which of the following has a hinge joint?",
                        "knee",
                        "shoulder",
                        "wrist",
                        "ankle",
                        null},
                // ID 3079
                {
                        "The other name of the bony box that protects the brain is ______",
                        "cranium",
                        "cervix",
                        "ribcage",
                        "spine",
                        null},
                // ID 3080
                {
                        "The largest external organ that is also a sense organ is the ______",
                        "skin",
                        "nose",
                        "eye",
                        "ear",
                        null}
        });

        // Chapter 4:
        FIXED_QUESTIONS.put(4, new String[][]{
                // ID 4001
                {
                        "TRUE or FALSE. Proteins are the building materials of our body parts",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 4002
                {
                        "TRUE or FALSE. Vaccination can prevent communicable diseases",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 4003
                {
                        "TRUE or FALSE. Viruses and fungi cause non-communicable diseases",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 4004
                {
                        "TRUE or FALSE. We can have a balanced diet when we eat a variety of food in adequate amounts",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 4005
                {
                        "TRUE or FALSE. Plenty of fluids and bed rest can decrease the symptoms of measles to some extent",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 4006
                {
                        "Which of these are macronutrients?",
                        "Fats",
                        "Vitamins",
                        "Dietary fibres",
                        "Minerals",
                        null},
                // ID 4007
                {
                        "Our bones and teeth will be well developed when we eat foods rich in _______",
                        "minerals",
                        "fats",
                        "sugars",
                        "All of these",
                        null},
                // ID 4008
                {
                        "Which of the following is a communicable disease?",
                        "All of these",
                        "Typhoid",
                        "Malaria",
                        "Cholera",
                        null},
                // ID 4009
                {
                        "Vitamin B1 deficiency causes ________",
                        "weight loss",
                        "softening of bones",
                        "blindness",
                        "weight gain",
                        null},
                // ID 4010
                {
                        "Citrus fruits and tomatoes should be eaten to avoid ________",
                        "scurvy",
                        "anaemia",
                        "night blindness",
                        "goiter",
                        null},
                // ID 4011
                {
                        "Nutrients required in small quantities in our daily diet are called ______",
                        "micronutrients",
                        "macronutrients",
                        "",
                        "",
                        null},
                // ID 4012
                {
                        "_________ are required for the physical and mental development of the body",
                        "Minerals",
                        "Vitamins",
                        "",
                        "",
                        null},
                // ID 4013
                {
                        "We should drink at least _________ glasses of water daily",
                        "8-10",
                        "1-3",
                        "",
                        "",
                        null},
                // ID 4014
                {
                        "Non-communicable diseases can be avoided by following a good _________.",
                        "diet",
                        "hygiene",
                        "",
                        "",
                        null},
                // ID 4015
                {
                        "Vometing and dehydration are the symptoms of _________.",
                        "cholera",
                        "chicken pox",
                        "",
                        "",
                        null},
                // ID 4016
                {
                        "TRUE or FALSE. Viruses and fungi cause communicable diseases",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 4017
                {
                        "TRUE or FALSE. Vometing and dehydration are the symptoms of cholera",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 4018
                {
                        "Scurvy is caused due to the deficiency of _________",
                        "Vitamin C",
                        "Vitamin A",
                        "Vitamin B1",
                        "Vitamin D",
                        null},
                // ID 4019
                {
                        "Anaemia is caused due to the deficiency of _________",
                        "iron",
                        "Vitamin B1",
                        "iodine",
                        "Vitamin D",
                        null},
                // ID 4020
                {
                        "TRUE or FALSE. Vaccination can prevent non-communicable diseases",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 4021
                {
                        "Night blindness is due to the deficiency of _________",
                        "Vitamin A",
                        "iron",
                        "Vitamin B1",
                        "Vitamin D",
                        null},
                // ID 4022
                {
                        "Beriberi is due to the deficiency of _________",
                        "Vitamin B1",
                        "iron",
                        "Vitamin A",
                        "Vitamin D",
                        null},
                // ID 4023
                {
                        "Rickets is due to the deficiency of _________",
                        "Vitamin D",
                        "iron",
                        "Vitamin B1",
                        "Vitamin A",
                        null},
                // ID 4024
                {
                        "Goitre is due to the deficiency of _________",
                        "iodine",
                        "iron",
                        "Vitamin A",
                        "Vitamin D",
                        null},
                // ID 4025
                {
                        "Kwashiorkor is due to the deficiency of _________",
                        "protein",
                        "iron",
                        "iodine",
                        "Vitamin D",
                        null},
                // ID 4026
                {
                        "_________ diseases are mostly caused by the deficiency of adequate amounts of nutrients in the diet",
                        "non-communicable",
                        "communicable",
                        "",
                        "",
                        null},
                // ID 4027
                {
                        "_________ diseases are also called deficiency disorders",
                        "non-communicable",
                        "communicable",
                        "",
                        "",
                        null},
                // ID 4028
                {
                        "A disease that cannot be passed on from an infected person to a healthy person is called __________ disease.",
                        "non-communicable",
                        "communicable",
                        "",
                        "",
                        null},
                // ID 4029
                {
                        "Which of the following disease can be prevented by vaccination",
                        "Chickenpox",
                        "Anaemia",
                        "Beriberi",
                        "Scurvy",
                        null},
                // ID 4030
                {
                        "Which of the following disease cannot be prevented by vaccination",
                        "Anaemia",
                        "Chickenpox",
                        "Measles",
                        "",
                        null},
                // ID 4031
                {
                        "Typhoid is caused by ___________",
                        "Bacteria",
                        "Virus",
                        "Protozoa",
                        "Vitamin-A deficiency",
                        null},
                // ID 4032
                {
                        "Malaria is caused by ___________",
                        "Protozoa",
                        "Virus",
                        "Bacteria",
                        "Vitamin-A deficiency",
                        null},
                // ID 4033
                {
                        "Cholera is caused by ___________",
                        "Bacteria",
                        "Virus",
                        "Protozoa",
                        "Vitamin-A deficiency",
                        null},
                // ID 4034
                {
                        "Chickenpox is caused by ___________",
                        "Virus",
                        "Bacteria",
                        "Protozoa",
                        "Vitamin-A deficiency",
                        null},
                // ID 4035
                {
                        "Measles is caused by ___________",
                        "Virus",
                        "Bacteria",
                        "Protozoa",
                        "Vitamin-A deficiency",
                        null},
                // ID 4036
                {
                        "Flu is caused by ___________",
                        "Virus",
                        "Bacteria",
                        "Protozoa",
                        "Vitamin-A deficiency",
                        null},
                // ID 4037
                {
                        "A person is showing the following symptoms: Fever, chills, sweats, headaches, vomitting and body ache. What disease he might be suffering from?",
                        "Malaria",
                        "Flu",
                        "Scurvy",
                        "Anaemia",
                        null},
                // ID 4038
                {
                        "A person is showing the following symptoms: Vomitting, dehydration, diarrhoea. What disease he might be suffering from?",
                        "Cholera",
                        "Malaria",
                        "Flu",
                        "Anaemia",
                        null},
                // ID 4039
                {
                        "A person is showing the following symptoms: Irritation, swelling of joints, bleeding gums. What disease he might be suffering from?",
                        "Scurvy",
                        "Malaria",
                        "Flu",
                        "Anaemia",
                        null},
                // ID 4040
                {
                        "A boy is showing the following symptoms: Softening and weakening of bones. What disease he might be suffering from?",
                        "Rickets",
                        "Malaria",
                        "Scurvy",
                        "Anaemia",
                        null},
                // ID 4041
                {
                        "A person is showing the following symptoms: Deafness, swelling in the neck. What disease he might be suffering from?",
                        "Goitre",
                        "Rickets",
                        "Scurvy",
                        "Anaemia",
                        null},
                // ID 4042
                {
                        "Rice, wheat, ripe fruits, sugar, honey and potatoes are rich in _________",
                        "carbohydrates",
                        "fats",
                        "proteins",
                        "vitamins",
                        null},
                // ID 4043
                {
                        "Butter, oil, ghee are rich in _________",
                        "fats",
                        "carbohydrates",
                        "proteins",
                        "vitamins",
                        null},
                // ID 4044
                {
                        "Pulses, fish, eggs, milk are rich in _________",
                        "proteins",
                        "carbohydrates",
                        "fats",
                        "vitamins",
                        null},
                // ID 4045
                {
                        "Green leafy vegetables, carrot, fruits are rich in _________",
                        "vitamins",
                        "carbohydrates",
                        "fats",
                        "proteins",
                        null},
                // ID 4046
                {
                        "Which of the following symptoms indicate that the person is suffering from Goitre?",
                        "Swelling in the neck",
                        "Softening and weakening of bones",
                        "Night blindness",
                        "Bleeding gums",
                        null},
                // ID 4047
                {
                        "Which of the following symptoms indicate that the person is suffering from Rickets?",
                        "Softening and weakening of bones",
                        "Swelling in the neck",
                        "Night blindness",
                        "Bleeding gums",
                        null},
                // ID 4048
                {
                        "Which of the following symptoms indicate that the person is suffering from Scurvy?",
                        "Bleeding gums",
                        "Swelling in the neck",
                        "Softening and weakening of bones",
                        "Night blindness",
                        null},
                // ID 4049
                {
                        "TRUE or FALSE. Scurvy, Rickets and Goitre are communicable diseases",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 4050
                {
                        "Which of the following diseases can spread from an infected person to a healthy person?",
                        "Malaria",
                        "Rickets",
                        "Scurvy",
                        "Anaemia",
                        null},
                // ID 4051
                {
                        "Which of the following diseases can spread from an infected person to a healthy person?",
                        "Chickenpox",
                        "Rickets",
                        "Scurvy",
                        "Anaemia",
                        null},
                // ID 4052
                {
                        "Which of the following diseases can spread from an infected person to a healthy person?",
                        "Cholera",
                        "Rickets",
                        "Scurvy",
                        "Anaemia",
                        null},
                // ID 4053
                {
                        "Which of the following diseases cannot spread from an infected person to a healthy person?",
                        "Anaemia",
                        "Cholera",
                        "Chickenpox",
                        "Malaria",
                        null},
                // ID 4054
                {
                        "Which of the following diseases cannot spread from an infected person to a healthy person?",
                        "Scurvy",
                        "Cholera",
                        "Chickenpox",
                        "Malaria",
                        null},
                // ID 4055
                {
                        "Which of the following diseases cannot spread from an infected person to a healthy person?",
                        "Rickets",
                        "Cholera",
                        "Chickenpox",
                        "Malaria",
                        null},
                // ID 4056
                {
                        "What kind of disease can be spread from person to person?",
                        "Communicable",
                        "Non-communicable",
                        "All diseases can be spread",
                        "No diseases are spread person to person",
                        null},
                // ID 4057
                {
                        "What is the difference between a communicable disease and a noncommunicable disease?",
                        "A communicable disease can be passed from person to person, a noncommunicable disease cannot.",
                        "A communicable disease cannot be passed from person to person, while a noncommunicable disease can be.",
                        "",
                        "",
                        null},
                // ID 4058
                {
                        "Rohan is suffering from anaemia. He should be given a diet rich in ______",
                        "Iron",
                        "Iodine",
                        "Vitamin D",
                        "Protein",
                        null}
        });

        // Chapter 5:
        FIXED_QUESTIONS.put(5, new String[][]{
                // ID 5001
                {
                        "_____ can cause fire outburst",
                        "Electrical faults",
                        "Fire engines",
                        "",
                        "",
                        null},
                // ID 5002
                {
                        "A small fire can be put out using a fire ________",
                        "extinguisher",
                        "engine",
                        "",
                        "",
                        null},
                // ID 5003
                {
                        "_____ clothes do not catch fire easily",
                        "Cotton",
                        "Nylon",
                        "",
                        "",
                        null},
                // ID 5004
                {
                        "_____ down on the ground puts off the flames on your clothes",
                        "Rolling",
                        "Bending",
                        "",
                        "",
                        null},
                // ID 5005
                {
                        "An elastic bandage can be wrapped around a _______ part",
                        "sprained",
                        "fractured",
                        "",
                        "",
                        null},
                // ID 5006
                {
                        "Fire needs ______ to keep burning",
                        "air",
                        "water",
                        "smoke",
                        "light",
                        null},
                // ID 5007
                {
                        "Nylon or synthetic clothes should not be worn while bursting firecrackers or while _______",
                        "cooking",
                        "going out",
                        "sitting",
                        "playing",
                        null},
                // ID 5008
                {
                        "In case of minor burns, keep the burnt area under _______",
                        "cold running water",
                        "hot water",
                        "boiling water",
                        "salt solution",
                        null},
                // ID 5009
                {
                        "Rabies is caused by _______",
                        "animal bites",
                        "snakebites",
                        "gas leak",
                        "fracture",
                        null},
                // ID 5010
                {
                        "Vinegar of lemon juice can be applied for _______",
                        "wasp stings",
                        "bee stings",
                        "burns",
                        "cuts",
                        null},
                // ID 5011
                {
                        "Mud or sand is thrown over it to put it out:",
                        "fire",
                        "lights",
                        "air",
                        "water",
                        null},
                // ID 5012
                {
                        "Firefighters put out fire with the help of this:",
                        "fire engine",
                        "lights",
                        "air",
                        "fire extinguisher",
                        null},
                // ID 5013
                {
                        "A cloth that is tied around the neck to support a broken arm:",
                        "Sling",
                        "Blister",
                        "Splint",
                        "Bag",
                        null},
                // ID 5014
                {
                        "A disease that can be caused by an animal bite:",
                        "rabies",
                        "cholera",
                        "typhoid",
                        "malaria",
                        null},
                // ID 5015
                {
                        "TRUE or FALSE. You should light the firecrackers only in the presence of an adult.",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 5016
                {
                        "TRUE or FALSE. You should wear only synthetic clothes while lighting crackers.",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 5017
                {
                        "TRUE or FALSE. Always run while crossing the road so that you can reach the other end fast",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 5018
                {
                        "TRUE or FALSE. As soon as you find a zebra crossing, run towards the other end without waiting for the signal",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 5019
                {
                        "How would you prevent fire accidents in case of gas leak in your kitchen?",
                        "Open all doors and windows",
                        "Starting cooking something",
                        "Switch on lights of the kitchen",
                        "Strike a matchstick to burn a candle",
                        null},
                // ID 5020
                {
                        "Which of the following you should not do if there is a gas leak in your kitchen?",
                        "Switch on lights of the kitchen",
                        "Open all doors and windows",
                        "",
                        "",
                        null},
                // ID 5021
                {
                        "Which of the following you should not do if there is a gas leak in your kitchen?",
                        "Starting cooking something",
                        "Open all doors and windows",
                        "",
                        "",
                        null},
                // ID 5022
                {
                        "TRUE or FALSE. Faulty gas pipes in your kitchen should be replaced immediately to prevent fire accidents",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 5023
                {
                        "TRUE or FALSE. In case your clothes catch fire, start running around to put off the fire.",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 5024
                {
                        "_______ is the first or immediate help given to an injured person before he or she is taken to a doctor.",
                        "First aid",
                        "Fracture",
                        "",
                        "",
                        null},
                // ID 5025
                {
                        "A break or crack in the bone is called a ________.",
                        "fracture",
                        "first aid",
                        "sprain",
                        "",
                        null},
                // ID 5026
                {
                        "Sometimes, the ankle or wrist can get twisted and cause pain. This is called a ________.",
                        "sprain",
                        "first aid",
                        "fracture",
                        "",
                        null},
                // ID 5027
                {
                        "The bites of stray animals like dogs, cats and monkeys can cause a disease called _______.",
                        "rabies",
                        "beriberi",
                        "malaria",
                        "rickets",
                        null},
                // ID 5028
                {
                        "Which of the following first aid should be given for a snakebite victim?",
                        "A tight bandage should be tied just above the wound",
                        "Ice cubes should be placed on the wound",
                        "",
                        "",
                        null}
        });

        // Chapter 6:
        FIXED_QUESTIONS.put(6, new String[][]{
                // ID 6001
                {"TRUE or FALSE. Air exerts pressure always in the upward direction.", "FALSE", "TRUE", "", "", null},
                // ID 6002
                {"TRUE or FALSE. Plants cannot use nitrogen directly from the atmosphere.", "TRUE", "FALSE", "", "", null},
                // ID 6003
                {"TRUE or FALSE. Stratosphere is the coldest among all the atmospheric layers", "FALSE", "TRUE", "", "", null},
                // ID 6004
                {"TRUE or FALSE. Soluble impurities do not dissolve in water", "FALSE", "TRUE", "", "", null},
                // ID 6005
                {"TRUE or FALSE. Decanted water is the purest form of water", "FALSE", "TRUE", "", "", null},
                // ID 6006
                {
                        "The most abundant gas in the atmosphere is:",
                        "Nitrogen",
                        "Oxygen",
                        "Carbon dioxide",
                        "Water vapour",
                        null},
                // ID 6007
                {
                        "_______ is the gas that is used in photosynthesis",
                        "Carbon dioxide",
                        "Nitrogen",
                        "Oxygen",
                        "Water vapour",
                        null},
                // ID 6008
                {
                        "Where is the ozone layer found?",
                        "Stratosphere",
                        "Troposphere",
                        "Exosphere",
                        "Mesphere",
                        null},
                // ID 6009
                {
                        "In water purification, alum is added during the process of:",
                        "Sedimentation",
                        "Filtration",
                        "Aeration",
                        "Chlorination",
                        null},
                // ID 6010
                {
                        "Which of the following chemicals is used to kill germs during water purification:",
                        "Chlorine",
                        "Fertilizer",
                        "Alum",
                        "Argon",
                        null},
                // ID 6011
                {
                        "______ is responsible for rusting",
                        "Water vapour",
                        "Dust",
                        "",
                        "",
                        null},
                // ID 6012
                {
                        "The Earth is surrounded by a thick envelope of air called the ________",
                        "atmosphere",
                        "ionosphere",
                        "",
                        "",
                        null},
                // ID 6013
                {
                        "The uppermost layer of the atmosphere is ________",
                        "exosphere",
                        "troposphere",
                        "",
                        "",
                        null},
                // ID 6014
                {
                        "________ removes soluble impurities from water",
                        "Distillation",
                        "Fitration",
                        "",
                        "",
                        null},
                // ID 6015
                {
                        "________ is used to increase the rate of sedimentation",
                        "Alum",
                        "Chlorine",
                        "",
                        "",
                        null},
                // ID 6016
                {
                        "________ is added to the soil by means of fertilizers",
                        "Nitrogen",
                        "Argon",
                        "",
                        "",
                        null},
                // ID 6017
                {
                        "All living things need _____ to breathe",
                        "oxygen",
                        "nitrogen",
                        "",
                        "",
                        null},
                // ID 6018
                {
                        "The layer of atmosphere where weather changes take place is ________",
                        "trosposphere",
                        "stratosphere",
                        "",
                        "",
                        null},
                // ID 6019
                {
                        "Space shuttles fly in ________",
                        "thermosphere",
                        "exosphere",
                        "",
                        "",
                        null},
                // ID 6020
                {
                        "Air exerts ________ on objects",
                        "pressure",
                        "weight",
                        "",
                        "",
                        null},
                // ID 6021
                {
                        "The five layers of atmosphere are Troposphere, Stratosphere, Mesosphere, Thermosphere and __________",
                        "Exosphere",
                        "Licosphere",
                        "Microsphere",
                        "Macrosphere",
                        null},
                // ID 6022
                {
                        "In which of the following layers of atmosphere do we live?",
                        "Troposphere",
                        "Stratosphere",
                        "Mesosphere",
                        "Thermosphere",
                        null},
                // ID 6023
                {
                        "The atmospheric layer above Troposphere is _________?",
                        "Stratosphere",
                        "Troposphere",
                        "Mesosphere",
                        "Thermosphere",
                        null},
                // ID 6024
                {
                        "________ is the third layer of the atmosphere from the Earth's surface",
                        "Mesosphere",
                        "Troposphere",
                        "Stratosphere",
                        "Thermosphere",
                        null},
                // ID 6025
                {
                        "________ is the fourth layer of the atmosphere from the Earth's surface",
                        "Thermosphere",
                        "Troposphere",
                        "Stratosphere",
                        "Mesosphere",
                        null},
                // ID 6026
                {
                        "________ is the uppermost layer of the atmosphere.",
                        "Exosphere",
                        "Troposphere",
                        "Stratosphere",
                        "Mesosphere",
                        null},
                // ID 6027
                {
                        "The most abundant gas in the atmosphere is _________",
                        "Nitrogen",
                        "Oxygen",
                        "Carbon dioxide",
                        "Helium",
                        null},
                // ID 6028
                {
                        "Which of the following gas has maximum presence in the atmosphere?",
                        "Nitrogen",
                        "Oxygen",
                        "Carbon dioxide",
                        "Helium",
                        null},
                // ID 6029
                {
                        "Water thta is fit for human consumption is called _______ water",
                        "potable",
                        "salty",
                        "sugary",
                        "cold",
                        null},
                // ID 6030
                {
                        "________ impurities such as sand and mud can be removed by sedimentation and decantation, and filtration methods",
                        "Insoluble",
                        "Soluble",
                        "",
                        "",
                        null},
                // ID 6031
                {
                        "________ impurities in water can be removed by evaporation and distillation methods.",
                        "Soluble",
                        "Insoluble",
                        "",
                        "",
                        null},
                // ID 6032
                {
                        "________ is a process that can be used to separate a pure liquid from a mixture of liquids due to the difference in their boiling points.",
                        "Distillation",
                        "Sedimentation",
                        "Filtration",
                        "Fermentation",
                        null}
        });

        // Chapter 7:
        FIXED_QUESTIONS.put(7, new String[][]{
                // ID 7001
                {"TRUE or FALSE. The inner core of the Earth is a solid sphere.", "TRUE", "FALSE", "", "", null},
                // ID 7002
                {"TRUE or FALSE. In the core of the sun, hydrogen gets converted into helium.", "TRUE", "FALSE", "", "", null},
                // ID 7003
                {"TRUE or FALSE. The moon produces its own light.", "FALSE", "TRUE", "", "", null},
                // ID 7004
                {"TRUE or FALSE. The moon has lot of craters on its surface", "TRUE", "FALSE", "", "", null},
                // ID 7005
                {"TRUE or FALSE. Total solar eclipse is visible from all parts of the Earth", "FALSE", "TRUE", "", "", null},
                // ID 7006
                {
                        "The coldest planet of the solar system is:",
                        "Uranus",
                        "Neptune",
                        "Mars",
                        "Earth",
                        null},
                // ID 7007
                {
                        "Major contituents of the sun are:",
                        "hydrogen and helium",
                        "neon and oxygen",
                        "helium and oxygen",
                        "hydrogen and oxygen",
                        null},
                // ID 7008
                {
                        "Solid rocks are found in the outer region of the:",
                        "mantle",
                        "core",
                        "corona",
                        "crater",
                        null},
                // ID 7009
                {
                        "Solar eclipse occurs when:",
                        "the moon comes between the Earth and the sun",
                        "the Earth comes between the sun and the moon",
                        "the sun comes between the moon and the Earth",
                        "",
                        null},
                // ID 7010
                {
                        "Lunar eclipse occurs when:",
                        "the Earth comes between the sun and the moon",
                        "the moon comes between the Earth and the sun",
                        "the sun comes between the moon and the Earth",
                        "",
                        null},
                // ID 7011
                {
                        "The nearest planet to the sun ______",
                        "Mercury",
                        "Venus",
                        "Earth",
                        "Jupiter",
                        null},
                // ID 7012
                {
                        "The hottest planet in the solar system ______",
                        "Venus",
                        "Mercury",
                        "Earth",
                        "Jupiter",
                        null},
                // ID 7013
                {
                        "The planet that appears red in colour ______",
                        "Mars",
                        "Mercury",
                        "Venus",
                        "Jupiter",
                        null},
                // ID 7014
                {
                        "The largest planet in the solar system ______",
                        "Jupiter",
                        "Mercury",
                        "Venus",
                        "Earth",
                        null},
                // ID 7015
                {
                        "A dwarf planet: ______",
                        "Pluto",
                        "Mercury",
                        "Venus",
                        "Jupiter",
                        null},
                // ID 7016
                {
                        "The sun is a ______",
                        "Star",
                        "Planet",
                        "Satellite",
                        "Dwarf planet",
                        null},
                // ID 7017
                {
                        "The planet that has a prominent ring system around it is ______",
                        "Saturn",
                        "Mars",
                        "Jupiter",
                        "Uranus",
                        null},
                // ID 7018
                {
                        "Which among the following is a satellite?",
                        "Moon",
                        "Sun",
                        "Mercury",
                        "Pluto",
                        null},
                // ID 7019
                {"TRUE or FALSE. Mars is a red planet", "TRUE", "FALSE", "", "", null},
                // ID 7020
                {"TRUE or FALSE. Uranus is the farthest planet from the sun.", "FALSE", "TRUE", "", "", null},
                // ID 7021
                {"TRUE or FALSE. Neptune is a dwarf planet", "FALSE", "TRUE", "", "", null},
                // ID 7022
                {
                        "Pluto is considered as a _________",
                        "dwarf planet",
                        "planet",
                        "",
                        "",
                        null},
                // ID 7023
                {
                        "The smallest planet in the solar system.",
                        "Mercury",
                        "Uranus",
                        "Neptune",
                        "Earth",
                        null},
                // ID 7024
                {
                        "The planet on which life exists.",
                        "Earth",
                        "Mercury",
                        "Uranus",
                        "Neptune",
                        null},
                // ID 7025
                {
                        "The planet farthest from the sun is ______.",
                        "Neptune",
                        "Uranus",
                        "Venus",
                        "Jupiter",
                        null},
                // ID 7026
                {
                        "The sun, the eight planets, their moons and the dwarf planets together form the ________ system",
                        "solar",
                        "lunar",
                        "circulatory",
                        "respiratory",
                        null},
                // ID 7027
                {
                        "The eight planets of our solar system are: Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus and ______",
                        "Neptune",
                        "Moon",
                        "Pluto",
                        "Crater",
                        null},
                // ID 7028
                {
                        "The planet between the Earth and the Mercury is ______",
                        "Venus",
                        "Neptune",
                        "Moon",
                        "Pluto",
                        null},
                // ID 7029
                {
                        "The planet between Neptune and Saturn is ______",
                        "Uranus",
                        "Earth",
                        "Pluto",
                        "Venus",
                        null},
                // ID 7030
                {"TRUE or FALSE. Jupiter is a dwarf planet", "FALSE", "TRUE", "", "", null},
                // ID 7031
                {"TRUE or FALSE. Earth is a dwarf planet", "FALSE", "TRUE", "", "", null},
                {
                        "Which of the following is not a planet?",
                        "Moon",
                        "Venus",
                        "Unanus",
                        "Earth",
                        null},
                // ID 7033
                {
                        "What planet is nicknamed the Red Planet?",
                        "Mars",
                        "Venus",
                        "Unanus",
                        "Earth",
                        null},
                // ID 7034
                {
                        "Which planet has the largest ring system?",
                        "Saturn",
                        "Venus",
                        "Unanus",
                        "Earth",
                        null},
                // ID 7035
                {
                        "What is the fourth planet from the Sun?",
                        "Mars",
                        "Jupiter",
                        "Neptune",
                        "Saturn",
                        null},
                // ID 7036
                {
                        "What is the fifth planet from the Sun?",
                        "Jupiter",
                        "Neptune",
                        "Saturn",
                        "Mars",
                        null},
                // ID 7037
                {
                        "What is the eighth planet from the Sun?",
                        "Neptune",
                        "Jupiter",
                        "Saturn",
                        "Mars",
                        null},
                // ID 7038
                {
                        "What is the sixth planet from the Sun?",
                        "Saturn",
                        "Jupiter",
                        "Neptune",
                        "Mars",
                        null},
                // ID 7039
                {
                        "What is the seventh planet from the Sun?",
                        "Uranus",
                        "Jupiter",
                        "Neptune",
                        "Saturn",
                        null},
                // ID 7040
                {
                        "Which star is at the center of our solar system?",
                        "Sun",
                        "Neptune",
                        "Saturn",
                        "Moon",
                        null},
                // ID 7041
                {
                        "What is the third planet from the Sun?",
                        "Earth",
                        "Jupiter",
                        "Saturn",
                        "Uranus",
                        null},
                // ID 7042
                {
                        "What is the second planet from the Sun?",
                        "Venus",
                        "Jupiter",
                        "Earth",
                        "Uranus",
                        null},
                // ID 7043
                {"TRUE or FALSE. The position of Jupiter in our solar system is in between Uranus and Neptune", "FALSE", "TRUE", "", "", null},
                // ID 7044
                {"TRUE or FALSE. The distance of Earth from the Sun is more than that of Venus", "TRUE", "FALSE", "", "", null},
                // ID 7045
                {"TRUE or FALSE. The distance of Earth from the Sun is more than that of Saturn", "FALSE", "TRUE", "", "", null},
                // ID 7046
                {"TRUE or FALSE. The planet Neptune is nearest to the Sun", "FALSE", "TRUE", "", "", null},
                // ID 7047
                {"TRUE or FALSE. Jupiter is not a planet of our solar system", "FALSE", "TRUE", "", "", null},
                // ID 7048
                {"TRUE or FALSE. The Earth is the largest planet of our solar system", "FALSE", "TRUE", "", "", null},
                // ID 7049
                {"TRUE or FALSE. The Earth is the smallest planet of our solar system", "FALSE", "TRUE", "", "", null},
                // ID 7050
                {"TRUE or FALSE. Neptune is the smallest planet of our solar system", "FALSE", "TRUE", "", "", null},
                // ID 7051
                {"TRUE or FALSE. Mercury is the smallest planet of our solar system", "TRUE", "FALSE", "", "", null},
                // ID 7052
                {"TRUE or FALSE. Pluto is a satellite", "FALSE", "TRUE", "", "", null},
                // ID 7053
                {"TRUE or FALSE. Moon is a dwarf planet", "FALSE", "TRUE", "", "", null},
                // ID 7054
                {"TRUE or FALSE. The Earth is also known as the red planet", "FALSE", "TRUE", "", "", null},
                // ID 7055
                {"TRUE or FALSE. The distance of Earth from the Sun is less than that of Saturn", "TRUE", "FALSE", "", "", null},
                // ID 7056
                {"TRUE or FALSE. The distance of Uranus from the Sun is less than that of Neptune", "TRUE", "FALSE", "", "", null},
                // ID 7057
                {"TRUE or FALSE. Uranus and Neptune are equidistant from the Sun", "FALSE", "TRUE", "", "", null},
                // ID 7058
                {"TRUE or FALSE. Earth is nearer to the Sun compared to Uranus", "TRUE", "FALSE", "", "", null},
                // ID 7059
                {"TRUE or FALSE. Earth is nearer to the Sun compared to Mercury", "FALSE", "TRUE", "", "", null},
                // ID 7060
                {
                        "Which phenomenon is shown in the picture:",
                        "Solar Eclipse",
                        "Lunar Eclipse",
                        "Eruption of volcano",
                        "Earthquake",
                        ImageCodeType.RESOURCE_IMAGE + ";science_7060"},
                // ID 7061
                {
                        "Which phenomenon is shown in the picture:",
                        "Lunar Eclipse",
                        "Solar Eclipse",
                        "Eruption of volcano",
                        "Earthquake",
                        ImageCodeType.RESOURCE_IMAGE + ";science_7061"},
                // ID 7062
                {
                        "Which planet has the ability to float in water?",
                        "Saturn",
                        "Uranus",
                        "Neptune",
                        "Jupiter",
                        null}
        });

        // Chapter 8:
        FIXED_QUESTIONS.put(8, new String[][]{
                // ID 8001
                {"TRUE or FALSE. Burning fire crackers causes air pollution", "TRUE", "FALSE", "", "", null},
                // ID 8002
                {"TRUE or FALSE. Global warming can cause melting of ice in the polar regions", "TRUE", "FALSE", "", "", null},
                // ID 8003
                {"TRUE or FALSE. Oil spillage from ships cause water pollution", "TRUE", "FALSE", "", "", null},
                // ID 8004
                {"TRUE or FALSE. Sewage contains germs that cause cholera, diarrhoea, etc.", "TRUE", "FALSE", "", "", null},
                // ID 8005
                {"TRUE or FALSE. Pollution of air, water, noise and land is beneficial for us", "FALSE", "TRUE", "", "", null},
                // ID 8006
                {
                        "Which of the following is a cause of air pollution?",
                        "Smoke",
                        "Trees",
                        "House",
                        "Water",
                        null},
                // ID 8007
                {
                        "Which of the following is not a cause of soil erosion?",
                        "Trees",
                        "Wind",
                        "Rain",
                        "",
                        null},
                // ID 8008
                {
                        "Air pollution can cause ______",
                        "asthma",
                        "obesity",
                        "hearing impairment",
                        "cholera",
                        null},
                // ID 8009
                {
                        "Which of these causes land pullution?",
                        "Polythene bags",
                        "Loudspeakers",
                        "Smoke",
                        "Sewage",
                        null},
                // ID 8010
                {
                        "Honking of vehicles and loud noise from television cause ______ pollution",
                        "noise",
                        "land",
                        "water",
                        "air",
                        null},
                // ID 8011
                {
                        "The substances that cause pollution are called _________",
                        "pollutants",
                        "smoke",
                        "",
                        "",
                        null},
                // ID 8012
                {
                        "Global warming is caused due to increase in the amount of _________",
                        "carbon dioxide",
                        "oxygen",
                        "",
                        "",
                        null},
                // ID 8013
                {
                        "The main cause of soil erosion is _________",
                        "deforestation",
                        "afforestation",
                        "",
                        "",
                        null},
                // ID 8014
                {
                        "Washing clothes and bathing animals near a water source cause _________",
                        "water",
                        "air",
                        "",
                        "",
                        null},
                // ID 8015
                {
                        "Noise pollution cause _________",
                        "sleep disturbance",
                        "asthma",
                        "",
                        "",
                        null},
                // ID 8016
                {
                        "Smoke from automobiles causes _________ pollution",
                        "air",
                        "land",
                        "",
                        "",
                        null},
                // ID 8017
                {
                        "The wastes from industries and the sewage pipelines are the sources of ________ pollution",
                        "water",
                        "air",
                        "",
                        "",
                        null},
                // ID 8018
                {
                        "Dumping wastes like plastic bags, glass and metal containers causes ________ pollution",
                        "land",
                        "air",
                        "",
                        "",
                        null},
                // ID 8019
                {
                        "The roots of trees hold the ________ together",
                        "soil",
                        "water",
                        "",
                        "",
                        null},
                // ID 8020
                {
                        "The addition of harmful substances to the environment which makes it dirty is called _________",
                        "pollution",
                        "atmosphere",
                        "solution",
                        "distillation",
                        null},
                // ID 8021
                {
                        "The substances that cause pollution are called _________",
                        "pollutants",
                        "solvents",
                        "sedimentation",
                        "distillation",
                        null},
                // ID 8022
                {
                        "Which of the following can cause air pollution?",
                        "Smoke from vehicles",
                        "sewage pipelines to water bodies",
                        "dumping of plastic bags",
                        "Honking of vehicles",
                        null},
                // ID 8023
                {
                        "Which of the following can cause noise pollution?",
                        "Honking of vehicles",
                        "Smoke from vehicles",
                        "sewage pipelines to water bodies",
                        "dumping of plastic bags",
                        null},
                // ID 8024
                {
                        "Which of the following can cause water pollution?",
                        "sewage pipelines to water bodies",
                        "Smoke from vehicles",
                        "dumping of plastic bags",
                        "Honking of vehicles",
                        null},
                // ID 8025
                {
                        "Which of the following can cause land pollution?",
                        "overuse of chemicals such as fertilizers",
                        "Smoke from vehicles",
                        "sewage pipelines to water bodies",
                        "Honking of vehicles",
                        null},
                // ID 8026
                {
                        "Which of the following can cause air pollution?",
                        "Smoke from industries",
                        "sewage pipelines to water bodies",
                        "dumping of plastic bags",
                        "Honking of vehicles",
                        null},
                // ID 8027
                {
                        "Smoke from industries can cause ________ pollution",
                        "air",
                        "land",
                        "water",
                        "noise",
                        null},
                // ID 8028
                {
                        "Honking of vehicles can cause ________ pollution",
                        "noise",
                        "air",
                        "land",
                        "water",
                        null},
                // ID 8029
                {
                        "Use of firewood and coal for cooking can cause ________ pollution",
                        "air",
                        "land",
                        "water",
                        "noise",
                        null},
                // ID 8030
                {
                        "Smoke from firecrackers can cause ________ pollution",
                        "air",
                        "land",
                        "water",
                        "noise",
                        null},
                // ID 8031
                {
                        "Bathing of cattle in lake or river can cause ________ pollution",
                        "water",
                        "air",
                        "land",
                        "noise",
                        null},
                // ID 8032
                {
                        "Dumping of industrial waste in water bodies can cause ________ pollution",
                        "water",
                        "air",
                        "land",
                        "noise",
                        null},
                // ID 8033
                {
                        "Washing clothes in water bodies can cause ________ pollution",
                        "water",
                        "air",
                        "land",
                        "noise",
                        null},
                // ID 8034
                {
                        "Overuse of chemicals such as fertilizers, insecticides and pesticides can cause ________ pollution",
                        "land",
                        "air",
                        "water",
                        "noise",
                        null},
                // ID 8035
                {
                        "Sound from loud speakers causes ________ pollution",
                        "noise",
                        "air",
                        "land",
                        "water",
                        null},
                // ID 8036
                {
                        "Noise from firecrackers causes ________ pollution",
                        "noise",
                        "air",
                        "land",
                        "water",
                        null},
                // ID 8037
                {
                        "Reducing use of vehicles can minimize ________ pollution",
                        "air",
                        "land",
                        "water",
                        "noise",
                        null},
                // ID 8038
                {
                        "Planting more trees can minimize ________ pollution",
                        "air",
                        "land",
                        "water",
                        "noise",
                        null},
                // ID 8039
                {
                        "Using environment-friendly manures and natural fertilizers can minimize ________ pollution",
                        "land",
                        "air",
                        "water",
                        "noise",
                        null},
                // ID 8040
                {
                        "Using cloth bags instead of polythene bags can minimize ________ pollution",
                        "land",
                        "air",
                        "water",
                        "noise",
                        null},
                // ID 8041
                {
                        "Use of public transports instead of personal cars can minimize ________ pollution",
                        "air",
                        "land",
                        "water",
                        "noise",
                        null},
                // ID 8042
                {
                        "Using bicycles instead of cars can minimize ________ pollution",
                        "air",
                        "land",
                        "water",
                        "noise",
                        null},
                // ID 8043
                {
                        "Throwing garbage in rivers can cause ________ pollution",
                        "water",
                        "air",
                        "land",
                        "noise",
                        null},
                // ID 8044
                {
                        "Playing music in high volumes can cause ________ pollution",
                        "noise",
                        "air",
                        "land",
                        "water",
                        null},
                // ID 8045
                {
                        "Which of the following do not cause noise pollution?",
                        "Using bicycles",
                        "Honking of vehicles",
                        "Playing music with high volumes",
                        "Using loudspeakers",
                        null},
                // ID 8046
                {
                        "Which of the following do not cause air pollution?",
                        "Throwing garbage in rivers",
                        "Using firewood for cooking",
                        "Burning firecrackers",
                        "Smoke from vehicles",
                        null}
        });

        // Chapter 9:
        FIXED_QUESTIONS.put(9, new String[][]{
                // ID 9001
                {
                        "TRUE or FALSE. Tides are formed due to the gravitational pull of the sun and the moon",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 9002
                {
                        "TRUE or FALSE. Drought occurs when water bodies overflow due to excess water",
                        "FALSE",
                        "TRUE",
                        "",
                        "",
                        null},
                // ID 9003
                {
                        "TRUE or FALSE. The effect of an earthquake is felt more at the epicenter",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 9004
                {
                        "TRUE or FALSE. Tides and tsunami are one and the same",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 9005
                {
                        "TRUE or FALSE. When magma comes out of the Earth's surface, it is called lava",
                        "TRUE",
                        "FALSE",
                        "",
                        "",
                        null},
                // ID 9006
                {
                        "Which of the following natural disasters is caused by disturbances in the Earth's crust?",
                        "Earthquake",
                        "Flood",
                        "Tide",
                        "Drought",
                        null},
                // ID 9007
                {
                        "The actual point deep in the Earth's crust where an earthquake begins is called ________",
                        "Focus",
                        "Mantle",
                        "Core",
                        "Epicenter",
                        null},
                // ID 9008
                {
                        "Which volcanoes are capable of erupting?",
                        "Dormant and active",
                        "Active and exinct",
                        "Extinct and dormant",
                        "Active, dormant and extinct",
                        null},
                // ID 9009
                {
                        "Which of the following natural disasters is caused by shortage of water?",
                        "Drought",
                        "Tsunami",
                        "Earthquake",
                        "Volcanic eruption",
                        null},
                // ID 9010
                {
                        "Heavy rainfall can cause _______",
                        "Flood",
                        "Earthquake",
                        "Drought",
                        "Volcanic eruption",
                        null},
                // ID 9011
                {
                        "The innermost layer of the Earth is called _______",
                        "core",
                        "mantle",
                        "",
                        "",
                        null},
                // ID 9012
                {
                        "The magnitude of an earthquake is measured using _______",
                        "Richter scale",
                        "seismograph",
                        "",
                        "",
                        null},
                // ID 9013
                {
                        "Volcanoes that erupt frequently are called _______ volcanoes",
                        "active",
                        "extinct",
                        "",
                        "",
                        null},
                // ID 9014
                {
                        "Floods occur due to _______ water",
                        "excess",
                        "lack of",
                        "",
                        "",
                        null},
                // ID 9015
                {
                        "Earthquake measuring ______ on the Richter scale is considered to be highly dangerous",
                        "8",
                        "3",
                        "",
                        "",
                        null},
                // ID 9016
                {
                        "Richter scale is used to measure the magnitute of which of the following natural event?",
                        "Earthquake",
                        "Volcano Eruption",
                        "Solar eclipse",
                        "Lunar eclipse",
                        null},
                // ID 9017
                {
                        "Which natural event is shown in the picture?",
                        "Volcano Eruption",
                        "Solar eclipse",
                        "Earthquake",
                        "Lunar eclipse",
                        ImageCodeType.RESOURCE_IMAGE + ";science_9017"},
                // ID 9018
                {
                        "The actual point deep inside the Earth where an earthquake begins is called the _______",
                        "focus",
                        "epicenter",
                        "Richter scale",
                        "Lunar eclipse",
                        null},
                // ID 9019
                {
                        "The actual point deep inside the Earth where an earthquake begins is called the focus and the point on the Earth's surface directly above the focus is called the ________.",
                        "epicenter",
                        "latitude",
                        "Richter scale",
                        "Lunar eclipse",
                        null},
                // ID 9020
                {
                        "Rise of large amount of water in the form of huge waves from oceans due to underwater earthquakes, volcanic erruptions, etc. is called ________.",
                        "tsunami",
                        "latitude",
                        "epicenter",
                        "Richter scale",
                        null},
                // ID 9021
                {
                        "The intensity and duration of an earthquake can be measured using an instrument called the ________.",
                        "seismograph",
                        "epicenter",
                        "Richter scale",
                        "tsunami",
                        null},
                // ID 9022
                {
                        "A ________ is the region where the Earth's crust is weak and develops a crack.",
                        "vent",
                        "epicenter",
                        "lava",
                        "tsunami",
                        null},
                // ID 9023
                {
                        "The natural disaster that occurs due to the lack of rainfall.",
                        "drought",
                        "flood",
                        "tsunami",
                        "earthquakes",
                        null},
                // ID 9024
                {
                        "Natural events occuring on the Earth that cause great damage or loss of life are called _________.",
                        "natural disasters",
                        "tsunami",
                        "earthquakes",
                        "epicenter",
                        null},
                // ID 9025
                {
                        "Richter scale is a standard scale used to find out the magnitude of earthquakes on a scale of ________.",
                        "1 to 10",
                        "1 to 5",
                        "1 to 100",
                        "1 to 7",
                        null},
                // ID 9026
                {
                        "Which of the following magnitude of earthquake does not cause any damage?",
                        "1 to 2",
                        "3 to 5",
                        "6 and above",
                        "",
                        null},
                // ID 9027
                {
                        "Which of the following magnitude of earthquake can cause very high damage to properties and lives?",
                        "6 and above",
                        "1 to 2",
                        "3 to 5",
                        "",
                        null},
                // ID 9028
                {
                        "Volcanoes that can erupt at any time or have erupted in recent years are called _________ volcanoes",
                        "active",
                        "dormant",
                        "extinct",
                        "",
                        null},
                // ID 9029
                {
                        "Volcanoes that have not erupted for a long period but may erupt in the future are called _________ volcanoes",
                        "dormant",
                        "active",
                        "extinct",
                        "",
                        null},
                // ID 9030
                {
                        "Volcanoes that are not expected to erupt in the future are called _________ volcanoes",
                        "extinct",
                        "active",
                        "dormant",
                        "",
                        null},
                // ID 9031
                {
                        "______ are the cyclic rise and fall of sea levels caused due to the gravitational pull of the sun and the moon",
                        "Tides",
                        "Volcanoes",
                        "Earthquakes",
                        "Solar Eclipses",
                        null},
                // ID 9032
                {
                        "Tides reach the _______ height when the sun, the moon and the Earth are in a straight line.",
                        "maximum",
                        "minimum",
                        "",
                        "",
                        null},
                // ID 9033
                {
                        "Which of the following is not a cause of Tsunami?",
                        "Cloud burst",
                        "Under sea land slide",
                        "Under sea earthquake",
                        "Under sea volcanic eruption",
                        null}
        });

        // Chapter 10:
        FIXED_QUESTIONS.put(10, new String[][]{
                // ID 10001
                {"TRUE or FALSE. Granite is formed from limestone", "FALSE", "TRUE", "", "", null},
                // ID 10002
                {"TRUE or FALSE. Coal is metallic mineral", "FALSE", "TRUE", "", "", null},
                // ID 10003
                {"TRUE or FALSE. Slate can be broken into thin layers", "TRUE", "FALSE", "", "", null},
                // ID 10004
                {"TRUE or FALSE. Shale is used in making bricks", "TRUE", "FALSE", "", "", null},
                // ID 10005
                {"TRUE or FALSE. Pumice is formed by the rapid cooling of lava", "TRUE", "FALSE", "", "", null},
                // ID 10006
                {"TRUE or FALSE. Minerals like sulphates and nitrates are the contituents of fertilisers", "TRUE", "FALSE", "", "", null},
                // ID 10007
                {
                        "Which of the following is an igneous rock?",
                        "Obsidian",
                        "Sandstone",
                        "Limestone",
                        "Slate",
                        null},
                // ID 10008
                {
                        "The sedimentary rock that contains solidified mud and clay piled up in layers:",
                        "Shale",
                        "Limestone",
                        "Sandstone",
                        "Conglomerate",
                        null},
                // ID 10009
                {
                        "The metamorphic rock formed from sandstone:",
                        "Quartzite",
                        "Gneiss",
                        "Marble",
                        "Slate",
                        null},
                // ID 10010
                {
                        "Which of the following is a non-metallic mineral?",
                        "Gypsum",
                        "Pyrite",
                        "Bauxite",
                        "Hematite",
                        null},
                // ID 10011
                {
                        "Which of the following is a gemstone?",
                        "Emerald",
                        "Coal",
                        "Mica",
                        "Feldspar",
                        null},
                // ID 10012
                {
                        "Which of the following minerals is used in welding rods and electrical goods?",
                        "Mica",
                        "Talc",
                        "Quartz",
                        "Diamond",
                        null},
                // ID 10013
                {
                        "The molten rock present inside the Earth is called _______",
                        "magma",
                        "lava",
                        "",
                        "",
                        null},
                // ID 10014
                {
                        "Pumice is a type of _______ rock",
                        "igneous",
                        "sedimentary",
                        "",
                        "",
                        null},
                // ID 10015
                {
                        "Gneiss is formed from the igneous rock _______",
                        "granite",
                        "shale",
                        "",
                        "",
                        null},
                // ID 10016
                {
                        "_______ is used to make roads",
                        "Tar",
                        "Marble",
                        "",
                        "",
                        null},
                // ID 10017
                {
                        "_______ is used for making jewellary.",
                        "Diamond",
                        "Graphite",
                        "",
                        "",
                        null},
                // ID 10018
                {
                        "_______ is used in food.",
                        "Rock salt",
                        "Talc",
                        "",
                        "",
                        null},
                // ID 10019
                {
                        "Taj Mahal is made of _______",
                        "Marble",
                        "Obsidian",
                        "Sandstone",
                        "Magma",
                        null},
                // ID 10020
                {
                        "Molten rock inside the Earth's core:",
                        "Magma",
                        "Obsidian",
                        "Sandstone",
                        "Marble",
                        null},
                // ID 10021
                {
                        "Lightweight rock with holes",
                        "Pumice",
                        "Obsidian",
                        "Sandstone",
                        "Marble",
                        null},
                // ID 10022
                {
                        "The rock used in building Red Fort:",
                        "Sandstone",
                        "Obsidian",
                        "Marble",
                        "Magma",
                        null},
                // ID 10023
                {
                        "Volcanic glass:",
                        "Obsidian",
                        "Sandstone",
                        "Marble",
                        "Magma",
                        null},
                // ID 10024
                {
                        "Rocks can be divided into three groups based on how they are formed: igneous, sedimentary and _________",
                        "metamorphic",
                        "obsidian",
                        "sandstone",
                        "marble",
                        null},
                // ID 10025
                {
                        "When magma comes out to the surface of the Earth through volcanic eruptions, it is called _________",
                        "lava",
                        "sandstone",
                        "marble",
                        "metamorphic",
                        null},
                // ID 10026
                {
                        "Which of the following is formed due to the slow cooling of lava?",
                        "Granite",
                        "Pumice",
                        "Obsidian",
                        "",
                        null},
                // ID 10027
                {
                        "_________ rocks are formed due to the deposition of small pieces of rock, soil, and plant and animal matter over thousands of years by the action of wind, rainwater and flowing river water",
                        "Sedimentary",
                        "Metamorphic",
                        "Igneous",
                        "",
                        null},
                // ID 10028
                {
                        "Metal-yielding minerals are also called ______",
                        "ores",
                        "sandstone",
                        "sedimentary",
                        "igneous",
                        null},
                // ID 10029
                {
                        "Which of the following ore can be processed to obtain aluminium?",
                        "Bauxite",
                        "Pyrite",
                        "Hematite",
                        "Feroxite",
                        null},
                // ID 10030
                {
                        "Which of the following ore can be processed to obtain copper?",
                        "Pyrite",
                        "Bauxite",
                        "Hematite",
                        "Feroxite",
                        null},
                // ID 10031
                {
                        "Which of the following ore can be processed to obtain iron?",
                        "Hematite",
                        "Bauxite",
                        "Pyrite",
                        "Feroxite",
                        null},
                // ID 10032
                {
                        "Which of the following is not a metallic mineral?",
                        "Gypsum",
                        "Bauxite",
                        "Pyrite",
                        "Hematite",
                        null},
                // ID 10033
                {
                        "Which of the following is a metallic mineral?",
                        "Bauxite",
                        "Salt",
                        "Coal",
                        "Gypsum",
                        null},
                // ID 10034
                {
                        "Which of the following is a metallic mineral?",
                        "Pyrite",
                        "Salt",
                        "Coal",
                        "Gypsum",
                        null},
                // ID 10035
                {
                        "Which of the following is a metallic mineral?",
                        "Hematite",
                        "Salt",
                        "Mica",
                        "Gypsum",
                        null},
                // ID 10036
                {
                        "________ is the hardest mineral?",
                        "Diamond",
                        "Salt",
                        "Mica",
                        "Gypsum",
                        null},
                // ID 10037
                {
                        "What are the basic types of rocks found on earth?",
                        "Igneous, sedimentary, metamorphic",
                        "Volcanic, plutonic, extrusive",
                        "Gneiss, basalt, obsidian",
                        "",
                        null}
        });

        // Chapter 11:
        FIXED_QUESTIONS.put(11, new String[][]{
                // ID 11001
                {"TRUE or FALSE. Atoms are the building blocks of matter", "TRUE", "FALSE", "", "", null},
                // ID 11002
                {"TRUE or FALSE. Molecules are made up of only the same kind of atoms", "FALSE", "TRUE", "", "", null},
                // ID 11003
                {"TRUE or FALSE. When heated, atoms move faster", "TRUE", "FALSE", "", "", null},
                // ID 11004
                {"TRUE or FALSE. All substances undergo melting in normal conditions", "FALSE", "TRUE", "", "", null},
                // ID 11005
                {"TRUE or FALSE. Solids expand on heating", "TRUE", "FALSE", "", "", null},
                // ID 11006
                {
                        "Matter has mass and occupies",
                        "space",
                        "weight",
                        "energy",
                        "",
                        null},
                // ID 11007
                {
                        "Identify the state of matter in which the molecules spread out and occupy the entire space available",
                        "Gas",
                        "Solid",
                        "Liquid",
                        "",
                        null},
                // ID 11008
                {
                        "Identify the state of matter that has a fixed shape",
                        "Solid",
                        "Liquid",
                        "Gas",
                        "",
                        null},
                // ID 11009
                {
                        "When a solid is heated, it ________",
                        "expands",
                        "contracts",
                        "freezes",
                        "",
                        null},
                // ID 11010
                {
                        "Formation of mist is an example of ________",
                        "condensation",
                        "freezing",
                        "melting",
                        "evaporation",
                        null},
                // ID 11011
                {
                        "Which of the following is a chemical change?",
                        "Burning of paper",
                        "Freezing of water",
                        "Melting of ice",
                        "Boiling of water",
                        null},
                // ID 11012
                {
                        "Process in which a solid turns into liquid:",
                        "Melting",
                        "Condensation",
                        "Evaporation",
                        "Freezing",
                        null},
                // ID 11013
                {
                        "Process in which a liquid changes into solid:",
                        "Freezing",
                        "Condensation",
                        "Evaporation",
                        "Melting",
                        null},
                // ID 11014
                {
                        "Process in which a liquid changes into gas:",
                        "Evaporation",
                        "Condensation",
                        "Freezing",
                        "Melting",
                        null},
                // ID 11015
                {
                        "Process in which a gas changes into liquid:",
                        "Condensation",
                        "Evaporation",
                        "Freezing",
                        "Melting",
                        null},
                // ID 11016
                {
                        "A substance that occupies space and has mass: ________",
                        "matter",
                        "atom",
                        "",
                        "",
                        null},
                // ID 11017
                {
                        "Building block of matter: ________",
                        "atoms",
                        "gas",
                        "liquid",
                        "molecules",
                        null},
                // ID 11018
                {
                        "The state in which particles move freely: ________",
                        "gas",
                        "liquid",
                        "solid",
                        "semi solid",
                        null},
                // ID 11019
                {
                        "Water is an example of: ________",
                        "liquid",
                        "gas",
                        "solid",
                        "semi solid",
                        null},
                // ID 11020
                {
                        "when two or more atoms combine together, they form a particle called a ________",
                        "molecule",
                        "gas",
                        "liquid",
                        "matter",
                        null},
                // ID 11021
                {"TRUE or FALSE. In gases, atoms/molecules move freely and are not in contact with each other.", "TRUE", "FALSE", "", "", null},
                // ID 11022
                {"TRUE or FALSE. In solids, atoms/molecules move freely and are not in contact with each other.", "FALSE", "TRUE", "", "", null},
                // ID 11023
                {"TRUE or FALSE. In liquids, atoms/molecules move freely and are not in contact with each other.", "FALSE", "TRUE", "", "", null},
                // ID 11024
                {"TRUE or FALSE. In solids, atoms/molecules move but remain in the same position.", "TRUE", "FALSE", "", "", null},
                // ID 11025
                {"TRUE or FALSE. In liquids, atoms/molecules move but remain in the same position.", "FALSE", "TRUE", "", "", null},
                // ID 11026
                {"TRUE or FALSE. In gases, atoms/molecules move but remain in the same position.", "FALSE", "TRUE", "", "", null},
                // ID 11027
                {"TRUE or FALSE. In liquids, atoms/molecules move around but remain in contact with each other.", "TRUE", "FALSE", "", "", null},
                // ID 11028
                {"TRUE or FALSE. In solids, atoms/molecules move around but remain in contact with each other.", "FALSE", "TRUE", "", "", null},
                // ID 11029
                {"TRUE or FALSE. In gases, atoms/molecules move around but remain in contact with each other.", "FALSE", "TRUE", "", "", null},
                // ID 11030
                {"TRUE or FALSE. Solids do not take the shape of the container they are in.", "TRUE", "FALSE", "", "", null},
                // ID 11031
                {"TRUE or FALSE. The molecules in a solid are very closely packed.", "TRUE", "FALSE", "", "", null},
                // ID 11033
                {"TRUE or FALSE. Gas molecules cannot move freely.", "FALSE", "TRUE", "", "", null},
                // ID 11034
                {
                        "The state of matter that has very less space between its molecules is ______.",
                        "solid",
                        "liquid",
                        "gas",
                        "semi-liquid",
                        null},
                // ID 11035
                {
                        "Identify the substance that exists in all the three states of matter",
                        "Water",
                        "Pencil",
                        "Mobile phone",
                        "Computer",
                        null},
                // ID 11036
                {
                        "Molecules in _______ can move freely in any direction",
                        "gases",
                        "solids",
                        "liquids",
                        "",
                        null},
                // ID 11037
                {"TRUE or FALSE. Light is a matter", "FALSE", "TRUE", "", "", null},
                // ID 11038
                {"TRUE or FALSE. There is a lots of space between molecules in a solid", "FALSE", "TRUE", "", "", null},
                // ID 11039
                {"TRUE or FALSE. Melting is the process in which a solid changes into a liquid.", "TRUE", "FALSE", "", "", null},
                // ID 11040
                {"TRUE or FALSE. Condensation is the process in which a solid changes into a liquid.", "FALSE", "TRUE", "", "", null},
                // ID 11041
                {"TRUE or FALSE. Condensation is the process in which a gas changes into a liquid.", "TRUE", "FALSE", "", "", null},
                // ID 11042
                {"TRUE or FALSE. Burning of petrol is a chemical change.", "TRUE", "FALSE", "", "", null},
                // ID 11043
                {"TRUE or FALSE. Burning of petrol is a physical change.", "FALSE", "TRUE", "", "", null},
                // ID 11044
                {
                        "Which of the following is not a chemical change?",
                        "Freezing of water",
                        "Burning of paper",
                        "Burning of petrol",
                        "Burning of wood",
                        null},
                // ID 11045
                {
                        "Which of the following is not a chemical change?",
                        "Boiling of water",
                        "Burning of paper",
                        "Burning of petrol",
                        "Burning of wood",
                        null},
                // ID 11046
                {
                        "Which of the following is not a chemical change?",
                        "Evaporation of water",
                        "Burning of paper",
                        "Burning of petrol",
                        "Burning of wood",
                        null},
                // ID 11047
                {
                        "Which of the following is not a chemical change?",
                        "melting of ice",
                        "Cooking an egg",
                        "Baking a cake",
                        "Burning of clothes",
                        null},
                // ID 11048
                {"TRUE or FALSE. Melting of ice is a chemical change", "FALSE", "TRUE", "", "", null},
                // ID 11049
                {"TRUE or FALSE. Melting of ice is a physical change", "TRUE", "FALSE", "", "", null},
                // ID 11050
                {"TRUE or FALSE. Burning of cloth is a physical change", "FALSE", "TRUE", "", "", null},
                // ID 11051
                {"TRUE or FALSE. Burning of cloth is a chemical change", "TRUE", "FALSE", "", "", null},
                // ID 11052
                {
                        "Which of the following is not a physical change?",
                        "Cooking an egg",
                        "Boiling of water",
                        "Melting of ice cube",
                        "Freezing of water",
                        null},
                // ID 11053
                {
                        "Which of the following is not a physical change?",
                        "Burning of wood",
                        "Boiling of water",
                        "Melting of ice cube",
                        "Freezing of water",
                        null},
                // ID 11054
                {
                        "Which of the following is not a physical change?",
                        "Burning of coal",
                        "Boiling of water",
                        "Melting of ice cube",
                        "Freezing of water",
                        null},
                // ID 11055
                {
                        "Which of the following is not a physical change?",
                        "Cooking rice",
                        "Boiling of water",
                        "Melting of ice cube",
                        "Freezing of water",
                        null},
                // ID 11056
                {"TRUE or FALSE. A molecule can be made up of the same or different kind of atoms.", "TRUE", "FALSE", "", "", null},
                // ID 11057
                {"TRUE or FALSE. A molecule is always made up of same kind of atoms.", "FALSE", "TRUE", "", "", null},
                // ID 11058
                {"TRUE or FALSE. A molecule is always made up of different kind of atoms.", "FALSE", "TRUE", "", "", null},
                // ID 11059
                {
                        "An oxygen molecule is made up of two ________ atoms.",
                        "oxygen",
                        "hydrogen",
                        "nitrogen",
                        "sodium",
                        null},
                // ID 11060
                {
                        "A water molecule is made up of two ________ atoms and one oxygen atom.",
                        "hydrogen",
                        "nitrogen",
                        "chlorine",
                        "sodium",
                        null},
                // ID 11061
                {
                        "A water molecule is made up of two hydrogen atoms and one ______ atom.",
                        "oxygen",
                        "nitrogen",
                        "chlorine",
                        "sodium",
                        null},
                // ID 11062
                {
                        "When an iron ball is heated, the size of the ball ______",
                        "increases",
                        "descreases",
                        "remains the same",
                        "",
                        null},
                // ID 11063
                {"TRUE or FALSE. When an iron ball is heated, the size of the ball increases.", "TRUE", "FALSE", "", "", null},
                // ID 11064
                {"TRUE or FALSE. When an iron ball is heated, the size of the ball descreases.", "FALSE", "TRUE", "", "", null},
                // ID 11065
                {"TRUE or FALSE. Solids expand on heating.", "TRUE", "FALSE", "", "", null},
                // ID 11066
                {"TRUE or FALSE. Solids contract on cooling.", "TRUE", "FALSE", "", "", null},
                // ID 11067
                {"TRUE or FALSE. Solids contract on heating.", "FALSE", "TRUE", "", "", null},
                // ID 11068
                {"TRUE or FALSE. Solids expand on cooling.", "FALSE", "TRUE", "", "", null},
                // ID 11069
                {"TRUE or FALSE. A water molecule is made up of two hydrogen atoms and one oxygen atom.", "TRUE", "FALSE", "", "", null},
                // ID 11070
                {"TRUE or FALSE. A water molecule is made up of one hydrogen atom and two oxygen atoms.", "FALSE", "TRUE", "", "", null},
                // ID 11071
                {"TRUE or FALSE. A water molecule is made up of one hydrogen atom and one oxygen atom.", "FALSE", "TRUE", "", "", null},
                {
                        "The formation of water droplets on the outer surface of a cold glass is an example of ________",
                        "condensation",
                        "evaporation",
                        "",
                        "",
                        null},
                // ID 11073
                {
                        "Burning of wax candle is an example of ________ change",
                        "chemical",
                        "physical",
                        "",
                        "",
                        null},
                // ID 11074
                {
                        "Which of the following change is reversible (we can get the original substance back even after the change takes place).",
                        "physical",
                        "chemical",
                        "",
                        "",
                        null},
                // ID 11075
                {
                        "Which of the following change is irreversible (we cannot get the original substance back once it undergoes change).",
                        "chemical",
                        "physical",
                        "",
                        "",
                        null}
        });

        // Chapter 12:
        FIXED_QUESTIONS.put(12, new String[][]{
                // ID 12001
                {"TRUE or FALSE. Translucent materials allow light to pass through them completely.", "FALSE", "TRUE", "", "", null},
                // ID 12002
                {"TRUE or FALSE. Shadows are always dark", "TRUE", "FALSE", "", "", null},
                // ID 12003
                {"TRUE or FALSE. Only transparent materials can form shadows.", "FALSE", "TRUE", "", "", null},
                // ID 12004
                {"TRUE or FALSE. Shadows can be formed without a light source.", "FALSE", "TRUE", "", "", null},
                // ID 12005
                {"TRUE or FALSE. The size of the shadow of an object is always the same.", "FALSE", "TRUE", "", "", null},
                // ID 12006
                {
                        "Objects that give out light are called:",
                        "luminous",
                        "non-luminous",
                        "opaque",
                        "transparent",
                        null},
                // ID 12007
                {
                        "Which of the following is a transparent object?",
                        "Clear glass",
                        "Wood",
                        "Butter paper",
                        "Mirror",
                        null},
                // ID 12008
                {
                        "Identify the translucent object from the following:",
                        "Frosted glass",
                        "Cardboard",
                        "Mirror",
                        "Clear water",
                        null},
                // ID 12009
                {
                        "Materials that do not allow light to pass through them are called ______",
                        "Opaque",
                        "Transparent",
                        "Translucent",
                        "Light source",
                        null},
                // ID 12010
                {
                        "Which of the following objects cannot form a shadow?",
                        "Clear glass",
                        "Pencil",
                        "Bag",
                        "Notebook",
                        null},
                // ID 12011
                {
                        "A shadow is always formed on the ______ side of the object",
                        "opposite",
                        "same",
                        "",
                        "",
                        null},
                // ID 12012
                {
                        "Butter paper is an example of _______ material",
                        "translucent",
                        "transparent",
                        "",
                        "",
                        null},
                // ID 12013
                {
                        "Shadows are formed by ______ materials",
                        "opaque",
                        "transparent",
                        "",
                        "",
                        null},
                // ID 12014
                {
                        "The size of a shadow depends on the distance of the _______ from the light source",
                        "object",
                        "shadow",
                        "",
                        "",
                        null},
                // ID 12015
                {
                        "The color of a shadow is always _______",
                        "dark",
                        "white",
                        "",
                        "",
                        null},
                // ID 12016
                {
                        "Which of the following is not a translucent object?",
                        "plain glass",
                        "frosted glass",
                        "coloured glass",
                        "butter paper",
                        null},
                // ID 12017
                {
                        "When the light source is close to the object the shadow formed will be ________",
                        "bigger than the object",
                        "smaller than the object",
                        "shorter than the object",
                        "all of these",
                        null}
        });

        // Chapter 13:
        FIXED_QUESTIONS.put(13, new String[][]{
                // ID 13001
                {"TRUE or FALSE. Force can change the direction of motion of an object.", "TRUE", "FALSE", "", "", null},
                // ID 13002
                {"TRUE or FALSE. Energy and force are one and the same.", "FALSE", "TRUE", "", "", null},
                // ID 13003
                {"TRUE or FALSE. Sun is a source of only heat energy.", "FALSE", "TRUE", "", "", null},
                // ID 13004
                {"TRUE or FALSE. Simple machines reduce the effort required to do work.", "TRUE", "FALSE", "", "", null},
                // ID 13005
                {"TRUE or FALSE. Pulley does not change the direction of the force applied.", "FALSE", "TRUE", "", "", null},
                // ID 13006
                {
                        "In which of the following cases, force does not change the shape of an object?",
                        "Lifting a stone",
                        "Squeezing a rubber ball",
                        "Pressing a spring",
                        "Stretching a rubber band",
                        null},
                // ID 13007
                {
                        "Which of the following is a type of force?",
                        "Electrostatic",
                        "Light",
                        "Sound",
                        "Heat",
                        null},
                // ID 13008
                {
                        "Which of the following is an example of a third-class lever?",
                        "Tongs",
                        "Wheelbarrow",
                        "See-saw",
                        "Bottle opener",
                        null},
                // ID 13009
                {
                        "Which of the these forces is always attractive in nature?",
                        "Magnetic",
                        "Friction",
                        "Electrostatic",
                        "Gravity",
                        null},
                // ID 13010
                {
                        "Which of the following is not a simple machine?",
                        "Bicycle",
                        "Lever",
                        "Pulley",
                        "Wheel and axle",
                        null},
                // ID 13011
                {
                        "Choose the odd one out from the following: Scissors, Crowbar, See-saw, Bottle-opener",
                        "Bottle-opener",
                        "Scissors",
                        "Crowbar",
                        "See-saw",
                        null},
                // ID 13012
                {
                        "Choose the odd one out from the following: Stapler, Wheelbarrow, Tweezers, Tongs",
                        "Wheelbarrow",
                        "Stapler",
                        "Tweezers",
                        "Tongs",
                        null},
                // ID 13013
                {
                        "Choose the odd one out from the following: Ramp, Flyover, Slide, See-saw",
                        "See-saw",
                        "Ramp",
                        "Flyover",
                        "Slide",
                        null},
                // ID 13014
                {
                        "Choose the odd one out from the following: Screw, Bottle cap, Ramp, Nut and bolt",
                        "Ramp",
                        "Screw",
                        "Bottle cap",
                        "Nut and bolt",
                        null},
                // ID 13015
                {
                        "Choose the odd one out from the following: Knife, Needle, Flagpole, Axe",
                        "Flagpole",
                        "Knife",
                        "Needle",
                        "Axe",
                        null},
                // ID 13016
                {
                        "Friction always acts _______ the direction of motion",
                        "opposite to",
                        "along",
                        "",
                        "",
                        null},
                // ID 13017
                {
                        "A fan uses _______ energy to work.",
                        "electrical",
                        "light",
                        "",
                        "",
                        null},
                // ID 13018
                {
                        "A light bulb gives _______ energy.",
                        "light",
                        "sound",
                        "",
                        "",
                        null},
                // ID 13019
                {
                        "A wheelbarrow is an example of a ______ lever.",
                        "second-class",
                        "third-class",
                        "",
                        "",
                        null},
                // ID 13020
                {
                        "A simple machine is used to draw water from a well is _______.",
                        "pulley",
                        "lever",
                        "",
                        "",
                        null},
                // ID 13021
                {"TRUE or FALSE. Different types of surfaces create different amount of friction.", "TRUE", "FALSE", "", "", null},
                // ID 13022
                {
                        "________ force is used for the brakes in bicycles.",
                        "Frictional",
                        "Gravitational",
                        "Magnetic",
                        "Electrostatic",
                        null}
        });

        // Chapter 14:
        FIXED_QUESTIONS.put(14, new String[][]{
                // ID 14001
                {"TRUE or FALSE. One centimeter is longer than one kilometer.", "FALSE", "TRUE", "", "", null},
                // ID 14002
                {"TRUE or FALSE. Litre is a unit of mass.", "FALSE", "TRUE", "", "", null},
                // ID 14003
                {"TRUE or FALSE. A day is divided into 24 equal durations.", "TRUE", "FALSE", "", "", null},
                // ID 14004
                {"TRUE or FALSE. Clinical thermometers are used by doctors.", "TRUE", "FALSE", "FALSE", "", null},
                // ID 14005
                {"TRUE or FALSE. Laboratory thermometers are used in science laboratory.", "TRUE", "FALSE", "", "", null},
                // ID 14006
                {
                        "Identify the unit of length which is not related to a human body part.",
                        "Centimeter",
                        "Cubit",
                        "Foot",
                        "Hand span",
                        null},
                // ID 14007
                {"Which among the following is the biggest unit of length?", "kilometre", "metre","millimetre","centimetre",null},
                // ID 14008
                {"How many millilitres make one litre?","1000",
                        "100",
                        "10",
                        "1",
                        null},
                // ID 14009
                {
                        "Which among the following is the smallest unit of time?",
                        "second",
                        "hour",
                        "minute",
                        "day",
                        null},
                // ID 14010
                {
                        "Degree of hotness and coldness of an object is called ______",
                        "Temperature",
                        "Capacity",
                        "Time",
                        "Mass",
                        null},
                // ID 14011
                {
                        "Fixed standards used for measurement are called ________",
                        "units",
                        "cubit",
                        "",
                        "",
                        null},
                // ID 14012
                {
                        "1 kilometre is equal to ________ metres",
                        "1000",
                        "100",
                        "",
                        "",
                        null},
                // ID 14013
                {
                        "The amount of matter present in an object is called its ________",
                        "mass",
                        "capacity",
                        "",
                        "",
                        null},
                // ID 14014
                {
                        "One hour is equal to ________ minutes",
                        "60",
                        "24",
                        "",
                        "",
                        null},
                // ID 14015
                {
                        "A stopwatch is used to measure ________",
                        "time",
                        "temperature",
                        "",
                        "",
                        null}
        });
    }

        public static String[][] getFixedQuestions(int chapter)
        {
            return FIXED_QUESTIONS.getOrDefault(chapter, new String[0][]);
        }
    }