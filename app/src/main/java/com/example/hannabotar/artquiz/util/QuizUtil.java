package com.example.hannabotar.artquiz.util;

import com.example.hannabotar.artquiz.R;
import com.example.hannabotar.artquiz.domain.Question;

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

    public static List<Question> initMockData() {
        List<Question> questionList = new ArrayList<>();
        Map<String, Boolean> answerMap1 = new HashMap<>();
        answerMap1.put("Mona Lisa", true);
        answerMap1.put("Madonna", false);
        answerMap1.put("Venus", false);
        questionList.add(new Question(R.drawable.mona_lisa, "Name the painting: ", answerMap1,
                "The <b>Mona Lisa</b> by Leonardo da Vinci is \"the best known, the most visited, the most written about, the most sung about, the most parodied work of art\" and also one of the most valuable paintings in the world, and has been displayed at the Louvre Museum in Paris since 1797."));

        Map<String, Boolean> answerMap2 = new HashMap<>();
        answerMap2.put("The Starry Night", true);
        answerMap2.put("Swirly Night", false);
        answerMap2.put("Moonlight Sonata", false);
        questionList.add(new Question(R.drawable.starry_night, "Name the painting: ", answerMap2,
                "<b>The Starry Night</b> by Vincent van Gogh is regarded as among the artist's finest works and is one of the most recognized paintings in the history of Western culture. It depicts the view from the east-facing window of his asylum room just before sunrise. The painting has been in the permanent collection of the Museum of Modern Art in New York City since 1941."));

        Map<String, Boolean> answerMap3 = new HashMap<>();
        answerMap3.put("Venus de Milo", true);
        answerMap3.put("The Beauty", false);
        answerMap3.put("Greek Godddess", false);
        questionList.add(new Question(R.drawable.venus_de_milo, "Name the sculpture: ", answerMap3,
                "Aphrodite of Milos, better known as the <b>Venus de Milo</b>, is an ancient Greek statue and one of the most famous works of ancient Greek sculpture. It is thought to be the work of Alexandros of Antioch, created sometime between 130 and 100 BC. It is currently on permanent display at the Louvre Museum in Paris."));

        Map<String, Boolean> answerMap4 = new HashMap<>();
        answerMap4.put("Girl with a Pearl Earring", true);
        answerMap4.put("Girl with Blue Scarf", false);
        answerMap4.put("Self-portrait", false);
        questionList.add(new Question(R.drawable.girl_with_a_pearl_earring, "Name the painting: ", answerMap4,
                "<b>Girl with a Pearl Earring</b> by Johannes Vermeer is a tronie of a girl wearing an exotic dress, an oriental turban, and an improbably large pearl earring. The painting has been in the collection of the Mauritshuis in The Hague since 1902."));

        Map<String, Boolean> answerMap5 = new HashMap<>();
        answerMap5.put("The Last Supper", true);
        answerMap5.put("The Last Dinner", false);
        answerMap5.put("The Feast", false);
        questionList.add(new Question(R.drawable.the_last_supper, "Name the painting: ", answerMap5,
                "<b>The Last Supper</b> by Leonardo da Vinci is a late 15th-century mural painting housed by the refectory of the Convent of Santa Maria delle Grazie in Milan. It is one of the world's most recognizable paintings."));

        Map<String, Boolean> answerMap6 = new HashMap<>();
        answerMap6.put("The Scream", true);
        answerMap6.put("The Yell", false);
        answerMap6.put("Fear", false);
        questionList.add(new Question(R.drawable.the_scream, "Name the painting: ", answerMap6,
                "Der Schrei der Natur (<b>The Scream</b> of Nature) by Edvard Munch has four versions, two painted and two pastel versions. The works show a figure with an agonized expression against a landscape with a tumultuous orange sky."));

        Map<String, Boolean> answerMap7 = new HashMap<>();
        answerMap7.put("American Gothic", true);
        answerMap7.put("Farmers", false);
        answerMap7.put("American Horror", false);
        questionList.add(new Question(R.drawable.american_gothic, "Name the painting: ", answerMap7,
                "<b>American Gothic</b> is a painting by Grant Wood in the collection of the Art Institute of Chicago, depicting a farmer standing beside a woman who has been interpreted to be his daughter or his wife. It is one of the most familiar images in 20th-century American art and has been widely parodied in American popular culture."));

        Map<String, Boolean> answerMap8 = new HashMap<>();
        answerMap8.put("The Creation of Adam", true);
        answerMap8.put("The Touch", false);
        answerMap8.put("Eden", false);
        questionList.add(new Question(R.drawable.the_creation_of_adam, "Name the painting: ", answerMap8,
                "<b>The Creation of Adam</b> is a fresco painting by Michelangelo, which forms part of the Sistine Chapel's ceiling. It illustrates the Biblical creation narrative from the Book of Genesis in which God breathes life into Adam, the first man."));

        Map<String, Boolean> answerMap9 = new HashMap<>();
        answerMap9.put("The Persistence of Memory", true);
        answerMap9.put("Melting Clocks", false);
        answerMap9.put("The Soft Watches", false);
        questionList.add(new Question(R.drawable.the_persistence_of_memory, "Name the painting: ", answerMap9,
                "<b>The Persistence of Memory</b> is a 1931 painting by artist Salvador Dalí, and is one of his most recognizable works. Since 1934 the painting has been in the collection of the Museum of Modern Art (MoMA) in New York City. The painting was inspired by the surrealist perception of a Camembert melting in the sun."));

        Map<String, Boolean> answerMap10 = new HashMap<>();
        answerMap10.put("David", true);
        answerMap10.put("Adam", false);
        answerMap10.put("Apollo", false);
        questionList.add(new Question(R.drawable.david, "Name the painting: ", answerMap10,
                "<b>David</b> is a masterpiece of Renaissance sculpture created in marble between 1501 and 1504 by Michelangelo. David is a 5.17-metre marble statue of a standing male nude. The statue represents the Biblical hero David, a favoured subject in the art of Florence."));

        Map<String, Boolean> answerMap11 = new HashMap<>();
        answerMap11.put("The Birth of Venus", true);
        answerMap11.put("The Birth of Maria", false);
        answerMap11.put("Venus in a Shell", false);
        questionList.add(new Question(R.drawable.the_birth_of_venus, "Name the painting: ", answerMap11,
                "<b>The Birth of Venus</b> by Sandro Botticelli is a painting that depicts the goddess Venus arriving at the shore after her birth, when she had emerged from the sea fully-grown (called Venus Anadyomene and often depicted in art). The painting is in the Uffizi Gallery in Florence, Italy."));

        Map<String, Boolean> answerMap12 = new HashMap<>();
        answerMap12.put("A Sunday Afternoon on the Island of La Grande Jatte", true);
        answerMap12.put("A Saturday Afternoon on the Island of La Grande Jatte", false);
        answerMap12.put("A Wednesday Afternoon on the Island of La Grande Jatte", false);
        questionList.add(new Question(R.drawable.a_sunday_afternoon, "Name the painting: ", answerMap12,
                "<b>A Sunday Afternoon on the Island of La Grande Jatte</b> painted in 1884, is one of Georges Seurat's most famous works. It is a leading example of pointillist technique, executed on a large canvas. Seurat's composition includes a number of Parisians at a park on the banks of the River Seine."));

        Map<String, Boolean> answerMap13 = new HashMap<>();
        answerMap13.put("Whistler's Mother", true);
        answerMap13.put("Whistler's Grandmother", false);
        answerMap13.put("Whistler's Aunt Anne", false);
        questionList.add(new Question(R.drawable.whistlers_mother, "Name the painting: ", answerMap13,
                "Arrangement in Grey and Black No.1, best known under its colloquial name <b>Whistler's Mother</b>, is a painting in oils on canvas created by the American-born painter James McNeill Whistler in 1871. The subject of the painting is Whistler's mother, Anna McNeill Whistler. It is exhibited in the Musée d'Orsay in Paris and is one of the most famous works by an American artist outside the United States."));

        Map<String, Boolean> answerMap14 = new HashMap<>();
        answerMap14.put("Self-portrait without beard", true);
        answerMap14.put("Self-portrait", false);
        answerMap14.put("Without beard", false);
        questionList.add(new Question(R.drawable.self_portrait_without_beard, "Name the painting: ", answerMap14,
                "<b>Self-portrait without beard</b> is an 1889 oil on canvas painting by the post-impressionist artist Vincent van Gogh. It may have been Van Gogh's last self-portrait. It is one of the most expensive paintings of all time, selling for $71.5 million in 1998 in New York City."));

        Map<String, Boolean> answerMap15 = new HashMap<>();
        answerMap15.put("The Kiss", true);
        answerMap15.put("Golden Love", false);
        answerMap15.put("Golden Kiss", false);
        questionList.add(new Question(R.drawable.the_kiss, "Name the painting: ", answerMap15,
                "<b>The Kiss</b> (Lovers) was painted by the Austrian Symbolist painter Gustav Klimt between 1907 and 1908. The work is composed of oil paint with applied layers of gold leaf, an aspect that gives it its strikingly modern, yet evocative appearance. The painting is now in the Österreichische Galerie Belvedere museum in the Belvedere palace, Vienna."));

        Map<String, Boolean> answerMap16 = new HashMap<>();
        answerMap16.put("The Anatomy Lesson of Dr. Nicolaes Tulp", true);
        answerMap16.put("The Surgery", false);
        answerMap16.put("Science Group", false);
        questionList.add(new Question(R.drawable.the_anatomy_lesson, "Name the painting: ", answerMap16,
                "<b>The Anatomy Lesson of Dr. Nicolaes Tulp</b> is a 1632 oil painting on canvas by Rembrandt housed in the Mauritshuis museum in The Hague, the Netherlands. The painting is regarded as one of Rembrandt's early masterpieces. In the work, Dr. Nicolaes Tulp is pictured explaining the musculature of the arm to medical professionals. Some of the spectators are various doctors who paid commissions to be included in the painting."));

        Map<String, Boolean> answerMap17 = new HashMap<>();
        answerMap17.put("The School of Athens", true);
        answerMap17.put("Philosophers", false);
        answerMap17.put("The School of Philosophy", false);
        questionList.add(new Question(R.drawable.the_school_of_athens, "Name the painting: ", answerMap17,
                "<b>The School of Athens</b> is one of the most famous frescoes by the Italian Renaissance artist Raphael, located in the Apostolic Palace in the Vatican. Commentators have suggested that nearly every great ancient Greek philosopher can be found in the painting. In the center of the fresco are the two undisputed main subjects: Plato and Aristotle, thought to be modelled after Leonardo da Vinci and Giuliano da Sangallo."));

        Map<String, Boolean> answerMap18 = new HashMap<>();
        answerMap18.put("Haystacks, (Midday)", true);
        answerMap18.put("Wheatstacks (Sunset, Snow Effect)", false);
        answerMap18.put("Grainstack. (Sunset.)", false);
        questionList.add(new Question(R.drawable.haystacks_midday, "Name the painting: ", answerMap18,
                "<b>Haystacks, (Midday)</b> is a piece from the Haystacks series of impressionist paintings by Claude Monet. The title refers primarily to a twenty-five canvas series which Monet began near the end of the summer of 1890 and continued through the following spring though Monet also produced earlier paintings using this same stack subject."));

        Map<String, Boolean> answerMap19 = new HashMap<>();
        answerMap19.put("Springtime", true);
        answerMap19.put("Summertime", false);
        answerMap19.put("Lady in the Garden", false);
        questionList.add(new Question(R.drawable.springtime, "Name the painting: ", answerMap19,
                "<b>Springtime</b> is an 1872 painting by Claude Monet. It depicts his first wife, Camille Doncieux, seated serenely beneath a canopy of lilacs. The painting is presently held by the Walters Art Museum."));

        Map<String, Boolean> answerMap20 = new HashMap<>();
        answerMap20.put("Pietà", true);
        answerMap20.put("Sorrow", false);
        answerMap20.put("Grief", false);
        questionList.add(new Question(R.drawable.pieta, "Name the painting: ", answerMap20,
                "The <b>Pietà</b> is a work of Renaissance sculpture by Michelangelo Buonarroti, housed in St. Peter's Basilica, Vatican City. This famous work of art depicts the body of Jesus on the lap of his mother Mary after the Crucifixion."));


        long seed = System.nanoTime();
        Collections.shuffle(questionList, new Random(seed));
        return questionList;
    }

}
