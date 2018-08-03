package testTemplate;

public abstract class AccessManager {
	abstract void showPlayer();
	abstract void matchDay();
	
	public final void play() {
		showPlayer();
		matchDay();
	}
}
