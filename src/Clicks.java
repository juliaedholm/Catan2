import java.awt.event.*;
import java.awt.Graphics;


public class Clicks implements MouseListener{
	private Hexanew hex;
	private FrontEndInterface interaction;
	private ResourceTranslator translator = new ResourceTranslator();

	public Clicks(Hexanew h, FrontEndInterface f){
		hex = h;
		interaction = f;
	}

	public void mouseClicked(MouseEvent e){

		int x = e.getX();
		int y = e.getY();
		System.out.println(x);
		System.out.println(y);
		//identifying the Vertex and Hexagon
		int verty= searchVert(x,y);
		int hexy= searchHex(x,y);
		boolean roll=rolledDice(x, y);

		boolean trade = triedTrade(x,y);
		boolean city = askCity(x,y);
		boolean setty = askSetty(x,y);
		boolean road = askRoad(x,y);
		boolean dev = askDev(x,y);
		boolean sheep = sheep(x,y);
		boolean wood = wood(x,y); 
		boolean stone = stone(x,y);
		boolean brick = brick(x,y);
		boolean wheat = wheat(x,y);
		boolean player1=player1(x,y);
		boolean player2=player2(x,y);
		boolean player3=player3(x,y);
		boolean player4=player4(x,y);
		boolean knights=knights(x,y);
		boolean yearOfPlenty=yearOfPlenty(x,y);
		boolean monopoly=monopoly(x,y);
		boolean roadBuilder=roadBuilder(x,y);
		boolean port0=port0(x,y);
		boolean port1=port1(x,y);
		boolean port2=port2(x,y);
		boolean port3=port3(x,y);
		boolean port4=port4(x,y);
		boolean port5=port5(x,y);
		boolean port6=port6(x,y);
		boolean port7=port7(x,y);
		boolean port8=port8(x,y);
//		boolean clickToClear = clickToClear(x,y);

		if(roll){
			int [] rolls= interaction.diceClicked();
			hex.rollOne=rolls[0];//random from Julia
			hex.rollTwo=rolls[1];
			hex.repaint();
		}
		else if(trade){
			interaction.tradeClicked();
		}
		else if(city){
			interaction.cityClicked();
		}
		else if(setty){
			interaction.settyClicked();
		}
		else if(road){
			interaction.roadClicked();
		}
		else if(dev){
			interaction.devCardClicked();
		}
		else if(sheep){
			interaction.resourceClicked(translator.Sheep);
		}
		else if(wood){
			interaction.resourceClicked(translator.Wood);
		}
		else if(stone){
			interaction.resourceClicked(translator.Rock);
		}
		else if(brick){
			interaction.resourceClicked(translator.Brick);
		}
		else if(wheat){
			interaction.resourceClicked(translator.Wheat);
		}
		else if(player1){
			System.out.println("player1");
			interaction.playerClicked(1);
		}
		else if(player2){
						System.out.println("player2");
			interaction.playerClicked(2);
		}
		else if(player3){
					System.out.println("player3");
			interaction.playerClicked(3);
		}
		else if(player4){
						System.out.println("player4");
			interaction.playerClicked(4);
		}
		else if(knights){
			System.out.println("knights");
			interaction.knightClicked();
		}
		else if(yearOfPlenty){
			System.out.println("yearOfPlenty");
			interaction.yearOfPlentyClicked();
		}
		else if(monopoly){
			System.out.println("monops");
			interaction.monopolyClicked();
		}
		else if(roadBuilder){
			System.out.println("roadBuilder");
			interaction.roadBuilderClicked();
		}
		else if(port0){
			System.out.println("port0");
			interaction.portClicked(0);
		}
		else if(port1){
			System.out.println("port1");
			interaction.portClicked(1);
		}
		else if(port2){
			System.out.println("port2");
			interaction.portClicked(2);
		}
		else if(port3){
			System.out.println("port3");
			interaction.portClicked(3);
		}
		else if(port4){
			System.out.println("port4");
			interaction.portClicked(4);
		}
		else if(port5){
			System.out.println("port5");
			interaction.portClicked(5);
		}
		else if(port6){
			System.out.println("port6");
			interaction.portClicked(6);
		}
		else if(port7){
			System.out.println("port7");
			interaction.portClicked(7);
		}
		else if(port8){
			System.out.println("port8");
			interaction.portClicked(8);
		}

		else if(verty<54){
			interaction.vertexClicked(verty);
		}
		else if(hexy<19){
			interaction.robberClicked();
			interaction.tileClicked(hexy);
		}		
		else /*(clickToClear)*/{
			System.out.println("clear");
			interaction.nullClick();
		}
	}


