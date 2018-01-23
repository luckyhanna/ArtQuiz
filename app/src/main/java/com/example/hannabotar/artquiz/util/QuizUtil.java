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
                "The Mona Lisa by Leonardo da Vinci is the most well-known work of art in history, and has been at the Louvre Museum in Paris since 1797."));

        Map<String, Boolean> answerMap2 = new HashMap<>();
        answerMap2.put("The Starry Night", true);
        answerMap2.put("Swirly Night", false);
        answerMap2.put("Moonlight Sonata", false);
        questionList.add(new Question(R.drawable.starry_night, "Name the painting: ", answerMap2,
                "The Starry Night by Vincent van Gogh was inspired by the painter's view in his asylum. It is on permanent collection at the Museum of Modern Art in New York City."));

        Map<String, Boolean> answerMap3 = new HashMap<>();
        answerMap3.put("Venus de Milo", true);
        answerMap3.put("The Beauty", false);
        answerMap3.put("Greek Godddess", false);
        questionList.add(new Question(R.drawable.venus_de_milo, "Name the sculpture: ", answerMap3,
                "Aphrodite of Milos, most commonly called Venus de Milo, is a sculpture thought to be created by Alexandros of Antioch around 130 BC. The statue originally had arms, and is on display at the Louvre in Paris."));

        long seed = System.nanoTime();
        Collections.shuffle(questionList, new Random(seed));
        return questionList;
    }

}
