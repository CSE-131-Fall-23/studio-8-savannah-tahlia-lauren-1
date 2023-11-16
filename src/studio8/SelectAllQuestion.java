package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		
		super(prompt, answer, choices.length, choices);
		//Hint: 1 point per choice
		//FIXME
	}
	
	public int checkAnswer(String givenAnswer) {
		int pointsEarned = (this.getChoices);
		int sub = 0; 
		for (int i=0; i<givenAnswer.length(); i++) {
		String check = "";
		check = check + givenAnswer.charAt(i);
		if (this.getAnswer().contains(check) == false) {
				sub = sub + 1;
			}
		for (int j=0; j<this.getAnswer().length(); j++) {
			String check2 = "";
			check2 = check2 + getAnswer().charAt(j);
			if (givenAnswer.contains(check2) == false) {
				sub = sub + 1;
			}
		}
		}
		//FIXME Should return partial credit (if earned)!
		return pointsEarned-sub;
	}
	
	public static void main(String[] args) {
		String[] choices = {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); //no credit
		System.out.println(selectAll.checkAnswer("13")); //full credit
		System.out.println(selectAll.checkAnswer("31")); //full credit
		System.out.println(selectAll.checkAnswer("1")); //3 points
		System.out.println(selectAll.checkAnswer("3")); //3 points
		System.out.println(selectAll.checkAnswer("23")); //2 points
		System.out.println(selectAll.checkAnswer("34")); //2 points
		System.out.println(selectAll.checkAnswer("4")); //1 point
		System.out.println(selectAll.checkAnswer("124")); //1 point
		System.out.println(selectAll.checkAnswer("24")); //0 points
		
	}
}
