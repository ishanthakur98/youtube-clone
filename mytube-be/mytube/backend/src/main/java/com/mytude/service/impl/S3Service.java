package com.mytude.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.mytude.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service implements FileService {

    public static final String MYTUBE_STORAGE = "mytube-storage";

    private final AmazonS3Client s3Client;

    

    @Override
    public String uploadFile(MultipartFile file){

      var filenameExtension =  StringUtils.getFilenameExtension(file.getOriginalFilename());

      var key =  UUID.randomUUID().toString() + "." + filenameExtension;

      var metadata = new ObjectMetadata();
      metadata.setContentLength(file.getSize());
      metadata.setContentType(file.getContentType());

        try {
            s3Client.putObject(
                    MYTUBE_STORAGE , key,file.getInputStream(),metadata);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occurred while uploading file");
        }
        s3Client.setObjectAcl(MYTUBE_STORAGE , key , CannedAccessControlList.PublicRead);

        return s3Client.getResourceUrl(MYTUBE_STORAGE , key);


    }
}
