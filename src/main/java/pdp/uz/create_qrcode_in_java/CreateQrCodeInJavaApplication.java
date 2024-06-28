package pdp.uz.create_qrcode_in_java;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Paths;

@SpringBootApplication
public class CreateQrCodeInJavaApplication {

    public static void main(String[] args) throws WriterException, IOException {

        SpringApplication.run(CreateQrCodeInJavaApplication.class, args);

        /*String data = "https://www.google.com/?client=safari";
        String path = "/Users/yahyo04/Desktop/QRCodeLink.jpg";

        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE,500,500);

        MatrixToImageWriter.writeToPath(matrix,"jpg", Paths.get(path));
        System.out.println("QR code successfully created");*/
    }

}
