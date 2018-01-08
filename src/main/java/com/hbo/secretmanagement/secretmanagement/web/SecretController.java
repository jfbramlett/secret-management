package com.hbo.secretmanagement.secretmanagement.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbo.secretmanagement.secretmanagement.dto.SecretDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.vault.core.RestOperationsCallback;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestOperations;

import java.util.List;
import java.util.Map;

@Controller
public class SecretController {
    private static final Logger logger = LoggerFactory.getLogger(SecretController.class);

    private static final TypeReference<Map<String, Object>> MAP_TYPEREF = new TypeReference<Map<String, Object>>() {};

    @Autowired
    private VaultTemplate vaultTemplate;

    @ResponseBody
    @RequestMapping(value = "secret", method= RequestMethod.GET, produces = "application/json")
    public SecretDto secret() {
        VaultResponse response = vaultTemplate.read("secret/sample");
        Map<String, Object> responseData = response.getData();
        return new SecretDto(responseData.get("secret.management.value").toString());
    }
}
