package ullman.paintNetworking;


import ullman.paintNetworking.message.PaintMessage;

public interface NetworkModule {

	public void sendMessage(PaintMessage message);

}
