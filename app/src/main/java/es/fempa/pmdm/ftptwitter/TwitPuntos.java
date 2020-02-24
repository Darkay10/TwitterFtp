package es.fempa.pmdm.ftptwitter;

import twitter4j.conf.*;

public class TwitPuntos {
    private Twitter twitter;
    public TwitPuntos() {
       ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("tFIzxPJ3CqfcHQLDDaK87Y1LP")
                .setOAuthConsumerSecret("uqbMK3KQf4i4PULkgDK5HLfGpRpKDNVYwNKsDXi65AEnWT1KaS")
                .setOAuthAccessToken("1229778457938321408-MObDFO5wO1zaFRzmLBGf7vkqtVISlG")
                .setOAuthAccessTokenSecret("myJgWgwTmjNolkE4JFUIfgP7c4uqF6bTD3kjSt0hxoNWS");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
    }

}