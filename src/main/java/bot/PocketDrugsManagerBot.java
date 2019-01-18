package main.java.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PocketDrugsManagerBot extends TelegramLongPollingBot  {

	public static void main(String[] args) {
        ApiContextInitializer.init();
        
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
        	botsApi.registerBot(new PocketDrugsManagerBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void onUpdateReceived(Update update) {
	    if (update.hasMessage() && update.getMessage().hasText()) {
	        SendMessage message = new SendMessage()
	                .setChatId(update.getMessage().getChatId())
	                .setText("Hello!"); // welcome text
	        try {
	            execute(message);
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	@Override
	public String getBotUsername() {
		return "DrugsManagerBot";
	}
	
	@Override
	public String getBotToken() {
		return "708320814:AAHRGPrAZI7PFkwF0TvqmiBgLK79HOgYoyE";
	}

}