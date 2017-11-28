import java.io.FileNotFoundException;
import java.util.Scanner;


public class Menu {
	private Scanner input;
	private String teamName;
	private Analyze analyze;
	private String player;

	
	Menu(){
		input = new Scanner(System.in);
		teamName = new String();
		analyze = new Analyze();
	}
	public void showMenu(){
		int userSelection;
		while(true){
			System.out.println("**********Welcome to MLB Analyzing System**********");
			System.out.println("1. MLB 팀 분석");
			System.out.println("2. MLB 선수 분석");
			System.out.println("3. MLB 상대선수 분석");
			System.out.println("4. 프로그램 종료");
			userSelection = input.nextInt();
			input.nextLine();
			if(userSelection == 1){
				System.out.println("Which team do you want to search?");
				teamName = input.nextLine();
				try {
					analyze.analyzeTeamBatter(teamName);
					analyze.analyzeTeamPitcher(teamName);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("해당팀이 없습니다.");
				}
			}
			else if(userSelection == 2){
				System.out.println("어떤 팀의 선수를 검색하시겠습니까?");
				teamName = input.nextLine();
				System.out.println("어떤 선수를 검색하시겠습니까?");
				player = input.nextLine();
				analyze.anaylizePlayer(teamName, player);
			}
			else if(userSelection == 3){
				System.out.println("1. 타자 vs 투수\n2. 투수 vs 타자");
				int selection = input.nextInt();
				input.nextLine();
				if(selection == 1){
					System.out.println("어떤 팀의 선수를 검색하시겠습니까?");
					teamName = input.nextLine();
					System.out.println("어떤 선수를 검색하시겠습니까?");
					player = input.nextLine();
					analyze.analyzeOpponentPitcher(teamName, player);
				}
				else if(selection == 2){
					System.out.println("어떤 팀의 선수를 검색하시겠습니까?");
					teamName = input.nextLine();
					System.out.println("어떤 선수를 검색하시겠습니까?");
					player = input.nextLine();
					analyze.analyzeOpponentBatter(teamName, player);
				}
				else{
					System.out.println("잘못된 선택입니다. 다시 검색해주세요.");
				}
			}
			else if(userSelection == 4){
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			else{
				System.out.println("잘못된 선택입니다. 다시 검색해주세요.");
			}
		}
		
	}		
	
}
