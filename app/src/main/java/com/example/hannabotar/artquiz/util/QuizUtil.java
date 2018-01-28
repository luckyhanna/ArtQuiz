package com.example.hannabotar.artquiz.util;

import com.example.hannabotar.artquiz.R;
import com.example.hannabotar.artquiz.domain.Question;
import com.example.hannabotar.artquiz.domain.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by hanna.botar on 1/22/2018.
 */

public class QuizUtil {

    public static final String PAINTING_QUESTION = "Name the painting: ";
    public static final String SCULPTURE_QUESTION = "Name the sculpture: ";

    public static List<Question> initMockData() {
        List<Question> questionList = new ArrayList<>();

        List<Question> freeTextList = new ArrayList<>();
        List<Question> singleChoiceList = new ArrayList<>();
        List<Question> multipleChoiceList = new ArrayList<>();

//        Single chioice questions
        Map<String, Boolean> answerMap1 = new HashMap<>();
        answerMap1.put("Mona Lisa", true);
        answerMap1.put("Madonna", false);
        answerMap1.put("Venus", false);
        singleChoiceList.add(new Question(R.drawable.mona_lisa, PAINTING_QUESTION, answerMap1,
                "The <b>Mona Lisa</b> by Leonardo da Vinci is \"the best known, the most visited, the most written about, the most sung about, the most parodied work of art\" and also one of the most valuable paintings in the world, and has been displayed at the Louvre Museum in Paris since 1797."));

        Map<String, Boolean> answerMap2 = new HashMap<>();
        answerMap2.put("The Starry Night", true);
        answerMap2.put("Swirly Night", false);
        answerMap2.put("Moonlight Sonata", false);
        singleChoiceList.add(new Question(R.drawable.starry_night, PAINTING_QUESTION, answerMap2,
                "<b>The Starry Night</b> by Vincent van Gogh is regarded as among the artist's finest works and is one of the most recognized paintings in the history of Western culture. It depicts the view from the east-facing window of his asylum room just before sunrise. The painting has been in the permanent collection of the Museum of Modern Art in New York City since 1941."));

        Map<String, Boolean> answerMap3 = new HashMap<>();
        answerMap3.put("Venus de Milo", true);
        answerMap3.put("The Beauty", false);
        answerMap3.put("Greek Godddess", false);
        singleChoiceList.add(new Question(R.drawable.venus_de_milo, "Name the sculpture: ", answerMap3,
                "Aphrodite of Milos, better known as the <b>Venus de Milo</b>, is an ancient Greek statue and one of the most famous works of ancient Greek sculpture. It is thought to be the work of Alexandros of Antioch, created sometime between 130 and 100 BC. It is currently on permanent display at the Louvre Museum in Paris."));

        Map<String, Boolean> answerMap4 = new HashMap<>();
        answerMap4.put("Girl with a Pearl Earring", true);
        answerMap4.put("Girl with Blue Scarf", false);
        answerMap4.put("Self-portrait", false);
        singleChoiceList.add(new Question(R.drawable.girl_with_a_pearl_earring, PAINTING_QUESTION, answerMap4,
                "<b>Girl with a Pearl Earring</b> by Johannes Vermeer is a tronie of a girl wearing an exotic dress, an oriental turban, and an improbably large pearl earring. The painting has been in the collection of the Mauritshuis in The Hague since 1902."));

        Map<String, Boolean> answerMap5 = new HashMap<>();
        answerMap5.put("The Last Supper", true);
        answerMap5.put("The Last Dinner", false);
        answerMap5.put("The Feast", false);
        singleChoiceList.add(new Question(R.drawable.the_last_supper, PAINTING_QUESTION, answerMap5,
                "<b>The Last Supper</b> by Leonardo da Vinci is a late 15th-century mural painting housed by the refectory of the Convent of Santa Maria delle Grazie in Milan. It is one of the world's most recognizable paintings."));

        Map<String, Boolean> answerMap6 = new HashMap<>();
        answerMap6.put("The Scream", true);
        answerMap6.put("The Yell", false);
        answerMap6.put("Fear", false);
        singleChoiceList.add(new Question(R.drawable.the_scream, PAINTING_QUESTION, answerMap6,
                "Der Schrei der Natur (<b>The Scream</b> of Nature) by Edvard Munch has four versions, two painted and two pastel versions. The works show a figure with an agonized expression against a landscape with a tumultuous orange sky."));

        Map<String, Boolean> answerMap7 = new HashMap<>();
        answerMap7.put("American Gothic", true);
        answerMap7.put("Farmers", false);
        answerMap7.put("American Horror", false);
        singleChoiceList.add(new Question(R.drawable.american_gothic, PAINTING_QUESTION, answerMap7,
                "<b>American Gothic</b> is a painting by Grant Wood in the collection of the Art Institute of Chicago, depicting a farmer standing beside a woman who has been interpreted to be his daughter or his wife. It is one of the most familiar images in 20th-century American art and has been widely parodied in American popular culture."));

        Map<String, Boolean> answerMap8 = new HashMap<>();
        answerMap8.put("The Creation of Adam", true);
        answerMap8.put("The Touch", false);
        answerMap8.put("Eden", false);
        singleChoiceList.add(new Question(R.drawable.the_creation_of_adam, PAINTING_QUESTION, answerMap8,
                "<b>The Creation of Adam</b> is a fresco painting by Michelangelo, which forms part of the Sistine Chapel's ceiling. It illustrates the Biblical creation narrative from the Book of Genesis in which God breathes life into Adam, the first man."));

        Map<String, Boolean> answerMap9 = new HashMap<>();
        answerMap9.put("The Persistence of Memory", true);
        answerMap9.put("Melting Clocks", false);
        answerMap9.put("The Soft Watches", false);
        singleChoiceList.add(new Question(R.drawable.the_persistence_of_memory, PAINTING_QUESTION, answerMap9,
                "<b>The Persistence of Memory</b> is a 1931 painting by artist Salvador Dalí, and is one of his most recognizable works. Since 1934 the painting has been in the collection of the Museum of Modern Art (MoMA) in New York City. The painting was inspired by the surrealist perception of a Camembert melting in the sun."));

        Map<String, Boolean> answerMap10 = new HashMap<>();
        answerMap10.put("David", true);
        answerMap10.put("Adam", false);
        answerMap10.put("Apollo", false);
        singleChoiceList.add(new Question(R.drawable.david, SCULPTURE_QUESTION, answerMap10,
                "<b>David</b> is a masterpiece of Renaissance sculpture created in marble between 1501 and 1504 by Michelangelo. David is a 5.17-metre marble statue of a standing male nude. The statue represents the Biblical hero David, a favoured subject in the art of Florence."));

        Map<String, Boolean> answerMap11 = new HashMap<>();
        answerMap11.put("The Birth of Venus", true);
        answerMap11.put("The Birth of Maria", false);
        answerMap11.put("Venus in a Shell", false);
        singleChoiceList.add(new Question(R.drawable.the_birth_of_venus, PAINTING_QUESTION, answerMap11,
                "<b>The Birth of Venus</b> by Sandro Botticelli is a painting that depicts the goddess Venus arriving at the shore after her birth, when she had emerged from the sea fully-grown (called Venus Anadyomene and often depicted in art). The painting is in the Uffizi Gallery in Florence, Italy."));

        Map<String, Boolean> answerMap12 = new HashMap<>();
        answerMap12.put("A Sunday Afternoon on the Island of La Grande Jatte", true);
        answerMap12.put("A Saturday Afternoon on the Island of La Grande Jatte", false);
        answerMap12.put("A Wednesday Afternoon on the Island of La Grande Jatte", false);
        singleChoiceList.add(new Question(R.drawable.a_sunday_afternoon, PAINTING_QUESTION, answerMap12,
                "<b>A Sunday Afternoon on the Island of La Grande Jatte</b> painted in 1884, is one of Georges Seurat's most famous works. It is a leading example of pointillist technique, executed on a large canvas. Seurat's composition includes a number of Parisians at a park on the banks of the River Seine."));

        Map<String, Boolean> answerMap13 = new HashMap<>();
        answerMap13.put("Whistler's Mother", true);
        answerMap13.put("Whistler's Grandmother", false);
        answerMap13.put("Whistler's Aunt Anne", false);
        singleChoiceList.add(new Question(R.drawable.whistlers_mother, PAINTING_QUESTION, answerMap13,
                "Arrangement in Grey and Black No.1, best known under its colloquial name <b>Whistler's Mother</b>, is a painting in oils on canvas created by the American-born painter James McNeill Whistler in 1871. The subject of the painting is Whistler's mother, Anna McNeill Whistler. It is exhibited in the Musée d'Orsay in Paris and is one of the most famous works by an American artist outside the United States."));

        Map<String, Boolean> answerMap14 = new HashMap<>();
        answerMap14.put("Self-portrait without beard", true);
        answerMap14.put("Self-portrait", false);
        answerMap14.put("Without beard", false);
        singleChoiceList.add(new Question(R.drawable.self_portrait_without_beard, PAINTING_QUESTION, answerMap14,
                "<b>Self-portrait without beard</b> is an 1889 oil on canvas painting by the post-impressionist artist Vincent van Gogh. It may have been Van Gogh's last self-portrait. It is one of the most expensive paintings of all time, selling for $71.5 million in 1998 in New York City."));

        Map<String, Boolean> answerMap15 = new HashMap<>();
        answerMap15.put("The Kiss", true);
        answerMap15.put("Golden Love", false);
        answerMap15.put("Golden Kiss", false);
        singleChoiceList.add(new Question(R.drawable.the_kiss, PAINTING_QUESTION, answerMap15,
                "<b>The Kiss</b> (Lovers) was painted by the Austrian Symbolist painter Gustav Klimt between 1907 and 1908. The work is composed of oil paint with applied layers of gold leaf, an aspect that gives it its strikingly modern, yet evocative appearance. The painting is now in the Österreichische Galerie Belvedere museum in the Belvedere palace, Vienna."));

        Map<String, Boolean> answerMap16 = new HashMap<>();
        answerMap16.put("The Anatomy Lesson of Dr. Nicolaes Tulp", true);
        answerMap16.put("The Surgery", false);
        answerMap16.put("Science Group", false);
        singleChoiceList.add(new Question(R.drawable.the_anatomy_lesson, PAINTING_QUESTION, answerMap16,
                "<b>The Anatomy Lesson of Dr. Nicolaes Tulp</b> is a 1632 oil painting on canvas by Rembrandt housed in the Mauritshuis museum in The Hague, the Netherlands. The painting is regarded as one of Rembrandt's early masterpieces. In the work, Dr. Nicolaes Tulp is pictured explaining the musculature of the arm to medical professionals. Some of the spectators are various doctors who paid commissions to be included in the painting."));

        Map<String, Boolean> answerMap17 = new HashMap<>();
        answerMap17.put("The School of Athens", true);
        answerMap17.put("Philosophers", false);
        answerMap17.put("The School of Philosophy", false);
        singleChoiceList.add(new Question(R.drawable.the_school_of_athens, PAINTING_QUESTION, answerMap17,
                "<b>The School of Athens</b> is one of the most famous frescoes by the Italian Renaissance artist Raphael, located in the Apostolic Palace in the Vatican. Commentators have suggested that nearly every great ancient Greek philosopher can be found in the painting. In the center of the fresco are the two undisputed main subjects: Plato and Aristotle, thought to be modelled after Leonardo da Vinci and Giuliano da Sangallo."));
        Map<String, Boolean> answerMap18 = new HashMap<>();
        answerMap18.put("Haystacks, (Midday)", true);
        answerMap18.put("Wheatstacks (Sunset, Snow Effect)", false);
        answerMap18.put("Grainstack. (Sunset.)", false);
        singleChoiceList.add(new Question(R.drawable.haystacks_midday, PAINTING_QUESTION, answerMap18,
                "<b>Haystacks, (Midday)</b> is a piece from the Haystacks series of impressionist paintings by Claude Monet. The title refers primarily to a twenty-five canvas series which Monet began near the end of the summer of 1890 and continued through the following spring though Monet also produced earlier paintings using this same stack subject."));

        Map<String, Boolean> answerMap19 = new HashMap<>();
        answerMap19.put("Springtime", true);
        answerMap19.put("Summertime", false);
        answerMap19.put("Lady in the Garden", false);
        singleChoiceList.add(new Question(R.drawable.springtime, PAINTING_QUESTION, answerMap19,
                "<b>Springtime</b> is an 1872 painting by Claude Monet. It depicts his first wife, Camille Doncieux, seated serenely beneath a canopy of lilacs. The painting is presently held by the Walters Art Museum."));

        Map<String, Boolean> answerMap20 = new HashMap<>();
        answerMap20.put("Pietà", true);
        answerMap20.put("Sorrow", false);
        answerMap20.put("Grief", false);
        singleChoiceList.add(new Question(R.drawable.pieta, SCULPTURE_QUESTION, answerMap20,
                "The <b>Pietà</b> is a work of Renaissance sculpture by Michelangelo Buonarroti, housed in St. Peter's Basilica, Vatican City. This famous work of art depicts the body of Jesus on the lap of his mother Mary after the Crucifixion."));

        // Multiple choice questions
        Map<String, Boolean> multipleMap1 = new HashMap<>();
        multipleMap1.put("The Last Supper", true);
        multipleMap1.put("Mona Lisa", true);
        multipleMap1.put("The Three Graces", false);
        String explanation1 = "<b>The Last Supper</b> and <b>Mona Lisa</b> are Leonardo da Vinci's famous paintings. " +
                "<b>The Three Graces</b> is a 1635 oil painting by Rubens.";
        String question1 = "Check Leonardo da Vinci's painting(s):";
        multipleChoiceList.add(new Question(R.drawable.leonardo_da_vinci, question1, multipleMap1, explanation1, QuestionType.MULTIPLE_CHOICE));

        Map<String, Boolean> multipleMap2 = new HashMap<>();
        multipleMap2.put("The Night Watch", true);
        multipleMap2.put("Tha Bathers", false);
        multipleMap2.put("Whistler's Mother", false);
        String explanation2 = "<b>The Night Watch</b> is a 1642 painting by Rembrandt van Rijn. " +
                "<b>Whistler's Mother</b> is a painting in oils on canvas by James McNeill Whistler. " +
                "<b>The Bathers</b> by Paul Cézanne is considered to be the painter's finest work.";
        String question2 = "Check Rembrandt's painting(s):";
        multipleChoiceList.add(new Question(R.drawable.rembrandt, question2, multipleMap2, explanation2, QuestionType.MULTIPLE_CHOICE));

        Map<String, Boolean> multipleMap3 = new HashMap<>();
        multipleMap3.put("The Starry Night", true);
        multipleMap3.put("Wheat Field with Crows", true);
        multipleMap3.put("The Potato Eaters", true);
        String explanation3 = "<b>The Starry Night</b>, " +
                "<b>Wheat Field with Crows</b> and " +
                "<b>The Potato Eaters</b> are three famous painting by Vincent van Gogh.";
        String question3 = "Check Van Gogh's painting(s):";
        multipleChoiceList.add(new Question(R.drawable.van_gogh, question3, multipleMap3, explanation3, QuestionType.MULTIPLE_CHOICE));


        // Free text questions
        Map<String, Boolean> singleText1 = new HashMap<>();
        singleText1.put("1452", true);
        String explanationText1 = "Leonardo di ser Piero da Vinci was born on 15 April <b>1452</b> in Vinci, Republic of Florence.";
        freeTextList.add(new Question(R.drawable.leonardo_da_vinci, "In what year was Leonardo da Vinci born?",
                singleText1, explanationText1, QuestionType.FREE_TEXT));

        Map<String, Boolean> singleText2 = new HashMap<>();
        singleText2.put("1452", true);
        String explanationText2 = "Salvador Domingo Felipe Jacinto Dalí Domenech was born on 15 April <b>1452</b> in Vinci, Republic of Florence.";
        freeTextList.add(new Question(R.drawable.dali, "In what year was Leonardo da Vinci born?",
                singleText2, explanationText2, QuestionType.FREE_TEXT));



        long seed = System.nanoTime();
        Collections.shuffle(singleChoiceList, new Random(seed));
        Collections.shuffle(multipleChoiceList, new Random(seed));
        Collections.shuffle(freeTextList, new Random(seed));

        questionList.addAll(singleChoiceList.subList(0,5));
        questionList.addAll(multipleChoiceList);
        questionList.addAll(freeTextList);

        Collections.shuffle(questionList, new Random(seed));
        return questionList;
    }

}
