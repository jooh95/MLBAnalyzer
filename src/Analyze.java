import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Analyze {
	private File file;
	private Scanner read;
	private String[] token;
	private Team team;
	private int i;
	
	Analyze(){
		token = new String[50];
		team = new Team();
		i = 0;
	}
	public void analyzeTeamBatter(String teamName){
		String fileAddress = new String("./baseball3");    //이거 바꿔주셔야 합니다.
		fileAddress = fileAddress + '/' + teamName + "/TeamBatter.txt"; 
		String playerInfo = new String();
		//System.out.println(fileAddress);
		file = new File(fileAddress);
		try {
			read = new Scanner(file);
			do{
				playerInfo = read.nextLine();
				seperator(playerInfo);
				team.hitter[i].rank = Integer.parseInt(token[0]);
				team.hitter[i].position = token[1].toString();
				team.hitter[i].name = token[2];
				team.hitter[i].age = Integer.parseInt(token[3]);
				team.hitter[i].games = Integer.parseInt(token[4]);
				team.hitter[i].totalBattimg = Integer.parseInt(token[5]);
				team.hitter[i].atBats = Integer.parseInt(token[6]);
				team.hitter[i].score = Integer.parseInt(token[7]);
				team.hitter[i].hit = Integer.parseInt(token[8]);
				team.hitter[i].doubleBase = Integer.parseInt(token[9]);
				team.hitter[i].tripleBase = Integer.parseInt(token[10]);
				team.hitter[i].homeRun = Integer.parseInt(token[11]);
				team.hitter[i].run = Integer.parseInt(token[12]);
				team.hitter[i].stealBase  = Integer.parseInt(token[13]);
				team.hitter[i].failSteal = Integer.parseInt(token[14]);
				team.hitter[i].walk = Integer.parseInt(token[15]);
				team.hitter[i].strike = Integer.parseInt(token[16]);
				team.hitter[i].hitRate = Float.parseFloat(token[17]);
				team.hitter[i].onBase = Float.parseFloat(token[18]);
				team.hitter[i].longHit = Float.parseFloat(token[19]);
				team.hitter[i].onBase_longHit = Float.parseFloat(token[20]);
				team.hitter[i].OPS_Plus = Float.parseFloat(token[21]);
				team.hitter[i].totalBase = Integer.parseInt(token[22]);
				team.hitter[i].doublePlay = Integer.parseInt(token[23]);
				team.hitter[i].deadBall = Integer.parseInt(token[24]);
				team.hitter[i].sacrifiedHit = Integer.parseInt(token[25]);
				team.hitter[i].sacrifiedFly = Integer.parseInt(token[26]);
				team.hitter[i].fourBall = Integer.parseInt(token[27]);
				i++;
				//System.out.println(addedString);
			}while(read.hasNext());
			for(int j = 0; j < i; j++){
				team.teamHitterAverage.age += team.hitter[j].age;
				team.teamHitterAverage.games += team.hitter[j].games;
				team.teamHitterAverage.totalBattimg += team.hitter[j].totalBattimg;
				team.teamHitterAverage.atBats += team.hitter[j].atBats;
				team.teamHitterAverage.score += team.hitter[j].score;
				team.teamHitterAverage.hit += team.hitter[j].hit;
				team.teamHitterAverage.doubleBase += team.hitter[j].doubleBase;
				team.teamHitterAverage.tripleBase += team.hitter[j].tripleBase;
				team.teamHitterAverage.homeRun += team.hitter[j].homeRun;
				team.teamHitterAverage.run += team.hitter[j].run;
				team.teamHitterAverage.stealBase += team.hitter[j].stealBase;
				team.teamHitterAverage.failSteal += team.hitter[j].failSteal;
				team.teamHitterAverage.walk += team.hitter[j].walk;
				team.teamHitterAverage.strike += team.hitter[j].strike;
				team.teamHitterAverage.hitRate += team.hitter[j].hitRate;
				team.teamHitterAverage.onBase += team.hitter[j].onBase;
				team.teamHitterAverage.longHit += team.hitter[j].longHit;
				team.teamHitterAverage.onBase_longHit += team.hitter[j].onBase_longHit;
				team.teamHitterAverage.OPS_Plus += team.hitter[j].OPS_Plus;
				team.teamHitterAverage.totalBase += team.hitter[j].totalBase;
				team.teamHitterAverage.doublePlay += team.hitter[j].doublePlay;
				team.teamHitterAverage.deadBall += team.hitter[j].deadBall;
				team.teamHitterAverage.sacrifiedHit += team.hitter[j].sacrifiedHit;
				team.teamHitterAverage.sacrifiedFly += team.hitter[j].sacrifiedFly;
				team.teamHitterAverage.fourBall += team.hitter[j].fourBall;
			}
			printTeamResult();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
		
		
	}
	private void seperator(String playerInfo){
		token = playerInfo.split("\t");
	}
	
	private void printTeamResult(){
		System.out.println("----------Result of Team Analysis----------");
		System.out.println("===============팀 타자 분석 결과===============");
		System.out.println("팀 타자 평균 나이 : " + (float) team.teamHitterAverage.age / i);
		System.out.println("팀 총 게임수 : " + team.teamHitterAverage.games);
		System.out.println("팀 총 총타석수 : " + team.teamHitterAverage.totalBase);
		System.out.println("팀 평균 총타수 : " + (float) team.teamHitterAverage.atBats / i);
		System.out.println("팀 평균 득점 : " + (float) team.teamHitterAverage.score / i);
		System.out.println("팀 평균 안타수 : " + (float) team.teamHitterAverage.hit / i);
		System.out.println("팀 평균 2루타 : " + (float) team.teamHitterAverage.doubleBase / i);
		System.out.println("팀 평균 3루타 : " + (float) team.teamHitterAverage.tripleBase / i);
		System.out.println("팀 평균 홈런 : " + (float) team.teamHitterAverage.homeRun / i);
		System.out.println("팀 평균 타점 : " + (float) team.teamHitterAverage.run / i);
		System.out.println("팀 평균 도루 : " + (float) team.teamHitterAverage.stealBase / i);
		System.out.println("팀 평균 도루실패 : " + (float) team.teamHitterAverage.failSteal / i);
		System.out.println("팀 평균 볼넷 : " + (float) team.teamHitterAverage.walk / i);
		System.out.println("팀 평균 삼진 : " + (float) team.teamHitterAverage.strike /i);
		System.out.println("팀 평균 타율 : " + (float) team.teamHitterAverage.hitRate / i);
		System.out.println("팀 평균 출루율 : " + (float) team.teamHitterAverage.onBase / i);
		System.out.println("팀 평균 장타율 : " + (float) team.teamHitterAverage.longHit / i);
		System.out.println("팀 평균 출루율+장타율 : " + (float) team.teamHitterAverage.onBase_longHit / i);
		System.out.println("팀 평균 총루타 : " + (float) team.teamHitterAverage.totalBase / i);
		System.out.println("팀 평균 병살타 : " + (float) team.teamHitterAverage.doublePlay / i);
		System.out.println("팀 평균 데드볼 : " + (float) team.teamHitterAverage.deadBall / i);
		System.out.println("팀 평균 희생타 : " + (float) team.teamHitterAverage.sacrifiedHit / i);
		System.out.println("팀 평균 희생플라이 : " + (float) team.teamHitterAverage.sacrifiedFly / i);
		System.out.println("팀 평균 고의4구당함 : " + (float) team.teamHitterAverage.fourBall / i);
	}
	
	public void analyzeTeamPitcher(String teamName) throws FileNotFoundException{
		i = 0;
		String fileAddress = new String("./baseball3");    //이것 또 바꿔주셔야 합니다.
		fileAddress = fileAddress + '/' + teamName + "/TeamPitcher.txt"; 
		String playerInfo = new String();
		//System.out.println(fileAddress);
		file = new File(fileAddress);
		read = new Scanner(file);
		//System.out.println(read.nextLine());
		do{
			playerInfo = read.nextLine();
			seperator(playerInfo);
			team.pitcher[i].rank = Integer.parseInt(token[0]);
			team.pitcher[i].position = token[1].toString();
			team.pitcher[i].name = token[2];
			team.pitcher[i].age = Integer.parseInt(token[3]);
			team.pitcher[i].win = Integer.parseInt(token[4]);
			team.pitcher[i].ERA = Integer.parseInt(token[5]);
			team.pitcher[i].winRate = Float.parseFloat(token[6]);
			team.pitcher[i].averageLosingScore = Float.parseFloat(token[7]);
			team.pitcher[i].games = Integer.parseInt(token[8]);
			team.pitcher[i].startingPitcher = Integer.parseInt(token[9]);
			team.pitcher[i].closer = Integer.parseInt(token[10]);
			team.pitcher[i].completeGame = Integer.parseInt(token[11]);
			team.pitcher[i].completeBlockade = Integer.parseInt(token[12]);
			team.pitcher[i].save  = Integer.parseInt(token[13]);
			team.pitcher[i].inningPitch = Float.parseFloat(token[14]);
			team.pitcher[i].hitted = Integer.parseInt(token[15]);
			team.pitcher[i].losingPoint = Integer.parseInt(token[16]);
			team.pitcher[i].ER = Integer.parseInt(token[17]);
			team.pitcher[i].homeRun = Integer.parseInt(token[18]);
			team.pitcher[i].fourBall = Integer.parseInt(token[19]);
			team.pitcher[i].intentionalWalk = Integer.parseInt(token[20]);
			team.pitcher[i].strike = Integer.parseInt(token[21]);
			team.pitcher[i].deadBall = Integer.parseInt(token[22]);
			team.pitcher[i].voke = Integer.parseInt(token[23]);
			team.pitcher[i].wildPitch = Integer.parseInt(token[24]);
			team.pitcher[i].hitters = Integer.parseInt(token[25]);
			team.pitcher[i].EraPlus = Integer.parseInt(token[26]);
			team.pitcher[i].averagePitcherLosingPoint = Float.parseFloat(token[27]);
			team.pitcher[i].inningOnBase = Float.parseFloat(token[28]);
			team.pitcher[i].hittedForNineInnings = Float.parseFloat(token[29]);
			team.pitcher[i].homeRunForNineInnings = Float.parseFloat(token[30]);
			team.pitcher[i].fourBallForNineInnings = Float.parseFloat(token[31]);
			team.pitcher[i].strikeForNineInnings = Float.parseFloat(token[32]);
			team.pitcher[i].SW = Float.parseFloat(token[33]);
			i++;
			//System.out.println(addedString);
		}while(read.hasNext());
		
		for(int j = 0; j < i; j++){
			team.teamPitcherAverage.age += team.pitcher[j].age;
			team.teamPitcherAverage.win += team.pitcher[j].win;
			team.teamPitcherAverage.ERA += team.pitcher[j].ERA;
			team.teamPitcherAverage.winRate += team.pitcher[j].winRate;
			team.teamPitcherAverage.averageLosingScore += team.pitcher[j].averageLosingScore;
			team.teamPitcherAverage.games += team.pitcher[j].games;
			team.teamPitcherAverage.startingPitcher += team.pitcher[j].startingPitcher;
			team.teamPitcherAverage.closer += team.pitcher[j].closer;
			team.teamPitcherAverage.completeGame += team.pitcher[j].completeGame;
			team.teamPitcherAverage.completeBlockade += team.pitcher[j].completeBlockade;
			team.teamPitcherAverage.save += team.pitcher[j].save;
			team.teamPitcherAverage.inningPitch += team.pitcher[j].inningPitch;
			team.teamPitcherAverage.hitted += team.pitcher[j].hitted;
			team.teamPitcherAverage.losingPoint += team.pitcher[j].losingPoint;
			team.teamPitcherAverage.ER += team.pitcher[j].ER;
			team.teamPitcherAverage.homeRun += team.pitcher[j].homeRun;
			team.teamPitcherAverage.fourBall += team.pitcher[j].fourBall;
			team.teamPitcherAverage.intentionalWalk += team.pitcher[j].intentionalWalk;
			team.teamPitcherAverage.strike += team.pitcher[j].strike;
			team.teamPitcherAverage.deadBall += team.pitcher[j].deadBall;
			team.teamPitcherAverage.voke += team.pitcher[j].voke;
			team.teamPitcherAverage.wildPitch += team.pitcher[j].wildPitch;
			team.teamPitcherAverage.hitters += team.pitcher[j].hitters;
			team.teamPitcherAverage.EraPlus += team.pitcher[j].EraPlus;
			team.teamPitcherAverage.averagePitcherLosingPoint += team.pitcher[j].averagePitcherLosingPoint;
			team.teamPitcherAverage.inningOnBase += team.pitcher[j].inningOnBase;
			team.teamPitcherAverage.hittedForNineInnings += team.pitcher[j].hittedForNineInnings;
			team.teamPitcherAverage.homeRunForNineInnings += team.pitcher[j].homeRunForNineInnings;
			team.teamPitcherAverage.fourBallForNineInnings += team.pitcher[j].fourBallForNineInnings;
			team.teamPitcherAverage.strikeForNineInnings += team.pitcher[j].strikeForNineInnings;
			team.teamPitcherAverage.SW += team.pitcher[j].SW;
		}
		
		printPitcherResult();
	}
	
	private void printPitcherResult(){
		System.out.println("===============팀 투수 분석 결과===============");
		System.out.println("팀 투수 평균 나이 : " + (float) team.teamPitcherAverage.age / i);
		System.out.println("팀 평균 승리 : " + (float) team.teamPitcherAverage.win / i);
		System.out.println("팀 평균 패배 : " + (float) team.teamPitcherAverage.ERA / i);
		System.out.println("팀 평균 승리투수율 : " + team.teamPitcherAverage.winRate /i );
		System.out.println("팀 평균 자책점 : " + team.teamPitcherAverage.averageLosingScore / i);
		System.out.println("팀 총 게임수 : " + team.teamPitcherAverage.games);
		System.out.println("팀 완투 횟수 : " + team.teamPitcherAverage.completeGame);
		System.out.println("팀 완봉 횟수 : " +	team.teamPitcherAverage.completeBlockade);
		System.out.println("팀 평균 세이브 : " + (float) team.teamPitcherAverage.save / i);
		System.out.println("팀 평균 이닝 투구수 : " + team.teamPitcherAverage.inningPitch / i);
		System.out.println("팀 평균 허용안타: " + (float) team.teamPitcherAverage.hitted / i);
		System.out.println("팀 평균 실점 : " +	(float) team.teamPitcherAverage.losingPoint / i);
		System.out.println("팀 평균 자책점 : " + (float) team.teamPitcherAverage.ER / i);
		System.out.println("팀 평균 허용홈런 : " + (float) team.teamPitcherAverage.homeRun / i);
		System.out.println("팀 평균 허용볼넷 : " +	(float) team.teamPitcherAverage.fourBall / i);
		System.out.println("팀 평균 고의4구수 :" +	(float) team.teamPitcherAverage.intentionalWalk);
		System.out.println("팀 평균 삼진 : " + (float) team.teamPitcherAverage.strike / i);
		System.out.println("팀 평균 데드볼 : " + (float) team.teamPitcherAverage.deadBall / i);
		System.out.println("팀 평균 보크수 : " + (float) team.teamPitcherAverage.voke);
		System.out.println("팀 평균 폭투 : " + (float) team.teamPitcherAverage.wildPitch / i);
		System.out.println("팀 상대 타자 수 : " + team.teamPitcherAverage.hitters);
		System.out.println("팀 평균 순수투수 자책점 : " + (float) team.teamPitcherAverage.averagePitcherLosingPoint / i);
		System.out.println("이닝당 출루수 : " +	team.teamPitcherAverage.inningOnBase / i);
		System.out.println("9이닝당 피안타" +	team.teamPitcherAverage.hittedForNineInnings / i);
		System.out.println("9이닝당 홈런" +	team.teamPitcherAverage.homeRunForNineInnings / i);
		System.out.println("9이닝당 볼넷" +	team.teamPitcherAverage.fourBallForNineInnings / i);
		System.out.println("9이닝당 탈삼진" +	team.teamPitcherAverage.strikeForNineInnings / i);
		
	}
	
	public void anaylizePlayer(String teamName, String player){
		System.out.println("----------" + player + "의 분석 결과----------");
		String fileAddress = new String("./baseball3");    //이거 바꿔주셔야 합니다.
		fileAddress = fileAddress + '/' + teamName + "/TeamBatter.txt"; 
		String playerInfo = new String();
		File openFile;
		Scanner scanPitcher;
		int howManyHitter = 0;
		int howManyPitcher = 0;
		//System.out.println(fileAddress);
		file = new File(fileAddress);
		try {
			read = new Scanner(file);
			do{
				playerInfo = read.nextLine();
				seperator(playerInfo);
				team.hitter[i].rank = Integer.parseInt(token[0]);
				team.hitter[i].position = token[1].toString();
				team.hitter[i].name = token[2];
				team.hitter[i].age = Integer.parseInt(token[3]);
				team.hitter[i].games = Integer.parseInt(token[4]);
				team.hitter[i].totalBattimg = Integer.parseInt(token[5]);
				team.hitter[i].atBats = Integer.parseInt(token[6]);
				team.hitter[i].score = Integer.parseInt(token[7]);
				team.hitter[i].hit = Integer.parseInt(token[8]);
				team.hitter[i].doubleBase = Integer.parseInt(token[9]);
				team.hitter[i].tripleBase = Integer.parseInt(token[10]);
				team.hitter[i].homeRun = Integer.parseInt(token[11]);
				team.hitter[i].run = Integer.parseInt(token[12]);
				team.hitter[i].stealBase  = Integer.parseInt(token[13]);
				team.hitter[i].failSteal = Integer.parseInt(token[14]);
				team.hitter[i].walk = Integer.parseInt(token[15]);
				team.hitter[i].strike = Integer.parseInt(token[16]);
				team.hitter[i].hitRate = Float.parseFloat(token[17]);
				team.hitter[i].onBase = Float.parseFloat(token[18]);
				team.hitter[i].longHit = Float.parseFloat(token[19]);
				team.hitter[i].onBase_longHit = Float.parseFloat(token[20]);
				team.hitter[i].OPS_Plus = Float.parseFloat(token[21]);
				team.hitter[i].totalBase = Integer.parseInt(token[22]);
				team.hitter[i].doublePlay = Integer.parseInt(token[23]);
				team.hitter[i].deadBall = Integer.parseInt(token[24]);
				team.hitter[i].sacrifiedHit = Integer.parseInt(token[25]);
				team.hitter[i].sacrifiedFly = Integer.parseInt(token[26]);
				team.hitter[i].fourBall = Integer.parseInt(token[27]);
				i++;
				//System.out.println(addedString);
			}while(read.hasNext());
			howManyHitter = i;
			
			i = 0;
			fileAddress = "./baseball3";
			fileAddress = fileAddress + '/' + teamName + "/TeamPitcher.txt"; 
			//System.out.println(fileAddress);
			openFile = new File(fileAddress);
			scanPitcher = new Scanner(openFile);
			//System.out.println(read.nextLine());
			do{
				playerInfo = scanPitcher.nextLine();
				seperator(playerInfo);
				team.pitcher[i].rank = Integer.parseInt(token[0]);
				team.pitcher[i].position = token[1].toString();
				team.pitcher[i].name = token[2];
				team.pitcher[i].age = Integer.parseInt(token[3]);
				team.pitcher[i].win = Integer.parseInt(token[4]);
				team.pitcher[i].ERA = Integer.parseInt(token[5]);
				team.pitcher[i].winRate = Float.parseFloat(token[6]);
				team.pitcher[i].averageLosingScore = Float.parseFloat(token[7]);
				team.pitcher[i].games = Integer.parseInt(token[8]);
				team.pitcher[i].startingPitcher = Integer.parseInt(token[9]);
				team.pitcher[i].closer = Integer.parseInt(token[10]);
				team.pitcher[i].completeGame = Integer.parseInt(token[11]);
				team.pitcher[i].completeBlockade = Integer.parseInt(token[12]);
				team.pitcher[i].save  = Integer.parseInt(token[13]);
				team.pitcher[i].inningPitch = Float.parseFloat(token[14]);
				team.pitcher[i].hitted = Integer.parseInt(token[15]);
				team.pitcher[i].losingPoint = Integer.parseInt(token[16]);
				team.pitcher[i].ER = Integer.parseInt(token[17]);
				team.pitcher[i].homeRun = Integer.parseInt(token[18]);
				team.pitcher[i].fourBall = Integer.parseInt(token[19]);
				team.pitcher[i].intentionalWalk = Integer.parseInt(token[20]);
				team.pitcher[i].strike = Integer.parseInt(token[21]);
				team.pitcher[i].deadBall = Integer.parseInt(token[22]);
				team.pitcher[i].voke = Integer.parseInt(token[23]);
				team.pitcher[i].wildPitch = Integer.parseInt(token[24]);
				team.pitcher[i].hitters = Integer.parseInt(token[25]);
				team.pitcher[i].EraPlus = Integer.parseInt(token[26]);
				team.pitcher[i].averagePitcherLosingPoint = Float.parseFloat(token[27]);
				team.pitcher[i].inningOnBase = Float.parseFloat(token[28]);
				team.pitcher[i].hittedForNineInnings = Float.parseFloat(token[29]);
				team.pitcher[i].homeRunForNineInnings = Float.parseFloat(token[30]);
				team.pitcher[i].fourBallForNineInnings = Float.parseFloat(token[31]);
				team.pitcher[i].strikeForNineInnings = Float.parseFloat(token[32]);
				team.pitcher[i].SW = Float.parseFloat(token[33]);
				i++;
				//System.out.println(addedString);
			}while(scanPitcher.hasNext());
			howManyPitcher = i;
			
			int hitterCount = 0;
			int pitcherCount = 0;
			for(int j = 0; j < howManyHitter; j++){
				if(team.hitter[j].name.equals(player)){
					if(team.hitter[j].onBase_longHit >= 1.0){
						System.out.println(player + "는 리그대표 타자입니다!");
					}
					else if(team.hitter[j].onBase_longHit >= 0.8 && team.hitter[j].onBase_longHit < 1.0){
						System.out.println(player + "는 팀 에이스 타자입니다!");
						hitterCount++;
					}
					else if(team.hitter[j].onBase_longHit >= 0.7){
						System.out.println(player + "는 훌륭한 타자입니다!");
						hitterCount++;
					}
					
					if(team.hitter[j].age <= 25 && team.hitter[j].onBase_longHit >= 0.7){
						System.out.println(player + "는 유망한 타자입니다!");
						hitterCount++;
					}
					
					if(team.hitter[j].age <= 20){
						System.out.println(player + "는 유망주입니다!");
						hitterCount++;
					}
					
					if(team.hitter[j].homeRun >= 20){
						System.out.println(player + "는 홈런을 잘칩니다!");
						hitterCount++;
					}
					
					if(team.hitter[j].stealBase >= 20){
						System.out.println(player + "는 두루에 뛰어납니다!");
						hitterCount++;
					}
					
					if(team.hitter[j].hitRate >= 0.3){
						System.out.println(player + "는 타율이 좋은 타자입니다!");
						hitterCount++;
					}
					
					if(hitterCount == 0 && !team.hitter[j].position.equals("P")){
						System.out.println(player + "는 평범한 타자입니다. 훈련이 더 필요합니다!");
					}
					
					break;
				}
			}
			for(int j = 0; j < howManyPitcher; j++){
				if(team.pitcher[j].name.equals(player)){
					if(team.pitcher[j].ERA <= 2.5){
						System.out.println(player + "는 리그대표 투수입니다!");
						pitcherCount++;
					}
					else if(team.pitcher[j].ERA > 2.5 && team.pitcher[j].ERA <= 3.0){
						System.out.println(player + "는 팀 에이스 투수입니다!");
						pitcherCount++;
					}
					else if(team.pitcher[j].ERA > 3.0 && team.pitcher[j].ERA <= 4.0){
						System.out.println(player + "는 준수한 투수입니다!");
						pitcherCount++;
					}
					
					if(team.pitcher[j].games >= 20){
						System.out.println(player + "는 경험많은 투수입니다!");
						pitcherCount++;
					}
					
					if(team.pitcher[j].age <= 25 && team.pitcher[j].losingPoint <= 3.7){
						System.out.println(player + "는 유망한 투수입니다!");
						pitcherCount++;
						
					}
					
					if(team.pitcher[j].age <= 20){
						System.out.println(player + "는 유망주입니다!");
						pitcherCount++;
						
					}
					
					if(team.pitcher[j].win >= 10){
						System.out.println(player + "는 선발투수로 적절합니다!");
						pitcherCount++;
					}
					
					if(team.pitcher[j].save >= 10){
						System.out.println(player + "는 마무리 능력이 뛰어납니다!");
						pitcherCount++;
					}
					
					if(team.pitcher[j].strikeForNineInnings >= 10){
						System.out.println(player + "는 삼진 능력이 뛰어납니다!");
						pitcherCount++;
					}
					
					if(team.pitcher[j].hittedForNineInnings <= 10){
						System.out.println(player + "는 구질이 좋습니다!");
						pitcherCount++;
					}
					
					if(pitcherCount == 0){
						System.out.println(player + "는 평범한 투수입니다. 훈련이 더욱 필요합니다!");
					}
					
					break;
				}
			}
			
			if(hitterCount == 0 && pitcherCount == 0){
				System.out.println("해당 선수가 없습니다.");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("해당팀이 없습니다");
		}
		
		
		
	}
	
	
	public void analyzeOpponentPitcher(String teamName, String player){
		i = 0;
		System.out.println("----------" + player + " V.S. " + "투수 분석 결과----------");
		String fileAddress = new String("./baseball3");    //이거 바꿔주셔야 합니다.
		fileAddress = fileAddress + '/' + teamName + "/TeamBatter_Vs_Pitcher/" + player +".txt"; 
		String playerInfo = new String();
		file = new File(fileAddress);
		try {
			read = new Scanner(file);
			do{
				playerInfo = read.nextLine();
				seperator(playerInfo);
				team.opponentRecord[i].name = token[0];
				//System.out.println(token[0]);
				team.opponentRecord[i].PA = Integer.parseInt(token[1]);
				team.opponentRecord[i].AB = Integer.parseInt(token[2]);
				team.opponentRecord[i].hits = Integer.parseInt(token[3]);
				team.opponentRecord[i].doubleBase = Integer.parseInt(token[4]);
				team.opponentRecord[i].trippleBase = Integer.parseInt(token[5]);
				team.opponentRecord[i].homeRun = Integer.parseInt(token[6]);
				team.opponentRecord[i].score = Integer.parseInt(token[7]);
				team.opponentRecord[i].walk = Integer.parseInt(token[8]);
				team.opponentRecord[i].strike = Integer.parseInt(token[9]);
				team.opponentRecord[i].hitRate = Float.parseFloat(token[10]);
				team.opponentRecord[i].onBaseRate = Float.parseFloat(token[11]);
				team.opponentRecord[i].longHit = Float.parseFloat(token[12]);
				team.opponentRecord[i].onBaseRate_longHit = Float.parseFloat(token[13]);
				team.opponentRecord[i].sacrifiedHit = Integer.parseInt(token[14]);
				team.opponentRecord[i].sacrifiedFly = Integer.parseInt(token[15]);
				team.opponentRecord[i].intentionalFoutBall = Integer.parseInt(token[16]);
				team.opponentRecord[i].deadBall = Integer.parseInt(token[17]);
				team.opponentRecord[i].doublePlay = Integer.parseInt(token[18]);
				//team.opponentRecord[i].missG = Integer.parseInt(token[19]);
				i++;
			}while(read.hasNext());
			
			float maxOnBaseRate = team.opponentRecord[0].onBaseRate;
			for(int y = 1; y < i; y++){
				if(maxOnBaseRate < team.opponentRecord[y].onBaseRate){
					maxOnBaseRate = team.opponentRecord[y].onBaseRate;
				}
			}
			
			for(int j = 0; j < i; j++){
				if(team.opponentRecord[j].onBaseRate == maxOnBaseRate){
					System.out.println(player + "는 " + team.opponentRecord[j].name + "에 강합니다.");
					break;
				}
			}
			
			float minOnBaseRate = team.opponentRecord[0].onBaseRate;
			for(int y = 1; y < i; y++){
				if(minOnBaseRate > team.opponentRecord[y].onBaseRate){
					minOnBaseRate = team.opponentRecord[y].onBaseRate;
				}
			}
			
			for(int j = 0; j < i; j++){
				if(team.opponentRecord[j].onBaseRate == minOnBaseRate){
					System.out.println(player + "는 " + team.opponentRecord[j].name + "에 약합니다.");
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("해당선수가 없습니다.");
		}
	}
	
	public void analyzeOpponentBatter(String teamName, String player){
		i = 0;
		System.out.println("----------" + player + " V.S. " + "타자 분석 결과----------");
		String fileAddress = new String("./baseball3");    //이거 바꿔주셔야 합니다.
		fileAddress = fileAddress + '/' + teamName + "/TeamPitcher_Vs_Batter/" + player +".txt"; 
		String playerInfo = new String();
		file = new File(fileAddress);
		try {
			read = new Scanner(file);
			do{
				playerInfo = read.nextLine();
				seperator(playerInfo);
				team.opponentRecord[i].name = token[0];
				//System.out.println(token[0]);
				team.opponentRecord[i].PA = Integer.parseInt(token[1]);
				team.opponentRecord[i].AB = Integer.parseInt(token[2]);
				team.opponentRecord[i].hits = Integer.parseInt(token[3]);
				team.opponentRecord[i].doubleBase = Integer.parseInt(token[4]);
				team.opponentRecord[i].trippleBase = Integer.parseInt(token[5]);
				team.opponentRecord[i].homeRun = Integer.parseInt(token[6]);
				team.opponentRecord[i].score = Integer.parseInt(token[7]);
				team.opponentRecord[i].walk = Integer.parseInt(token[8]);
				team.opponentRecord[i].strike = Integer.parseInt(token[9]);
				team.opponentRecord[i].hitRate = Float.parseFloat(token[10]);
				team.opponentRecord[i].onBaseRate = Float.parseFloat(token[11]);
				team.opponentRecord[i].longHit = Float.parseFloat(token[12]);
				team.opponentRecord[i].onBaseRate_longHit = Float.parseFloat(token[13]);
				team.opponentRecord[i].sacrifiedHit = Integer.parseInt(token[14]);
				team.opponentRecord[i].sacrifiedFly = Integer.parseInt(token[15]);
				team.opponentRecord[i].intentionalFoutBall = Integer.parseInt(token[16]);
				team.opponentRecord[i].deadBall = Integer.parseInt(token[17]);
				team.opponentRecord[i].doublePlay = Integer.parseInt(token[18]);
				//team.opponentRecord[i].missG = Integer.parseInt(token[19]);
				i++;
			}while(read.hasNext());
			
			float maxOnBaseRate = team.opponentRecord[0].onBaseRate;
			for(int y = 1; y < i; y++){
				if(maxOnBaseRate < team.opponentRecord[y].onBaseRate){
					maxOnBaseRate = team.opponentRecord[y].onBaseRate;
				}
			}
			
			for(int j = 0; j < i; j++){
				if(team.opponentRecord[j].onBaseRate == maxOnBaseRate){
					System.out.println(player + "는 " + team.opponentRecord[j].name + "에 강합니다.");
					break;
				}
			}
			
			float minOnBaseRate = team.opponentRecord[0].onBaseRate;
			for(int y = 1; y < i; y++){
				if(minOnBaseRate > team.opponentRecord[y].onBaseRate){
					minOnBaseRate = team.opponentRecord[y].onBaseRate;
				}
			}
			
			for(int j = 0; j < i; j++){
				if(team.opponentRecord[j].onBaseRate == minOnBaseRate){
					System.out.println(player + "는 " + team.opponentRecord[j].name + "에 약합니다.");
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("해당선수가 없습니다.");
		}
	}
	
}