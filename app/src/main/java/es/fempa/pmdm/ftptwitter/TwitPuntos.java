package es.fempa.pmdm.ftptwitter;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitPuntos {
    private Twitter twitter;
    private TwitterFactory tf;
    public TwitPuntos() {
       ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("tFIzxPJ3CqfcHQLDDaK87Y1LP")
                .setOAuthConsumerSecret("uqbMK3KQf4i4PULkgDK5HLfGpRpKDNVYwNKsDXi65AEnWT1KaS")
                .setOAuthAccessToken("1229778457938321408-MObDFO5wO1zaFRzmLBGf7vkqtVISlG")
                .setOAuthAccessTokenSecret("myJgWgwTmjNolkE4JFUIfgP7c4uqF6bTD3kjSt0hxoNWS");
        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public void tweetPoints(int puntos, String user){
        String finalS = "¡Enhorabuena @"+user+" conseguiste la maxima puntuación con "+puntos+" puntos!";
        try {
            twitter.updateStatus(finalS);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

}