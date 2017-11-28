
public class Team {
	
	//1	C	Yan_Gomes	28	38	152	143	14	25	6	1	6	25	0	0	6	41	0.175	0.211	0.357	0.567	48	51
	//나이(age) / 게임수(G) / 총타석수(PA) / 총타수(AB) / 득점(R) /안타수(H) / 2루타(2B) / 3루타(3B) / 홈런(HR) / 타점(RBI) /
	//도루(SB) / 도루실패(CS) / 볼넷(BB) / 삼진(SO) / 타율(BA) /
	//출루율 (OBP) / 장타율(SLG)/ 출루율+장타율 (OPS) / ??? (OPS+) / 총루타 (TB) /
	//병살타 (GDP) / 데드볼(hbp) / 희생타(SH) / 희생플라이(SF) / 고의4구당함 (IBB)
	public Hitter[] hitter;
	public Pitcher[] pitcher;
	public Hitter teamHitterAverage;
	public Pitcher teamPitcherAverage;
	public OpponentRecord[] opponentRecord;
	
	Team(){
		hitter = new Hitter[300];
		for(int i = 0; i < 300; i++){
			hitter[i] = new Hitter();
		}
		pitcher = new Pitcher[300];
		for(int i = 0; i < 300; i++){
			pitcher[i] = new Pitcher();
		}
		teamHitterAverage = new Hitter();
		teamPitcherAverage = new Pitcher();
		opponentRecord = new OpponentRecord[300];
		for(int i = 0; i < 300; i++){
			opponentRecord[i] = new OpponentRecord();
		}
	}
}
