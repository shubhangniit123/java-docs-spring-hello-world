package com.sapient.learning.springbootazurekeyvault;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

@RestController
public class SecretKeyController {

	  @RequestMapping("/")
	   public String getKeyvaultValue()
	   {
	      return getStoredValue("Shubhang1234");
	   }
	 
	   private String getStoredValue(String keyName){	      
	      String keyVaultUri = "https://sapientlearningapp.vault.azure.net/";
	      SecretClient secretClient = new SecretClientBuilder()
	      .vaultUrl(keyVaultUri)
	      .credential(new DefaultAzureCredentialBuilder().build())
	      .buildClient();
	      KeyVaultSecret storedSecret = secretClient.getSecret("Shubhang1234");
	      return storedSecret.getValue();
	   }
}
