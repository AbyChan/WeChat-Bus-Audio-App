//package com.tyan.ba.game.textGame;
//
//import java.util.Scanner;
//
//public class Entironment {
//	static int size = Map.size;
//	static int[][] map = Map.build();
//	static int xSize = Map.x;
//
//	public static void display(Player player){
//		System.out.println("Current position: ME");
//		System.out.println("woods = w");
//		System.out.println("path = p");
//		for(int i=0;i<size;i++){
//			if(i/xSize == player.getXPos() && i%xSize == player.getYPos()){
//				System.out.print("ME  ");
//			}
//			
//			else{
//			if(i%xSize==(xSize-1)){
//				switch(map[xSize][i%xSize]%10){
//				case 9: System.out.println("----"); break;
//				case 2: System.out.println(" w  "); break;
//				case 1: System.out.println(" p  "); break;
//				default: System.out.println(map[xSize][i%xSize]+"\n"); break;
//				}
//			}
//			else{
//				switch(map[i/xSize][i%xSize]%10){
//				case 9: System.out.print("----"); break;
//				case 2: System.out.print(" w  "); break;
//				case 1: System.out.print(" p  "); break;
//				default:System.out.print(map[i/xSize][i%xSize] + " "); break;
//				}
//			}
//			}
//		}
//	}
//
//	public static void move(Player player){
//		boolean error = false;
//		while(true){
//			Scanner scanner = new Scanner(System.in);
//			System.out.print("Move:");
//			String direction = scanner.nextLine();
//			direction = direction.toUpperCase();
//			if(direction.equals("C") || direction.equals("CANCEL")||direction.equals("STOP")||direction.equals("BREAK")){
//				break;
//			}
//			if(direction.equals("N") || direction.equals("NORTH")||direction.equals("U")||direction.equals("UP")){
//				if(terrain(0,-1,player) ==9){
//					System.out.println("You can't go through a mountain!");
//					error = true;
//				}
//				else{
//					player.up();
//					regionChanger(player);
//					if(NPCType(0,0,player) != 0){
//						combat(player);
//						break;
//					}
//					break;
//				}
//			}
//			if(direction.equals("E") || direction.equals("EAST")||direction.equals("R")||direction.equals("RIGHT")){
//				if(terrain(1,0,player)  ==9){
//					System.out.println("You can't go through a mountain!");
//					error = true;
//				}
//				else{
//					player.right();
//					regionChanger(player);
//					if(NPCType(0,0,player) != 0){
//						combat(player);
//						break;
//					}
//					break;
//				}
//			}
//			if(direction.equals("S") || direction.equals("SOUTH")||direction.equals("D")||direction.equals("DOWN")){
//				if(terrain(0,1,player)  ==9){
//					System.out.println("You can't go through a mountain!");
//					error = true;
//				}
//
//				else{
//					player.down();
//					regionChanger(player);
//					if(NPCType(0,0,player) != 0){
//						combat(player);
//						break;
//					}
//					break;
//				}
//			}
//			if(direction.equals("W") || direction.equals("WEST")||direction.equals("L")||direction.equals("LEFT")){
//				if(terrain(-1,0,player)  ==9){
//					System.out.println("You can't go through a mountain!");
//					error = true;
//				}
//				else{
//					player.left();
//					regionChanger(player);
//					if(NPCType(0,0,player) != 0){
//						combat(player);
//						break;
//					}
//					break;
//				}
//			}
//			if(!error){
//				System.out.println("Not a direction");
//			}
//			error = false;
//		}
//	}
//
//
//	public static int terrain(int xChange,int yChange,Player player){
//		try{
//			return (map[player.getYPos()+yChange][player.getXPos()+xChange]%10);
//		}
//		catch (ArrayIndexOutOfBoundsException e){
//			return 0;
//		}
//	}
//
//	public static String terrainType(int xChange,int yChange,Player player){
//		switch(terrain(xChange,yChange,player)){
//		case 1: return "is a path";
//		case 2: return "are some woods";
//		case 3: return "is a town";
//		case 4: return "is a house";
//		case 5: return "is a shop";
//		case 6: return "is a bridge";
//		case 7: return "is a river";
//		case 8: return "is a lake";
//		case 9: return "is a mountain";
//		default: return "is a wall";
//		}
//	}
//
//	public static String NPCName(int NPCType){
//		switch(NPCType%10){
//		case 0: return "nothing";
//		case 1: return "a rat";
//		case 2: return "a warrior";
//		default: return "a unknown foe!";
//		}
//	}
//
//	public static int NPCType(int xChange, int yChange, Player player){
//		try{
//			return ((map[player.getYPos()+yChange][player.getXPos()+xChange]%100)/10); // this has changed to enable regions
//		}
//		catch (ArrayIndexOutOfBoundsException e){
//			return 0;
//		}
//	}
//
//	public static int regionType(int xChange, int yChange, Player player){
//		try{
//			return (map[player.getYPos()+yChange][player.getXPos()+xChange]/100);
//		}
//		catch (ArrayIndexOutOfBoundsException e){
//			return 2;
//		}
//	}
//
//	public static String regionName(int regionType){
//		switch(regionType){
//		case 0: System.err.println("What to print here?"); return "";
//		case 1: return "Valnesse";
//		case 2: return "In the void";
//		case 3: return "Stonehaven";
//		case 4: return "Pinehedge";
//		case 5: return "Valbridge";
//		case 6: return "Magefield";
//		case 7: return "Clearlake";
//		case 8: return "Highdale";
//		default: return "you are lost!";
//		}
//	}
//
//	public static int currentRegion = 2;
//	public static void regionChanger(Player player){
//		int xPos = player.getXPos();
//		int yPos = player.getYPos();
//		int newRegion = regionType(xPos, yPos, player);
//		if(newRegion != currentRegion){
//			if (newRegion == 2){
//				System.out.println("You are now leaving " + regionName(currentRegion));
//			}
//			else{
//				System.out.println("Welcome to " + regionName(newRegion));
//			}
//			currentRegion = newRegion;
//		}
//		else{
//			System.out.println("You are currently in " + regionName(newRegion));
//		}
//	}
//
//	public static void look(Player player){
//		System.out.print("To the left there " + terrainType(-1,0,player));
//		if(NPCType(-1,0,player) != 0) System.out.println(" and " + NPCName(NPCType(-1,0,player)));
//		else System.out.println();
//		System.out.print("To the right there " + terrainType(1,0,player));
//		if(NPCType(1,0,player) != 0) System.out.println(" and " + NPCName(NPCType(1,0,player)));
//		else System.out.println();
//		System.out.print("Up there " + terrainType(0,-1,player));
//		if(NPCType(0,-1,player) != 0) System.out.println(" and " + NPCName(NPCType(0,-1,player)));
//		else System.out.println();
//		System.out.print("Down there " + terrainType(0,1,player));
//		if(NPCType(0,1,player) != 0) System.out.println(" and " + NPCName(NPCType(0,1,player)));
//		else System.out.println();
//		System.out.println();
//	}
//
//	public static void examine(Player player){
//		int target = 0;
//		System.out.println("Which way do you want to examine?");
//		Scanner scanner = new Scanner(System.in);
//		String direction = scanner.nextLine();
//		direction = direction.toUpperCase();
//		if(direction.equals("C") || direction.equals("CANCEL")||direction.equals("STOP")||direction.equals("BREAK")){
//			return;
//		}
//		else
//			if(direction.equals("N") || direction.equals("NORTH")||direction.equals("U")||direction.equals("UP")){
//				target = NPCType(0,-1,player);
//			}
//			else
//				if(direction.equals("E") || direction.equals("EAST")||direction.equals("R")||direction.equals("RIGHT")){
//					target = NPCType(1,0,player);
//				}
//				else
//					if(direction.equals("S") || direction.equals("SOUTH")||direction.equals("D")||direction.equals("DOWN")){
//						target = NPCType(0,1,player);
//					}
//					else
//						if(direction.equals("W") || direction.equals("WEST")||direction.equals("L")||direction.equals("LEFT")){
//							target = NPCType(-1,0,player);
//						}
//						else{
//							System.out.println("Not a direction!");
//							return;
//						}
//
//		if(target ==0){
//			System.out.println("There's nothing there...");
//			return;
//		}
//		else{
//			System.out.println("There's " + NPCName(target) + " there. Check stats?");
//		}
//		String confirm = scanner.nextLine();
//		confirm = confirm.toUpperCase();
//		if(confirm.equals("Y")||confirm.equals("YES")){
//			checkStats(target);
//		}
//		else{
//			return;
//		}
//	}
//
//
//	public static void checkStats(int target){
//		int HP = 0;
//		int level = 0;
//		int attack = 0;
//		switch(target){
//		case 1: HP = Rat.getHP();
//		attack = Rat.getAttack();
//		level = Rat.getLevel();
//		break;
//
//		case 2: HP = Warrior.getHP();
//		attack = Warrior.getAttack();
//		level = Warrior.getLevel();
//		break;
//		}
//		System.out.println("HP: " + HP);
//		System.out.println("level:" + level);
//		System.out.println("attack:" + attack);
//	}
//
//
//
//
//	public static void commands(Player player){
//		// this is to remove the pronoun
//		String currentLoc = terrainType(0,0,player);
//		String[] part = currentLoc.split("\\s");
//		currentLoc = part[1]+" " + part[2];
//		
//		String rst = "";
//		rst += ("You are currently in " + currentLoc);
//		look(player);
//		rst += ("What do you want to do? ");
//
//		Scanner scanner = new Scanner(System.in);
//		String order = scanner.nextLine();
//		order = order.toUpperCase();
//		rst += "\n";
//		if(order.equals("MOVE")||order.equals("ATTACK")||order.equals("FIGHT")){
//			move(player);
//		}
//		else{
//			if(order.equals("LOOK")){
//				look(player);
//			}
//			else{
//				if(order.equals("MAP")){
//					display(player);
//				}
//				else{
//					if(order.equals("STATS")||order.equals("STAT")){
//						player.stats();
//					}
//
//					else{
//						if(order.equals("BREAK")||order.equals("EXIT")){
//							System.out.println("exiting");
//							System.exit(0);
//						}
//						else{
//							if(order.equals("EXAMINE")){
//								examine(player);
//							}
//							else{
//								System.out.println("Unrecognised command!");
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//
//	/***********combat****************/
//
//	//public static int xPos,yPos;
//
//	public static void combat(Player player){
//		String rst = "";
//		rst += "There's " + NPCName(NPCType(0,0,player)) + "\nIt goes to attack!\n";
//		int xPos = player.getXPos();
//		int yPos = player.getYPos();
//		int type = map[yPos][xPos]/10;
//		if (type == 0){
//			rst += "No enemy found.  Why was this called?\n";
//		}
//		else{
//			fight(type,player);
//		}  
//	}
//
//	/*public static int damagePlayer = player.getAttack();
//	public static int playerHP = player.getHP();
//	public static int playerDef = player.getDefense();
//	public static int damageNPC = 0;
//	public static int NPCHP = 0;
//	public static String name = "";
//	public static int NPCdefense = 0;*/
//	
//
//	public static int[] fightStats(int type, Player player){
//		int playerHP = player.getHP();
//		int playerDef = player.getDefense();
//		int damageNPC = 0;
//		int NPCHP = 0;
//		String name = "";
//		int NPCdefense = 0;
//		
//		name = NPCName(type);
//		switch (type%10)
//		{
//		case 1:
//			damageNPC = Rat.getAttack();
//			NPCHP = Rat.getHP();
//			NPCdefense = Rat.getDefense();
//			break;
//		case 2:
//			damageNPC = Warrior.getAttack();
//			NPCHP = Warrior.getHP();
//			NPCdefense = Warrior.getDefense();
//			break;
//		}
//		return new int[]{playerHP,playerDef,damageNPC,NPCHP,NPCdefense};
//	}
//
//
//	private static String fight(int type, Player player){
//		String rstS = "";
//		int [] rst = fightStats(type,player);
//		int playerHP = rst[0];
//		int playerDef = rst[1];
//		int damageNPC = rst[2];
//		int NPCHP = rst[3];
//		int NPCdefense = rst[4];
//		int XPboost = rst[5];
//		
//		int damagePlayer = player.getAttack();
//		String name = NPCName(type);
//		int xPos = player.getXPos();
//		int yPos = player.getYPos();;
//		
//		while(playerHP>0 && NPCHP > 0){
//			int PlayerDamage = (int)((Math.random()*damageNPC)-(Math.random()*playerDef));
//			playerHP -= PlayerDamage;
//			player.hurt(PlayerDamage);
//			if(playerHP <= 0){break;}
//			NPCHP -= (int)(Math.random()*damagePlayer-(Math.random()*NPCdefense));
//		}
//		if(NPCHP <= 0){
//			rstS += "You killed " + name;
//			Map.corpse(xPos,yPos);
//			player.incXP(XPboost);
//		}
//
//		if(playerHP <= 0){
//			rstS += "You died\n";
//		}
//
//		return rstS;
//	}
//
//
//}
