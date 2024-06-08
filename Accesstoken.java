package pcn.action.sunichith.developer.firebasepushnotification;


import android.util.Log;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Accesstoken {

    private static final String firebaseMessagingscope="https://www.googleapis.com/auth/firebase.messaging";

    public String getAccessToken(){
        try{
            String jsonString="{\n" +
                    "  \"type\": \"service_account\",\n" +
                    "  \"project_id\": \"videoplayer-e7669\",\n" +
                    "  \"private_key_id\": \"ef883880befdf115d64dafd4fa477aece0c9a20a\",\n" +
                    "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDEig68ofLQeqTr\\nT1Mzku2rQvWksz5t9wukByK9P1MbveuinI+JQh4bM5wXBGLfSr75hmM7GgHkdldG\\njFRS4K9spd7T5bhTd61s53+rwjX/3gJeufnuYwBQa2FJJIcPmb2raKCmmpFgRT7J\\n07L4fs/14cALjJbjLNZmHcu/h8VBxvwzMfW1XgjPwVg+0x3F25Kfu82RkXLI8eCX\\nm41bT9cAALK/KUlL23YALeTjoAiZCZbR5lL2Auk7pBHQzjIL6CLAocrCUlvYWdRZ\\n9Tx6nx2ZMOBC2jujL5BpdcB5QUC7r0bxkkzMElRgyL3Zv+5n7pEuriMfRzrF/BgJ\\nDxAO8Dm3AgMBAAECggEAK38CU+zjeBAsf4dGuptBzi07f//LSTrrcJnDrm5dTj5x\\n78MGYTIox4xcdxuZZiF8smxzeZj/4jfuiMZ1wwHG0RzEe9DTQmWyE/AH6VNJ8B6K\\nF7zA+2kdoK6jETTsTx+PQmgdZcG/erbYdoJLkYM/MwOLJQMwQYaizGa7uN+rYCrt\\nuoaoN2kJT/0LFlUNDGDHndOp4EB2/o+JAI/Fp94GaJBpN5GTBGRX9rRxn9LoCPPN\\njVFeSLr9L2qLWmz4BSUbl99VB6rA2C+PNOZ/AwspcpbyXnJ7GfmV+tUqm9sXQ67G\\n01HE8DcBvg94c0s2xR80U134XsoTubLz7FkLuRsGAQKBgQD5tKhY1qqGVyLp+g0n\\nxTfbCthlMFjxNB4WedozWkg5NqA0xQ6eh9qv8jWggUIFC+c6U6hK8zyZQBgAGy4/\\npdmUQQ/9QJAIHQcrLCdaG3U8Trs0aGtxgoMV0AuXKFT4sUByiV0YcjKyOZOugOpE\\nQycxMOgAeB12lB8wguv2BhDnVwKBgQDJflGl8OTq8WA/VHG+oDyRn2usXsdqlSK6\\nuTSarlyCaxMU7DeRYpWqUzjumVsxO5e6Fy8AEQN9aEcdDyQ12yoT/OfZhtigxsDP\\nOZCIijEkryFJMuGPTwvuuxtGPpt1Y2zPAR6biPct/s1NbWKwfenNhN06AjINjar1\\n8F/1bN2koQKBgQD2NT4Ekm0DFumzAD12aEwBqzjg1QHtmjDMgos2NR+fYhAm1+Hp\\nSBTFhTGBN9HLvgfZB+GZPSoUBRFlEWfRlArr1hcY407g4RZPaDLI8ufudca6DvdZ\\nrZDosgCrozXdHJBqHqzvTLJV7tWBq1TRx9Dd/NXUmJqcb8ItB/n209ZY8wKBgQCw\\n9XyVpUQWxphF5k7jIO0w43b38mFmzMWsgb2eX6WlcI5YoMCIsbFJ3j8w5YR+b5zo\\ndTX08/xBplRWRBcEKZAB7+pbU59rTELHfAHguKVCV4B/Pe11I/IR30er4I49gW1t\\nO8l6xcZ4IcCC0J+M63hr49U6/fShjJrp1gsgi1T5IQKBgQDxemHPW7jPdILZvB37\\nIBZQjPSy96j+E0/lCfqTmjw57Lt8cvddEpjy92IUi0rNoK4ajlpASGqON0DtjMfz\\noTAToexNNfhfKXRhM/cUorrxrC3aGYhyNy8u+iTGjQwh3mbC2DOleajdT0d9ui82\\ndBPOVjNsszBxceI0qeBknohtUw==\\n-----END PRIVATE KEY-----\\n\",\n" +
                    "  \"client_email\": \"firebase-adminsdk-jdkgd@videoplayer-e7669.iam.gserviceaccount.com\",\n" +
                    "  \"client_id\": \"117671369298855812591\",\n" +
                    "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                    "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                    "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                    "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-jdkgd%40videoplayer-e7669.iam.gserviceaccount.com\",\n" +
                    "  \"universe_domain\": \"googleapis.com\"\n" +
                    "}";

            InputStream stream=new ByteArrayInputStream(jsonString.getBytes(StandardCharsets.UTF_8));
            GoogleCredentials googleCredentials=GoogleCredentials.fromStream(stream).createScoped(Lists.newArrayList(firebaseMessagingscope));
            googleCredentials.refresh();
            return googleCredentials.getAccessToken().getTokenValue();

        } catch (IOException e) {
            Log.e("EROR",e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