	public int searchVert(int x, int y){
		//15=clickable radius
		int xDifference=15;
		int yDifference=15;
		//The absolute value of the difference between the point you're at and the vertex
		int xPoint=0;
		int yPoint=0;
		//The vertex that will be closest, setting to impossible (54) so will not confuse about 0
		int vert=54;

		for (int i=0; i<54; i++){
			xPoint = abs(x-hex.vertex[i][0]);
			yPoint = abs(y-hex.vertex[i][1]);
			if (xDifference+yDifference>xPoint+yPoint){
				xDifference=xPoint;
				yDifference=yPoint;
				vert=i;
			}
      	}
      	return vert;
	}
	public int searchHex(int x, int y){
		//20=clickable radius
		int xDifference=20;
		int yDifference=20;
		//The absolute value of the difference between the point you're at and the vertex
		int xPoint=0;
		int yPoint=0;
		//The hexagon that will be closest, setting to impossible (19) so will not confuse about 0 
		int hexy=19;

		for (int i=0; i<19; i++){
			xPoint = abs(x-(hex.start[i][0]+hex.w));
			yPoint = abs(y-(hex.start[i][1]-hex.a));
			if (xDifference+yDifference>xPoint+yPoint){
				xDifference=xPoint;
				yDifference=yPoint;
				hexy=i;
			}
      	}
      	return hexy;
	}
	public boolean triedTrade(int x, int y){
		if(x<1370 && x>1285 && y<254 && y>177){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean rolledDice(int x, int y){
		if(x<175 && x>25 && y<810 && y>745){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean askCity(int x, int y){
		if(x<880 && x>960 && y<163 && y>122){
			return true;
		}
		else if(x<925&& x>880  && y<163 && y>79){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean askSetty(int x, int y){
		if(x<1040 && x>1000 && y<161 && y>100){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean askRoad(int x, int y){
		if(x<1162 && x>1080 && y<161 && y>148){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean askDev(int x, int y){
		if(x<1268 && x>1183 && y<161 && y>40){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean sheep(int x, int y){
		if(x<940 && x>887 && y<260 && y>183){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean wood(int x, int y){
		if(x<1021 && x>967 && y<259 && y>182){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean brick(int x, int y){
		if(x<1103 && x>1045 && y<257 && y>180){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean stone(int x, int y){
		if(x<1263 && x>1208 && y<259 && y>181){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean wheat(int x, int y){
		if(x<1182 && x>1126 && y<263 && y>181){
			return true;
		}
		else{
			return false;
		}
	}
	public int abs(int x){
		int newX=x;
		if (x<0){
			newX=(-1)*x;
		}
		return newX;
	}
	public boolean player1(int x, int y){
		if(x<995 && x>897 && y<303 && y>280){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean player2(int x, int y){
		if(x<995 && x>897 && y<453 && y>431){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean player3(int x, int y){
		if(x<995 && x>897 && y<603 && y>581){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean player4(int x, int y){
		if(x<995 && x>897 && y<753 && y>731){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean knights(int x, int y){
		if(x<1360 && x>1149 && ((y<341 && y>327) || (y>773 && y<789)|| (y>474 && y<490)|| (y>624 && y<641)) ){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean yearOfPlenty(int x, int y){
		if(x<1360 && x>1149 && ((y<385 && y>400) || (y>820 && y<835)|| (y>520 && y<535)|| (y>670 && y<685)) ){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean monopoly(int x, int y){
		if(x<1360 && x>1149 && ((y<370 && y>355) || (y>805 && y<820)|| (y>505 && y<520)|| (y>655 && y<670)) ){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean roadBuilder(int x, int y){
		if(x<1360 && x>1149 && ((y<355 && y>340) || (y>790 && y<805)|| (y>490 && y<505)|| (y>640 && y<655)) ){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port0(int x, int y){
		if(x<210 && x>182 && y<257 && y>236){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port1(int x, int y){
		if(x<424 && x>391 && y<132 && y>117){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port2(int x, int y){
		if(x<664 && x>639 && y<137 && y>116){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port3(int x, int y){
		if(x<770 && x>742 && y<340 && y>295){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port4(int x, int y){
		if(x<770 && x>742 && y<576 && y>545){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port5(int x, int y){
		if(x<664 && x>632 && y<769 && y>749){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port6(int x, int y){
		if(x<418 && x>389 && y<765 && y>740){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port7(int x, int y){
		if(x<210 && x>182 && y<646 && y>623){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean port8(int x, int y){
		if(x<107 && x>78 && y<455 && y>439){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean clickToClear(int x, int y){
		if(x<100 &&  y<100 ){
			return true;
		}
		else{
			return false;
		}
	}




	public void mousePressed(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
}