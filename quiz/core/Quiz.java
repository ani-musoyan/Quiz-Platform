package am.aua.quiz.core;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidAnswerException;
import am.aua.quiz.questions.FillInTheBlankQuestion;
import am.aua.quiz.questions.MultipleChoiceQuestion;
import am.aua.quiz.questions.Question;
import am.aua.quiz.questions.YesNoQuestion;
import am.aua.quiz.exceptions.InvalidQuestionException;

public class Quiz {
    private String name;
    private Question[] questions;

    private void validateQuestions(Question[] questions) throws InvalidQuestionException {
        if (questions == null) {
            throw new InvalidQuestionException("Question array cannot be null.");
        }
        for (Question question : questions) {
            if (question == null) {
                throw new InvalidQuestionException("A question object is null.");
            }
        }
    }


    public Quiz(String name) throws InvalidQuestionException  {
        this.name = name;
        if (name.equals("Rivers of the World")) {
            questions = new Question[]{
                    new YesNoQuestion("Is the Nile River the longest river in the world?", false),
                    new MultipleChoiceQuestion("Which river is known as the \"Father of Rivers\"?",
                            new String[]{"Amazon River", "Ganges River", "Mississippi River", "Indus River"}, 1),
                    new MultipleChoiceQuestion("The Yangtze River is the longest river in which country?",
                            new String[]{"China", "Brazil", "India", "Russia"}, 0),
                    new MultipleChoiceQuestion("Which river forms part of the border between the United States and Mexico?",
                            new String[]{"Colorado River", "Rio Grande", "Columbia River", "Missouri River"}, 1),
                    new MultipleChoiceQuestion("The Danube River flows through which European capital city?",
                            new String[]{"Paris", "Rome", "Vienna", "Berlin"}, 2)
            };
        } else if (name.equals("Capitals of the World")) {
            questions = new Question[]{
                    new FillInTheBlankQuestion("What is the capital of Canada?", "Ottawa"),
                    new MultipleChoiceQuestion("Which city is the capital of Argentina?",
                            new String[]{"Rio de Janeiro", "Buenos Aires", "Santiago", "Lima"}, 1),
                    new FillInTheBlankQuestion("What is the capital of New Zealand?", "Wellington"),
                    new MultipleChoiceQuestion("The capital of South Africa is:",
                            new String[]{"Johannesburg", "Cape Town", "Pretoria", "Durban"}, 2),
                    new FillInTheBlankQuestion("What is the capital of Thailand?", "Bangkok")
            };
        } else if (name.equals("Mountain Ranges")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Which mountain range separates Europe from Asia?",
                            new String[]{"Andes", "Rocky Mountains", "Alps", "Ural Mountains"}, 3),
                    new MultipleChoiceQuestion("Mount Everest is part of which mountain range?",
                            new String[]{"Himalayas", "Appalachian Mountains", "Rocky Mountains", "Andes"}, 0),
                    new MultipleChoiceQuestion("The Sierra Nevada mountain range is located in which country?",
                            new String[]{"United States", "Spain", "Mexico", "Italy"}, 0),
                    new MultipleChoiceQuestion("Which mountain range is the longest in the world?",
                            new String[]{"Andes", "Alps", "Rocky Mountains", "Andes"}, 0),
                    new MultipleChoiceQuestion("The Atlas Mountains are located in which continent?",
                            new String[]{"Africa", "Europe", "Asia", "South America"}, 0)
            };
        } else if (name.equals("Oceans and Seas")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("The Indian Ocean borders which continent to the west?",
                            new String[]{"Africa", "Asia", "Europe", "Australia"}, 0),
                    new MultipleChoiceQuestion("The Gulf of Mexico is an extension of which ocean?",
                            new String[]{"Atlantic Ocean", "Pacific Ocean", "Indian Ocean", "Arctic Ocean"}, 0),
                    new YesNoQuestion("The Caspian Sea is the largest inland body of water in the world. True or False?", true),
                    new MultipleChoiceQuestion("The Dead Sea, known for its high salt content, is bordered by which two countries?",
                            new String[]{"Israel and Jordan", "Israel and Lebanon", "Jordan and Iraq", "Israel and Egypt"}, 0),
                    new MultipleChoiceQuestion("Which ocean is the largest by area?",
                            new String[]{"Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Southern Ocean"}, 0)
            };
        } else if (name.equals("Countries and Continents")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Which country is the smallest by land area?",
                            new String[]{"Monaco", "Vatican City", "Nauru", "Malta"}, 1),
                    new MultipleChoiceQuestion("Brazil is located in which continent?",
                            new String[]{"South America", "Africa", "Asia", "Europe"}, 0),
                    new MultipleChoiceQuestion("Which continent is the least populated?",
                            new String[]{"Asia", "Europe", "Australia", "Antarctica"}, 3),
                    new MultipleChoiceQuestion("Which country is both a continent and an island?",
                            new String[]{"Madagascar", "Greenland", "Iceland", "Australia"}, 3),
                    new MultipleChoiceQuestion("The Panama Canal is located in which continent?",
                            new String[]{"North America", "South America", "Central America", "Europe"}, 2)
            };
        } else if (name.equals("Ancient Civilizations")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Which ancient civilization built the Great Pyramid of Giza?",
                            new String[]{"Ancient Greece", "Ancient Egypt", "Ancient Rome", "Ancient Mesopotamia"}, 1),
                    new FillInTheBlankQuestion("The city of Rome was founded in which year?", "753 BCE"),
                    new MultipleChoiceQuestion("Who was the first emperor of China's Qin Dynasty?",
                            new String[]{"Confucius", "Shi Huangdi", "Alexander the Great", "Julius Caesar"}, 1),
                    new MultipleChoiceQuestion("The ancient city of Babylon was located in present-day:",
                            new String[]{"Egypt", "Iraq", "Greece", "Turkey"}, 1),
                    new MultipleChoiceQuestion("The ancient Greek city-state of Sparta was known for its focus on:",
                            new String[]{"Democracy", "Education", "Military prowess", "Trade and commerce"}, 2)
            };
        } else if (name.equals("Medieval History")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("The Magna Carta, signed in 1215, limited the power of which English monarch?",
                            new String[]{"Henry VIII", "Richard the Lionheart", "Edward I", "John"}, 3),
                    new MultipleChoiceQuestion("The Hundred Years' War was fought between which two countries?",
                            new String[]{"England and France", "Spain and Portugal", "France and Germany", "England and Scotland"}, 0),
                    new MultipleChoiceQuestion("The Black Death, a devastating pandemic, spread across Europe in the:",
                            new String[]{"12th century", "13th century", "14th century", "15th century"}, 2),
                    new MultipleChoiceQuestion("The Ottoman Empire was founded in the early:",
                            new String[]{"11th century", "13th century", "15th century", "17th century"}, 2),
                    new MultipleChoiceQuestion("Joan of Arc played a significant role in the:",
                            new String[]{"Hundred Years' War", "Crusades", "Wars of the Roses", "Reconquista"}, 0)
            };
        } else if (name.equals("Age of Exploration")) {
            questions = new Question[]{
                    new FillInTheBlankQuestion("Christopher Columbus first reached the Americas in the year?", "1492"),
                    new MultipleChoiceQuestion("Who was the first European explorer to reach India by sea?",
                            new String[]{"Vasco da Gama", "Ferdinand Magellan", "Christopher Columbus", "Marco Polo"}, 0),
                    new MultipleChoiceQuestion("The Treaty of Tordesillas, signed in 1494, divided newly discovered lands between which two countries?",
                            new String[]{"Spain and Portugal", "England and France", "Italy and Austria", "Netherlands and Belgium"}, 0),
                    new MultipleChoiceQuestion("The conquistadors were Spanish explorers who conquered:",
                            new String[]{"North America", "Africa", "Asia", "South America"}, 3),
                    new MultipleChoiceQuestion("The first circumnavigation of the globe was completed by:",
                            new String[]{"Ferdinand Magellan", "Vasco da Gama", "Christopher Columbus", "Amerigo Vespucci"}, 0)
            };
        } else if (name.equals("Industrial Revolution")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("The Industrial Revolution began in which country?",
                            new String[]{"United States", "France", "England", "Germany"}, 2),
                    new MultipleChoiceQuestion("Who invented the spinning jenny, a key advancement in textile production?",
                            new String[]{"James Watt", "Samuel Morse", "James Hargreaves", "Alexander Graham Bell"}, 2),
                    new MultipleChoiceQuestion("The steam engine was improved and popularized by:",
                            new String[]{"James Watt", "Thomas Edison", "Henry Ford", "Alexander Graham Bell"}, 0),
                    new MultipleChoiceQuestion("The telegraph was invented by:",
                            new String[]{"Samuel Morse", "Alexander Graham Bell", "Thomas Edison", "Eli Whitney"}, 0),
                    new MultipleChoiceQuestion("The Crystal Palace, built for the Great Exhibition of 1851, was located in:",
                            new String[]{"London", "Paris", "New York", "Berlin"}, 0)
            };
        } else if (name.equals("World Wars")) {
            questions = new Question[]{
                    new FillInTheBlankQuestion("World War I began in which year?", "1914"),
                    new MultipleChoiceQuestion("The Treaty of Versailles officially ended which conflict?",
                            new String[]{"World War I", "World War II", "Korean War", "Vietnam War"}, 0),
                    new MultipleChoiceQuestion("The Battle of Stalingrad, a turning point in World War II, took place in which country?",
                            new String[]{"Germany", "France", "Soviet Union", "Italy"}, 2),
                    new MultipleChoiceQuestion("D-Day, the Allied invasion of Normandy, occurred in:",
                            new String[]{"1943", "1944", "1945", "1946"}, 1),
                    new MultipleChoiceQuestion("The dropping of atomic bombs on Hiroshima and Nagasaki occurred in which year?",
                            new String[]{"1941", "1943", "1945", "1947"}, 2)
            };
        } else if (name.equals("Classic Films")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Who directed the movie \"Citizen Kane\"?",
                            new String[]{"Alfred Hitchcock", "Orson Welles", "Stanley Kubrick", "Martin Scorsese"}, 1),
                    new MultipleChoiceQuestion("Which classic film features the line, \"Here's looking at you, kid\"?",
                            new String[]{"Casablanca", "Gone with the Wind", "Singin' in the Rain", "It's a Wonderful Life"}, 0),
                    new MultipleChoiceQuestion("Who played the lead role in \"Gone with the Wind\"?",
                            new String[]{"Audrey Hepburn", "Marilyn Monroe", "Vivien Leigh", "Katharine Hepburn"}, 2),
                    new MultipleChoiceQuestion("\"The Wizard of Oz\" was released in which year?",
                            new String[]{"1939", "1941", "1950", "1960"}, 0),
                    new MultipleChoiceQuestion("Which actor portrayed Atticus Finch in the film adaptation of \"To Kill a Mockingbird\"?",
                            new String[]{"Gregory Peck", "James Stewart", "Cary Grant", "Spencer Tracy"}, 0)
            };
        } else if (name.equals("Modern Classics")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Who directed the movie \"Pulp Fiction\"?",
                            new String[]{"Quentin Tarantino", "Martin Scorsese", "Steven Spielberg", "Christopher Nolan"}, 0),
                    new MultipleChoiceQuestion("Which film won the Academy Award for Best Picture in 1994?",
                            new String[]{"Forrest Gump", "The Shawshank Redemption", "Schindler's List", "Braveheart"}, 0),
                    new MultipleChoiceQuestion("Who played the character Neo in \"The Matrix\" trilogy?",
                            new String[]{"Keanu Reeves", "Tom Cruise", "Leonardo DiCaprio", "Will Smith"}, 0),
                    new MultipleChoiceQuestion("\"The Silence of the Lambs\" features which iconic character?",
                            new String[]{"Hannibal Lecter", "Norman Bates", "Michael Myers", "Freddy Krueger"}, 0),
                    new MultipleChoiceQuestion("Who directed the film \"Goodfellas\"?",
                            new String[]{"Martin Scorsese", "Francis Ford Coppola", "Brian De Palma", "Quentin Tarantino"}, 0)
            };
        } else if (name.equals("Animated Movies")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Which Disney movie features the song \"Let It Go\"?",
                            new String[]{"The Lion King", "Frozen", "Aladdin", "Beauty and the Beast"}, 1),
                    new MultipleChoiceQuestion("Who provided the voice for Woody in the \"Toy Story\" movies?",
                            new String[]{"Tom Hanks", "Tim Allen", "Billy Crystal", "Robin Williams"}, 0),
                    new MultipleChoiceQuestion("\"Spirited Away\" is a critically acclaimed animated film from which country?",
                            new String[]{"Japan", "France", "United States", "China"}, 0),
                    new MultipleChoiceQuestion("Which studio produced the movie \"Shrek\"?",
                            new String[]{"Disney", "DreamWorks Animation", "Pixar Animation Studios", "Warner Bros. Animation"}, 1),
                    new MultipleChoiceQuestion("In \"The Incredibles,\" what is the superhero name of Mr. Incredible's wife?",
                            new String[]{"Elastigirl", "Violet", "Mirage", "Frozone"}, 0)
            };
        } else if (name.equals("Sci-Fi and Fantasy")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Who directed the 1977 film \"Star Wars: A New Hope\"?",
                            new String[]{"George Lucas", "Steven Spielberg", "Ridley Scott", "James Cameron"}, 0),
                    new MultipleChoiceQuestion("\"Blade Runner\" is based on a novel by which author?",
                            new String[]{"Philip K. Dick", "Isaac Asimov", "Arthur C. Clarke", "Ray Bradbury"}, 0),
                    new MultipleChoiceQuestion("Who played the character Harry Potter in the film series?",
                            new String[]{"Daniel Radcliffe", "Rupert Grint", "Emma Watson", "Tom Felton"}, 0),
                    new MultipleChoiceQuestion("In \"The Lord of the Rings\" trilogy, who is the rightful heir to the throne of Gondor?",
                            new String[]{"Frodo Baggins", "Aragorn", "Legolas", "Gandalf"}, 1),
                    new MultipleChoiceQuestion("Which film features a character named Neo who discovers the truth about reality?",
                            new String[]{"The Matrix", "Inception", "Interstellar", "The Terminator"}, 0)
            };
        } else if (name.equals("Action and Adventure")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Who directed the film \"Jurassic Park\"?",
                            new String[]{"Steven Spielberg", "James Cameron", "Ridley Scott", "Christopher Nolan"}, 0),
                    new MultipleChoiceQuestion("Which actor portrays the character James Bond in the film series?",
                            new String[]{"Daniel Craig", "Pierce Brosnan", "Sean Connery", "Roger Moore"}, 0),
                    new MultipleChoiceQuestion("\"Indiana Jones and the Last Crusade\" was released in which year?",
                            new String[]{"1981", "1984", "1989", "1991"}, 2),
                    new MultipleChoiceQuestion("Who played the character Trinity in \"The Matrix\" trilogy?",
                            new String[]{"Carrie-Anne Moss", "Charlize Theron", "Jennifer Lawrence", "Angelina Jolie"}, 0),
                    new MultipleChoiceQuestion("\"Die Hard\" is set primarily in which location?",
                            new String[]{"Office building", "Airport", "Shopping mall", "Train station"}, 0)
            };
        } else if (name.equals("Football (Soccer)")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Which country won the FIFA World Cup in 2018?",
                            new String[]{"Germany", "Brazil", "France", "Argentina"}, 2),
                    new MultipleChoiceQuestion("Who is the all-time top scorer in the English Premier League?",
                            new String[]{"Wayne Rooney", "Alan Shearer", "Thierry Henry", "Cristiano Ronaldo"}, 1),
                    new MultipleChoiceQuestion("In which country is FC Barcelona based?",
                            new String[]{"Spain", "Italy", "Germany", "England"}, 0),
                    new MultipleChoiceQuestion("Who won the UEFA Champions League in the 2019-2020 season?",
                            new String[]{"Liverpool", "Bayern Munich", "Real Madrid", "Chelsea"}, 1),
                    new MultipleChoiceQuestion("Which player has won the Ballon d'Or award the most times?",
                            new String[]{"Lionel Messi", "Cristiano Ronaldo", "Michel Platini", "Johan Cruyff"}, 0)
            };
        } else if (name.equals("Basketball")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Who is the NBA's all-time leading scorer?",
                            new String[]{"LeBron James", "Michael Jordan", "Kobe Bryant", "Kareem Abdul-Jabbar"}, 3),
                    new MultipleChoiceQuestion("Which team has won the most NBA championships?",
                            new String[]{"Boston Celtics", "Los Angeles Lakers", "Chicago Bulls", "Golden State Warrior"}, 1),
                    new MultipleChoiceQuestion("Who is the only player to have scored 100 points in a single NBA game?",
                            new String[]{"LeBron James", "Kobe Bryant", "Michael Jordan", "Wilt Chamberlain"}, 3),
                    new MultipleChoiceQuestion("The Harlem Globetrotters are known for their expertise in which sport?",
                            new String[]{"Basketball", "Football", "Soccer", "Baseball"}, 0),
                    new MultipleChoiceQuestion("Who won the NBA Most Valuable Player (MVP) award for the 2019-2020 season?",
                            new String[]{"Giannis Antetokounmpo", "LeBron James", "James Harden", "Kawhi Leonard"}, 0)
            };
        } else if (name.equals("Tennis")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion(" Who holds the record for the most Grand Slam singles titles in tennis history?",
                            new String[]{"Rafael Nadal", "Roger Federer", "Novak Djokovic", "Serena Williams"}, 1),
                    new FillInTheBlankQuestion("Wimbledon is played on __________ courts.", "grass"),
                    new YesNoQuestion("Martina Hingis was the youngest player to ever win a Grand Slam singles title.", true),
                    new MultipleChoiceQuestion("Who won the most recent Wimbledon Men's Singles title?",
                            new String[]{"Novak Djokovic", "Rafael Nadal", "Roger Federer", "Andy Murray"}, 1),
                    new MultipleChoiceQuestion("Which player holds the record for the most consecutive weeks as the ATP World No. 1?",
                            new String[]{"Novak Djokovic", "Roger Federer", "Rafael Nadal", "Pete Sampras"}, 1)
            };
        } else if (name.equals("American Football")) {
            questions = new Question[]{
                    new MultipleChoiceQuestion("Who won the most recent Super Bowl?",
                            new String[]{"Kansas City Chiefs", "Tampa Bay Buccaneers", "New England Patriots", "Los Angeles Rams"}, 1),
                    new MultipleChoiceQuestion("Which NFL team has won the most Super Bowl championships?",
                            new String[]{"Dallas Cowboys", "New England Patriots", "Pittsburgh Steelers", "San Francisco 49ers"}, 1),
                    new YesNoQuestion("Drew Brees is the all-time passing yards leader in the NFL", true),
                    new FillInTheBlankQuestion("College football team, ___ ___ ___ has won the most national championships.", "Alabama Crimson Tide"),
                    new FillInTheBlankQuestion("Who holds the record for the most rushing yards in a single NFL season? _____", "Eric Dickerson")
            };
        } else if (name.equals("Olympics")) {//
            questions = new Question[]{
                    new MultipleChoiceQuestion("In which city were the first modern Olympic Games held?",
                            new String[]{"Paris", "Athens", "London", "Rome"}, 1),
                    new YesNoQuestion("Athlete Usain Bolt has won the most Olympic gold medals in history.", false),
                    new MultipleChoiceQuestion("What is the symbol of the Olympic Games?",
                            new String[]{"Dove", "Torch", "Laurel wreath", "Rings"}, 3),
                    new YesNoQuestion("In 1924  were the first Winter Olympic Games.", true),
                    new FillInTheBlankQuestion("The Summer Olympics of 2020 were postponed to 2021 due to ____", "COVID-19")
            };
        }
        validateQuestions(questions);
    }

    public String getName() {
        return name;
    }

    public void takeQuiz() {
        int score = 0;
        for (Question question : questions) {
            // Display the question using its overridden toString() method
            QuizConsole.displayMessage(question.toString());

            // Get user input
            String answer = QuizConsole.getUserInput();

            try {
                // Check if the answer is valid
                if (!isValidAnswer(question, answer)) {
                    throw new InvalidAnswerException("Invalid answer.");
                }
                // Check the answer
                question.checkAnswer(answer);
                QuizConsole.displayMessage("Correct!");
                score++;
            } catch (InvalidAnswerException e) {
                QuizConsole.displayMessage(e.getMessage());
            } catch (RuntimeException e) {
                QuizConsole.displayMessage("Incorrect.");
            }
        }
        // Display the quiz completion message along with the score
        QuizConsole.displayMessage("Quiz completed. Your score: " + score + "/" + questions.length);
    }

    private boolean isValidAnswer(Question question, String answer) {
        if (question instanceof YesNoQuestion) {
            return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no");
        } else if (question instanceof MultipleChoiceQuestion) {
            answer = answer.toUpperCase();
            return answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D");
        }
        return true;
    }


}