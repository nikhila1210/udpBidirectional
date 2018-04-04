import java.io.*;
import java.net.*;
 
class UDPServer
{
public static void main(String args[]) throws Exception
      {
      DatagramSocket serverSocket = new DatagramSocket(9876);
       BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
       
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            String sendMessage;
            while(true)
               {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData(),0,receivePacket.getLength());
                  System.out.println("RECEIVED: " + sentence);
                  sendMessage = keyRead.readLine(); 
        
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  String capitalizedSentence = sendMessage.toUpperCase();
                  sendData = capitalizedSentence.getBytes();
                   DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
               }
      }
}

