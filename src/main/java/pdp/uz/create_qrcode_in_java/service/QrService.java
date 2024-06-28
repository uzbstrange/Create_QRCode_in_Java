package pdp.uz.create_qrcode_in_java.service;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class QrService {

    public void generateQrCode(String content, OutputStream outputStream) throws IOException, WriterException {
        BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, 200, 200);
        MatrixToImageWriter.writeToStream(bitMatrix, "jpeg", outputStream);
    }

    public String readQrCode(byte[] content) throws IOException, NotFoundException {
        Result result = new MultiFormatReader()
                .decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(
                        ImageIO.read(new ByteArrayInputStream(content))))));

        if (result != null) {
            return result.getText();
        } else {
            return null;
        }
    }
}
