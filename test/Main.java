import javax.sound.sampled.*;

/**
* print all available system mixers, line, controlls
*/
public class Main{

  public static void main(String [ ] args) throws LineUnavailableException{
    Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
    for (Mixer.Info mixerInfo : mixerInfos) {
      print("info: " + mixerInfo);
      Mixer m = AudioSystem.getMixer(mixerInfo);
      print("mixer: " + m);

      //source lines
      Line.Info[] sourceLineInfos = m.getSourceLineInfo();
      for (Line.Info sourceLineInfo : sourceLineInfos) {
        print("    source: " + sourceLineInfo);
        Line line = AudioSystem.getLine(sourceLineInfo);

        Control[] controls = line.getControls();
        for (Control control : controls)
          print("       control: " + control);
      }

      //target lines
      Line.Info[] targetLineInfos = m.getTargetLineInfo();
      for (Line.Info targetLineInfo : targetLineInfos) {
        print("    target: " + targetLineInfo);
        Line line = AudioSystem.getLine(targetLineInfo);

        Control[] controls = line.getControls();
        for (Control control : controls)
          print("       control: " + control);
      }

      print("");
    }
  }

  public static void print(String msg){
    System.out.println(msg);
  }
}
