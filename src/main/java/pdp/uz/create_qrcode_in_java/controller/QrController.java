package pdp.uz.create_qrcode_in_java.controller;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pdp.uz.create_qrcode_in_java.Dto.GenerateQrDto;
import pdp.uz.create_qrcode_in_java.Dto.QrRequestDto;
import pdp.uz.create_qrcode_in_java.Dto.QrResponseDto;
import pdp.uz.create_qrcode_in_java.service.QrService;

import java.io.IOException;

@RestController
@RequestMapping("/qr")
public class QrController {

    private final QrService qrService;

    public QrController(QrService qrService) {
        this.qrService = qrService;
    }

    @PostMapping(path = "/generate", produces = MediaType.IMAGE_JPEG_VALUE)
    public void generateQrCode(@RequestBody GenerateQrDto request, HttpServletResponse response) throws MissingRequestValueException, IOException, WriterException {
        if (response == null || request.getQrNumber()==null || request.getQrNumber().trim().equals("")){
            throw new MissingRequestValueException("You have to enter QrNumber !");
        }

        qrService.generateQrCode(request.getQrNumber(), response.getOutputStream());
        response.getOutputStream().flush();
    }

    @PostMapping("/read")
    public QrResponseDto decodeQrCode(@RequestParam("qrCode") MultipartFile qrCode) throws MissingRequestValueException, IOException, WriterException, NotFoundException {
        String qrCodeString = qrService.readQrCode(qrCode.getBytes());
        return new QrResponseDto(qrCodeString);
    }
}
