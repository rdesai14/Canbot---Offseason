package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Piston extends SubsystemBase{
    private final Compressor compressor;
    private final Solenoid armSolenoid;
    private final DigitalInput button;

    public Piston() {
        super();
        //initializing compressor and solenoid  
        compressor = new Compressor(8, PneumaticsModuleType.CTREPCM); //need to change module id 
        armSolenoid = new  Solenoid(8, PneumaticsModuleType.CTREPCM, 1);
        compressor.enableDigital();
        button = new DigitalInput(0);


        //need to change module id
    }
   public void stop(){
    compressor.disable();
   }  
 

   public void extend(){
    //sets the solenoid output to on
    armSolenoid.set(true);
   }

   public void retract(){
    //sets the solenoid output to on
    armSolenoid.set(false);
   }

   public void toggle(){
    if(detected()){
        retract();
    }else{
        extend();
    }
   }

   public boolean detected(){
    return button.get();
   }
}