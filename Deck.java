import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	public ArrayList<Card> usedCard=new ArrayList<Card>();//記得要初始化
	public int nUsed=0;
	
	public Deck(int nDeck){ //constructor
		cards=new ArrayList<Card>();
		for(int n=0;n<nDeck;n++){
			for(Card.Suit s:Card.Suit.values()){
				for(int r=1;r<14;r++){
					Card card=new Card(s,r);
					cards.add(card);	
				}
			}
		}
		shuffle();//洗牌
	}	
	
	public void printDeck(){
		for(Card card:cards){
			card.printCard();
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	public void shuffle(){
		Random rnd=new Random();
		for(int i=0;i<cards.size();i++){
			int newp =rnd.nextInt(cards.size());//隨機的新位置
			Card ChangeCard =cards.get(newp);//把新card拿出來保存
			cards.set(newp, cards.get(i));//將原本card放到新位置
			cards.set(i, ChangeCard);//把新card放到原本位置
		}
			usedCard.clear();//清除
			nUsed=0;//清除
		
	}
	public Card getOneCard(){
		if(nUsed==cards.size()){		//表示沒有牌了
			shuffle();
			}
		usedCard.add(cards.get(nUsed));//把cards加入手牌
		nUsed++;//計算發出去幾張
		return usedCard.get(nUsed-1);
		
	}
}
