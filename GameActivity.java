package com.example.rpgsurvivalgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.Serializable;

public class GameActivity extends AppCompatActivity {

    public class Node {
        String text;
        String leftButton;
        String rightButton;
        Node left;
        Node right;
        Node(String text, String leftButton, String rightButton) {
            this.text = text;
            this.leftButton = leftButton;
            this.rightButton = rightButton;
            right = null;
            left = null;
        }
    }

    public class BinaryTree {
        // Root of Binary Tree
        Node root;

        BinaryTree()
        {
            root = null;
        }
    }
    BinaryTree tree = new BinaryTree();
    BinaryTree newTree = new BinaryTree();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        tree.root = new Node("You wake up in what seems to be a forest. It's nighttime, and you can't seem to remember how you got here.", "Look around", "Call for help");

        tree.root.left = new Node("You get up, and all of a sudden, your head starts spinning. You try to focus on your surroundings, but it's too dark to see anything.", "", "Next");
        tree.root.right = new Node("\"Hello? Is anyone there?\", you yell, hoping someone hears you. There's no response. Suddenly, an arrow streaks past, narrowly missing you.", "", "Next");

        tree.root.left.right = new Node("You blindly walk in a random direction, when you suddenly hear a scream.", "Ask \"Who's there?\"", "Hide");
        tree.root.right.right = new Node("You quickly get up, and are hit with an intense headache. You try to shake it off, and look around. It's too dark to see anything, but you have no other choice but to run.", "", "Next");

        tree.root.left.right.left = new Node("\"Who's there?\", you yell. \"Help!\", the voice screams.", "Follow the\nvoice", "Ignore the\nvoice");
        tree.root.left.right.right = new Node("You quickly lie down in some tall grass, hoping nobody saw you. There's another scream, and then silence.", "Investigate\nthe screams", "Walk away");
        tree.root.right.right.right = new Node("You start blindly running, knocking into trees and tripping over rocks. The headache is becoming unbearable now. You stop for a moment to catch your breath. It seems like the attacker is gone now.", "Look for shelter", "Try to find\nthe attacker");

        tree.root.left.right.left.left = new Node("\"I'm coming!\", you yell back, running in the direction of the voice. Suddenly, you hear multiple voices.", "", "Next");
        tree.root.left.right.left.right = new Node("You decide to play it safe, and walk in the opposite direction. Suddenly, you hear something behind you.", "", "Next");
        tree.root.left.right.right.left = new Node("Keeping to the shadows, you slowly walk in the direction you heard the screams from. The headache is becoming unbearable now, but you're curious to see what happened.", "", "Next");
        tree.root.left.right.right.right = new Node("You start walking away in the opposite direction of the screams. The headache continues to worsen.", "", "Next");
        tree.root.right.right.right.left = new Node("You start walking again, trying to look for a shelter.", "", "Next");
        tree.root.right.right.right.right = new Node("You look around your surroundings, trying to find your assailant. You decide to start walking in the direction you came from, hoping that the attacker doesn't see you.", "", "Next");

        tree.root.left.right.left.left.right  = new Node("You can't make out what they're saying. Without thinking, you hide in some tall grass, hoping nobody saw you.", "Wait for them\nto leave", "Attack them");
        tree.root.left.right.left.right.right = new Node("A split second later, you feel a sharp pain in your back and fall to the floor. The last thing you see is a dark figure in front of you with a knife. The silver blade comes slashing towards you, and all goes dark.", "", "Next");
        tree.root.left.right.right.left.right = new Node("A figure on the ground catches your sight. Upon approaching, you gasp in horror.", "", "Next");
        tree.root.left.right.right.right.right = new Node("After walking for what feels like hours, you see a light in the distance. It looks like a village.", "Go to\nthe village", "Keep walking");
        tree.root.right.right.right.left.right = new Node("After walking for what feels like hours, you see a light in the distance. It looks like a village.", "Go to\nthe village", "Keep walking");
        tree.root.right.right.right.right.right = new Node("You hear the sound of footsteps up ahead. You find a rock and pick it up, hoping to attack your assailant. All of a sudden, you hear a sinister voice behind you. \"Looking for me?\".", "", "Next");

        tree.root.left.right.left.left.right.left = new Node("You stay where you are, hoping they don't walk in your direction. Luckily, after talking to each other for a while, they turn around and head in the opposite direction.", "", "Next");
        tree.root.left.right.left.left.right.right = new Node("You look around for something to attack them with. You find two heavy stones on the ground and decide to hit them with the stones at point-blank range, hoping to kill them, or at least injure them.", "", "Next");
        tree.root.left.right.left.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.right.left.right.right = new Node("There's a dead body in front of you. And not just any dead body. There's fresh wounds all over it. Undoubtedly, this is the victim who you heard moments ago.", "Walk away", "Look for\nthe assailants");
        tree.root.left.right.right.right.right.left = new Node("You decide to enter the village, hoping to find a place to stay. The sun is just starting to rise now. But why are you here? What were you doing in the middle of the forest? And what was that scream? All this thinking is making your headache worse.", "", "Next");
        tree.root.left.right.right.right.right.right = new Node("You decide not to enter the village, as you don't know who might be there. The sun is just starting to rise now. Why are you here? What were you doing in the middle of the forest? And what was that scream?", "", "Next");
        tree.root.right.right.right.left.right.left = new Node("You decide to enter the village, hoping to find a place to stay. The sun is just starting to rise now. But why are you here? What were you doing in the middle of the forest? And who was the person attacking you, and why? All this thinking is making your headache worse.", "", "Next");
        tree.root.right.right.right.left.right.right = new Node("You decide not to enter the village, and opt to keep walking. Suddenly, you hear a noise nearby, and instantly feel a sharp pain in your arm. You look and are shocked to see an arrow lodged in your arm.", "", "Next");
        tree.root.right.right.right.right.right.right = new Node("You turn around, and the last thing you see is a knife lashing out towards you. There's a sharp pain in your neck, and the world goes dark.", "", "Next");

        tree.root.left.right.left.left.right.left.right = new Node("While you're glad they're gone, you're also angry that you weren't able to hear their conversation.", "", "Next");
        tree.root.left.right.left.left.right.right.right = new Node("You slowly move towards your targets, crouching low so they don't notice you. You hurl a stone at the one closest to you.", "", "Next");
        tree.root.left.right.right.left.right.right.left = new Node("You quickly walk away from the scene, thinking that the attackers might still be nearby. The sun is starting to rise now, and you still have no idea how you ended up here.", "", "Next");
        tree.root.left.right.right.left.right.right.right = new Node("You look around, trying to find the murderer, or murderers. There seems to be no trace of them anywhere.", "", "Next");
        tree.root.left.right.right.right.right.left.right = new Node("The village looks completely deserted. You look around, trying to find the villagers.", "", "Next");
        tree.root.left.right.right.right.right.right.right = new Node("Your head starts spinning, but you keep walking. You're also hungry now. You hope to find some shelter and food, and then try to answer the questions burning in your head.", "", "Next");
        tree.root.right.right.right.left.right.left.right = new Node("You enter the village, just as the sun is beginning to rise. You see an elderly man sitting alone up ahead. You decide to talk to him.", "", "Next");
        tree.root.right.right.right.left.right.right.right = new Node("Wincing in pain, you change direction, running towards the village for help. Another arrow flies past you.", "", "Next");
        tree.root.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");

        tree.root.left.right.left.left.right.left.right.right = new Node("Your headache is becoming unbearable now. To make matters worse, you're also hungry.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right = new Node("The stone directly hits your target on the head, and he falls, blood gushing from the impact. You grab the other stone to attack the second person, but before you can throw it, he turns around and sees you.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right = new Node("You keep walking, hoping to find some place to stay. After walking for a couple of hours, you see a campfire up ahead. There's also people there, but you don't recognize them.", "Go to\nthe camp", "Walk away");
        tree.root.left.right.right.left.right.right.right.right = new Node("You walk in a random direction, keeping a look out for the attackers. You still can't find any clues. Giving up on the search, you decide to look for a village or town.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right = new Node("You keep walking, and see an elderly man sitting alone up ahead. You decide to talk to him", "", "Next");
        tree.root.left.right.right.right.right.right.right.right = new Node("After walking for a couple more hours, you come across a river. On the other side, you see a boy.", "Call to him", "Walk away");
        tree.root.right.right.right.left.right.left.right.right = new Node("\"Hello\", you say, walking up towards him. He looks up to see you. \"Good day young man\", he replies.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right = new Node("You keep running in the direction of the village. Upon nearing its entrance, you see someone sitting alone near a hut.", "Call out\nfor help", "Run past him");

        tree.root.left.right.left.left.right.left.right.right.right = new Node("You get up, and try to remember why you're here. What were you doing in the middle of the forest? You can't seem to remember anything.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right = new Node("You drop the rock, and start running away from him as fast as you can. As you run, you can hear his footsteps getting louder. He's catching up.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left = new Node("You walk towards the camp. Suddenly, a few of the campers attack you. The next thing you know, you're on the ground, held in place by a couple of the attackers. \"Well well well. Look who we have here\", another one says.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right = new Node("You ignore them and start walking away, thinking they might be dangerous. What if they're responsible for the dead body you saw?", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right = new Node("After walking for a couple more hours, you come across a river. On the other side, you see a boy.", "Call to him", "Walk away");
        tree.root.left.right.right.right.right.left.right.right.right = new Node("\"Hello\", you say, walking up towards him. He looks up to see you. \"Good day young man\", he replies.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left = new Node("\"Hello\", you call out to him. He looks up to see you, and smiles. Suddenly, you see him start to levitate. You rub your eyes, and look again.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.right = new Node("You slowly walk away, hoping he didn't see you. What if he's responsible for those screams? But he seems to young to be dangerous.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right = new Node("\"Can I stay here?\", you ask. \"I'm sorry, I don't remember anything or how I got here. Can you please help me?\", you add.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left = new Node("\"Help!\", you yell. The person turns around, shocked to see you running towards him. Another arrow flies past, brushing against you.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.right = new Node("You ignore the mysterious person, thinking that he may also try to attack you. You keep running.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right = new Node("You decide to look for a town or village. Then, you can get something to eat. You start walking, and look around.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right = new Node("Suddenly, you see a campfire up ahead. There seems to be people there, as well as guards around the camp.", "Call for help", "Ignore them");
        tree.root.left.right.right.left.right.right.left.right.left.right = new Node("Are these people responsible for the dead body you saw? If so, you're probably in a lot of trouble. \"Umm, sorry to bother you guys, but I really need a place to stay. Can you help me?\", you ask.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right = new Node("You keep walking, hoping to find a shelter. The sun is starting to rise now. But why are you here? Who killed that person you saw? And who were those people in the camp? Your head starts spinning again.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.left = new Node("\"Hello\", you call out to him. He looks up to see you. Suddenly, you see him start to levitate. You run your eyes, and look again.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right = new Node("You slowly walk away, hoping he didn't see you. What if he's responsible for those screams? But he seems too young to be dangerous.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right = new Node("\"Where are all the villagers?\", you ask. \"The Hunters got to them all\", he replied. \"I couldn't stop them\".", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right = new Node("Now you see the boy flying towards you. You can't believe your eyes. Is this a dream?", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.right.right = new Node("You walk for a few more hours, growing more tired by the minute. So, you decide to sit down and rest for a while.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right = new Node("The man looks at you, confused. \"Umm, sure. But I must tell you, the Hunters attacked last night. The villagers are gone\".", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right = new Node("The person in front of you gets up. You can now see that he is an old man. The man raises his hands.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.right.right = new Node("Suddenly, you feel an intense pain in your back. You scream and fall to the ground. You look behind you and see an arrow stuck to your back. \"Who goes there?\", you hear someone say.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right = new Node("You walk for hours, and see no signs of civilization. The sun is starting to rise now. You're slowly growing weak from hunger and your headache.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.left = new Node("\"Help!\", you yell, running towards the camp. One of the guards looks straight at you, and pulls out a bow.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right = new Node("You ignore them, and try to run around the camp. Suddenly, a figure comes in front of you, blocking your path.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right = new Node("The strangers look at each other, then start laughing. \"Alright now. What's all this?\", someone says, walking towards you and your attackers. Everyone in the camp stops and listens to him immediately. It looks like he's their leader.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right = new Node("After walking for a few more hours, you see a cave. You barely have any energy left in you, so you decide to go inside.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.left.right = new Node("Now you see the boy flying towards you. You can't believe your eyes. Is this a dream?", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right = new Node("All of a sudden, a figure comes and stands in your way. He pulls out a dagger. \"Hello there\", he says in a sinister voice.", "Run away", "Fight");
        tree.root.left.right.right.right.right.left.right.right.right.right.right = new Node("\"What?\", you ask, more confused than shocked. \"What happened to them? What Hunters?\".", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right = new Node("He lands beside you, and waves. You stare at him. \"H-how did you do that?\", you ask, shocked.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.right.right.right = new Node("Right as you're about to fall asleep, a man walks up in front of you. Before you can react, he pulls out a dagger, and the last thing you see is the blade lashing out towards you.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right = new Node("\"What do you mean? What are Hunters?\", you ask. The man looks at you as if you're crazy. \"The Hunters. Don't you know them?\", he asks.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right = new Node("Suddenly, you're blinded by an intense light. You're thrown off balance as you hear an explosion behind you.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.right.right.right = new Node("You turn around to see the person who you saw sitting alone. He's an old man. But before he can react, you feel more pain in your head. Another arrow. You can't think straight, and your vision gets blurry.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right = new Node("You see a cave up ahead. You aren't sure if it's safe to enter.", "Enter the cave", "Keep walking");
        tree.root.left.right.left.left.right.right.right.right.right.right.left.right = new Node("He lets the arrow fly, and it hits you directly in the chest. You fall in pain, gasping for air. The man you were running away from catches up to you. The last thing you see is a silver blade in his hand, slashing towards you.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right = new Node("You turn around, and see the other man running towards you. So, you try to run past the man, in front of you. However, a few more strangers arrive, and tackle you down.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right = new Node("\"He's saying he's lost, one of them say, pointing to you. Their leader looks at you, and is shocked. \"You..., you're alive...\", he stutters.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right = new Node("There's nobody inside, so you decide to stay there for a while.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.left.right.right = new Node("The boy raises his hands, and you're suddenly blinded by an intense light. You hear an explosion behind you.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.left = new Node("You run away, and the man starts chasing you. Suddenly, you feel a sharp pain in your shoulder. You look and see the dagger falling beside you. The man had thrown it at you, and it cut your shoulder. Thankfully, it doesn't seem to be a deep wound.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right = new Node("You face the man, ready to defend yourself. As he lunges towards you, you roll to the side and grab his legs, wrestling him to the ground. His dagger goes flying off to the side.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right = new Node("\"How do you not know who the Hunters are? Stop playing around\", the man replies.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right = new Node("He looks at you as if you've gone crazy. He points to the other side of the river. \"What?\", you ask.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right = new Node("You think about the attacker you just ran away from. Could he be a 'Hunter'?", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right = new Node("You turn around, and see the burnt body of your attacker. What just happened? \"What did you do?\", you ask the old man.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.right.right.right.right = new Node("You hear something that sounds like an explosion. The old man starts walking up to you, but everything goes dark.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left = new Node("You decide to enter the cave. There's nobody inside, so you decide to stay there for a while.", "", "Next");
        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.right = new Node("You keep walking, thinking the cave might be unsafe. Suddenly, you feel a sharp pain in your neck. You just got hit by an arrow. You fall to the ground in pain, and all goes dark.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.left.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right = new Node("Are these people responsible for the screams you heard? If so, you're probably in a lot of trouble. \"Umm, sorry to bother you guys, but I really need a place to stay. Can you help me?\", you ask.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right = new Node("You look at him, confused. Maybe you knew each other. \"I'm sorry, but, am I supposed to know you?\", you ask.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right = new Node("After resting for a while, you decide to explore the cave. You start walking deeper inside. You're really hungry now and can barely walk.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.left.right.right.right = new Node("You turn around, and see the dead body of a man. What did the boy do? He lands beside you, and you take a step back.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.left.right = new Node("The pain slowed you down, and the man is getting closer. You turn and see that he has another dagger.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right = new Node("You try your best to knock him out, but he hits you on the head. It shouldn't have hurt, but it seems like your head hasn't healed from whatever knocked you out earlier.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right = new Node("\"I honestly have no idea\", you tell the man. \"I think I lost my memory or something. I can't even remember why I'm here\", you add. \"The sole job of the Hunters is to kill as many people as possible\", the man says.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right = new Node("He rolls his eyes, and grabs you by the hand. \"What do you want-\", you begin. Suddenly, you feel your feet being lifted off the ground. The boy starts to fly to the other side, taking you with him. \"Stop! Stop!\", you yell, frightened.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right = new Node("\"Someone attacked me on the way here. Was he a Hunter?\", you ask. The man looks at you, shocked. \"You were attacked? Did the Hunter follow you?\". \"I don't think so\", you reply. It's the honest truth.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right = new Node("\"I'm a Warrior\", he replies. \"Now, let me fix your arm\". \"Thanks\", you say, as he leads you inside the hut. You're still not sure if he can be trusted though.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right = new Node("After resting for a while, you decide to explore the cave. You start walking deeper inside. You're really hungry now and can barely walk.", "", "Next");
        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right = new Node("The strangers look at each other, then start laughing. \"Alright now. What's all this?\", someone says, walking towards you and your attackers. Everyone in the camp stops and listens to him immediately. It looks like he's their leader.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right = new Node("The man just stares at you. \"Don't you know me?\", he asks.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right = new Node("After walking for a while, you come across what seems to be an underground lake. Up ahead, you see some bushes with berries as well.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.left.right.right.right.right = new Node("Before you can say anything, an arrow hits you on the head. You fall over in pain. The last thing you see is the boy walking up towards you.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.left.right.right = new Node("You keep running as fast as you can. You make a turn, and are shocked to see the path blocked by a huge boulder. You turn around and see the man standing in front of you.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right = new Node("You start seeing stars, and stumble backwards. You see that the man has his dagger again, and strikes you on the stomach.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right = new Node("\"There are also people who rebel against the leaders of the Hunters\", the man continues. \"It will be safer if we can get to them. I'm supposed to go help them now anyways.\" What is he talking about? \"What rebels?\", you ask.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right = new Node("You both land on the other side. You're too shocked to say anything. He grabs you by the arm, and leads you to what looks like an army camp. He takes you to a hut, and leaves.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right = new Node("He looks at you, and shakes his head. \"How do you not know about the Hunters?\", he asks. \"You've got to be joking\".", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right = new Node("Once inside, he starts fixing your wound. You have many questions. \"What did you do back there?\", you ask him. \"Have you never met a Warrior before?\", he asks. \"I don't even know what a Warrior is\", you reply.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right = new Node("After walking for a while, you come across what seems to be an underground lake. Up ahead, you see some bushes with berries as well.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right = new Node("\"He's saying he's lost, one of them say, pointing to you. Their leader looks at you, and is shocked. \"You..., you're alive...\", he stutters.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right = new Node("\"I don't really remember anything\", you reply. \"I woke up in the middle of this forest, and I can't remember anything before that\", you add.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right = new Node("You have no energy left in you to think, and start gobbling up the berries and drinking from the lake. Finally, you feel your energy coming back.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.left.right.right.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.left.right.right.right = new Node("\"Who are you? What do you want?\", you ask. The man stares at you, then starts laughing. \"We want you all dead, obviously\", he says. \"That is, until the resistance stops fighting anyway\".", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right = new Node("You fall back in pain. All of a sudden, you hear a deafening sound of an explosion. The world around you momentarily fills with light, and then everything goes dark.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right = new Node("\"You'll see\", the man says, smiling. You have no other choice, but to follow him.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right = new Node("It seemed like he wanted you to wait for him. But why didn't he say anything? And what were those powers he had?", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right = new Node("\"I'm not\", you reply. \"I think I lost my memory. My head's been hurting since I woke up in the middle of the forest, and I don't even remember why I was there in the first place\".", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right = new Node("The man stares at you. \"How do you not know?\", he asks, surprised. You remember your headache. \"I think I got hit on the head\", you explain. \"I woke up in the middle of the forest, but I don't remember anything before that\".", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right = new Node("You have no energy left in you to think, and start gobbling up the berries and drinking from the lake. Finally, you feel your energy coming back.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You look at him, confused. Maybe you knew each other. \"I'm sorry, but, am I supposed to know you?\", you ask.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right = new Node("The man walks away, chuckling to himself. \"Get a tent ready for him. He's staying with us\", he tells everyone.", "Accept his\noffer", "Decline his\noffer");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right = new Node("You hear people's voices coming from outside the cave. You hear yet another scream. What if the attackers come here? You go and hide behind a bush, hoping they don't find you.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.left.right.right.right.right = new Node("Resistance? What is he talking about? \"What resistance?\", you ask. The man just stares at you, then starts laughing again. Suddenly, he whips the dagger at you, hitting you directly in the chest. You fall in pain, then all goes dark.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You wake up, and look around. You're in a room now. What had happened? You remember the explosion, and then passing out.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right = new Node("You both head back into the forest, going to the rebels. After around an hour of walking, you hear the sound of people nearby.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right = new Node("A man walks into the room, smiling. \"You're finally back\", he says. \"Who are you?\", you ask. The man looks at you. \"Don't you remember me?\", he ask. \"No\", you reply.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right = new Node("Suddenly, an arrow streaks past you, hitting the old man directly in the chest. He gasps in pain, and stumbles to the ground. You look behind you, but don't see anyone.", "Run away", "Help the\nman");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right = new Node("\"Hmm, interesting\", the man says. \"Well, it will be safer if we can get to the rebels. I'm supposed to go help them now anyways.\" What is he talking about? \"What rebels?\", you ask.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right = new Node("You hear people's voices coming from outside the cave. You hear yet another scream. What if the attackers come here? You go and hide behind a bush, hoping they don't find you.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("The man just stares at you. \"Don't you know me?\", he asks.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left = new Node("\"Thank you so much\", you say. The man smiles. \"Now get yourself settled in. We have a lot to catch up on\", he says.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.right = new Node("You decide to decline his offer as you find him suspicious. \"No thanks\", you say. \"I'll be fine\".", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right = new Node("Nobody comes into the cave. You now need to decide whether to stay in the cave or go out and try to find some answers. The forest seems very dangerous, and you have enough food in the cave to stay here for a while.", "Stay in\nthe cave", "Explore outside");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.left.right.right.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("A man walks into the room. \"You're awake, finally\", he says. \"Where am I? Who are you?\", you ask. The man looks at you. \"Don't you remember me?\", he ask. \"No\", you reply.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right = new Node("\"Quick, hide\", the man whispers, running towards a bush. Suddenly, three men stand in your way. They raise their hands, which immediately start glowing. They're Warriors, but evil. You want to run away, but you also don't want to leave the man.", "Run away", "Stay");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right = new Node("The boy walks in. He smiles, and waves at you. \"Do you remember him?\", the man asks. \"I don't really remember anything\", you say.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.left = new Node("You turn and start running away from the scene. All of a sudden, you feel a sharp pain in your back. An arrow hit you. You fall to the ground.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right = new Node("You grab the man as he falls. \"I'm fine\", he mutters. Suddenly, a man walks up behind you, holding a bow.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right = new Node("\"You'll see\", the man says, smiling. You have no other choice, but to follow him.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right = new Node("Nobody comes into the cave. You now need to decide whether to stay in the cave or go out and try to find some answers. The forest seems very dangerous, and you have enough food in the cave to stay here for a while.", "Stay in\nthe cave", "Explore outside");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"I don't really remember anything\", you reply. \"I woke up in the middle of this forest, and I can't remember anything before that\", you add.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left.right = new Node("The men around you lead you to a tent. You enter, and sit down on a makeshift bed inside. There's also some food for you on a table. You wonder what relationship you have with that man.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.right.right = new Node("\"But you just said you wanted to stay\", the man says. \"And besides, you can trust me. We've known each other for so long\".", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left = new Node("You decide to stay in the cave. It seems that you are safe here, for now. Though you have many questions, what matters most, you think, is your survival.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right = new Node("You peak outside and look around. There doesn't seem to be anyone outside, and the screams and voices have stopped. You leave the cave.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("The boy who you saw earlier walks in. He smiles, and waves at you. \"Do you remember him?\", the man asks. \"I don't really remember anything\", you say.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.left = new Node("You turn around, and run the other way. You take a different path, going around the fight. Then, you run in the direction you were originally going in.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You stay where you are. \"Run\", the man says. Suddenly, the Warriors start attacking. The man tries his best, but he couldn't take them all on at once. Within a few minutes, it was all over.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right.right = new Node("\"Who are you guys anyway?\", you ask. The man just stares at you. \"How do you not remember anything?\", he asks. Suddenly, your head starts hurting again. Whatever caused it probably made you lose your memory as well, you think.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.left.right = new Node("Another arrow hits you in the head, and all goes dark.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"Get away from us!\", you yell, not knowing what else to do. All of a sudden, there's a flash of light were the man was standing, and you hear a huge explosion. You look, and are shocked to see the burnt body of the man on the ground.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right = new Node("You both head back into the forest, going to the rebels. After around an hour of walking, you hear the sound of people nearby.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left = new Node("You decide to stay in the cave. It seems that you are safe here, for now. Though you have many questions, what matters most, you think, is your survival.", "", "Next");
        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.right = new Node("You peak outside and look around. There doesn't seem to be anyone outside, and the screams and voices have stopped. You leave the cave.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("The man walks away, chuckling to himself. \"Get a tent ready for him. He's staying with us\", he tells everyone.", "Accept\nhis offer", "Decline\nhis offer");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left.right.right = new Node("A few minutes later, the man enters your tent. \"So, let's get down to business\", he says. \"What do you mean?\", you ask.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right = new Node("\"Thanks, but I'll be on my way now. I really appreciate your offer though, you say, thinking he may be lying.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right = new Node("The next day...", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right = new Node("As soon as you step outside, an arrow flies and hits you directly on the chest. There's a sharp pain, then all goes dark.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"Who are you guys anyway?\", you ask. The man just stares at you. \"How do you not remember anything?\", he asks. Suddenly, your head starts hurting again. Whatever caused it probably made you lose your memory as well, you think.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.left.right = new Node("After running for a while, you come across a river. Are the rebels on the other side? You're not sure, but you still decide to swim across.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("The man falls to the ground. You turn to run, but are immediately hit by a Warrior's energy blast. There's a huge explosion, and all goes dark.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right = new Node("\"I got hurt on the head, and it probably knocked me out. I guess that's also why I can't remember anything\", you say.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right = new Node("GAME OVER", "", "");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You turn around, and see the old man with his hands raised. There's an unusual glow to them. \"What just happened\"?, you ask, shocked. The old man smiles. \"What can I say? I'm a Warrior\".", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right = new Node("\"Quick, hide\", the man whispers, running towards a bush. Suddenly, three men stand in your way. They raise their hands, which immediately start glowing. They're Warriors, but evil. You want to run away, but you also don't want to leave the man.", "Run away", "Stay");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right = new Node("The next day...", "", "Next");
        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.right.right = new Node("As soon as you step outside, an arrow flies and hits you directly on the chest. There's a sharp pain, then all goes dark.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.left = new Node("\"Thank you so much\", you say. The man smiles. \"Now get yourself settled in. We have a lot to catch up on\", he says.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You decide to decline his offer as you find him suspicious. \"No thanks\", you say. \"I'll be fine\".", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left.right.right.right = new Node("\"I need to, well, tell you about everything you've forgotten\", he says. \"Oh yes, please tell me\", you say, eager to learn about your past.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right = new Node("\"Very well\", he says. \"You can leave\". You nod, and start walking away. You hope to get away from them as fast as possible.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right = new Node("You wake up the next day to the sound of explosions coming from outside. The sounds are deafening. But you're deep inside the cave, and think there's no way any sound from outside should be this loud.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"I got hurt on the head, and it probably knocked me out. I guess that's also why I can't remember anything\", you say.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.left.right.right = new Node("There's a boy on the other side. He smiles as soon as he sees you, and runs towards you, waving. He seems to recognize you.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right = new Node("The man thinks for a moment. \"It all makes sense now\", he says. \"What does?\", you ask. The man smiles. \"Come outside\".", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("Suddenly, the man falls. He's lost too much blood. You try to help him. \"I can't really survive this\", he says. \"I'll help you\", you say.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.left = new Node("You turn around, and run the other way. You take a different path, going around the fight. Then, you run in the direction you were originally going in.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right = new Node("You stay where you are. \"Run\", the man says. Suddenly, the Warriors start attacking. The man tries his best, but he couldn't take them all on at once. Within a few minutes, it was all over.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right.right = new Node("You wake up the next day to the sound of explosions coming from outside. The sounds are deafening. But you're deep inside the cave, and think there's no way any sound from outside should be this loud.", "", "Next");
        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.left.right = new Node("The men around you lead you to a tent. You enter, and sit down on a makeshift bed inside. There's also some food for you on a table. You wonder what relationship you have with that man.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"But you just said you wanted to stay\", the man says. \"And besides, you can trust me. We've known each other for so long\".", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left.right.right.right.right = new Node("\"You see, we are actually fighters. There are some very evil people out here, and our job is to fight them\", he says. \"I don't understand\", you reply.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You keep walking, hoping to find a shelter. The sun is starting to rise now. But why are you here? Who killed that person you saw? And who were those people in the camp? Your head starts spinning again.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right = new Node("You start slowly walking towards the entrance of the cave. You can hear the sounds of people yelling. But they're quickly dwarfed by the unnaturally loud explosions. You're curious to know what's happening outside, but it seems dangerous to go out.", "Go outside", "Stay in\nthe cave");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("The man thinks for a moment. \"It all makes sense now\", he says. \"What does?\", you ask. The man smiles. \"Come outside\".", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.left.right.right.right = new Node("Before you can react, he grabs you by the arm. and takes you deeper in the forest. A few minutes later, you see what looks like an army camp. You seem to be in the right place.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You follow him and the boy outside. There's many people outside with weapons, training.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"No. The Hunters are going to come here after hearing the explosion\". He points towards a path. \"Go that way. Keep going until you get to a river. Cross it, and you'll meet people on the other side. People who can help you\", he says.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right = new Node("After running for a while, you come across a river. Are the rebels on the other side? You're not sure, but you still decide to swim across.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right = new Node("The man falls to the ground. You turn to run, but are immediately hit by a Warrior's energy blast. There's a huge explosion, and all goes dark.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right.right.right = new Node("You start slowly walking towards the entrance of the cave. You can hear the sounds of people yelling. But they're quickly dwarfed by the unnaturally loud explosions. You're curious to know what's happening outside, but it seems dangerous to go out.", "Go outside", "Stay in\nthe cave");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.left.right.right = new Node("A few minutes later, the man enters your tent. \"So, let's get down to business\", he says. \"What do you mean?\", you ask.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"Thanks, but I'll be on my way now. I really appreciate your offer though, you say, thinking he may be lying.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left.right.right.right.right.right = new Node("\"These people rule the entire world\", he continues. \"And they kill off anyone who stands against them. No one is free or safe under their regime. And we're the last hope for the people\".", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("After walking for a few more hours, you see a cave. You barely have any energy left in you, so you decide to go inside.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.left = new Node("You walk outside, and are shocked at what you see. There's people everywhere, and they're fighting each other. Some have swords, some have bows, and then there's some people shooting out bursts of light with their hands, causing the explosions. You can't believe your eyes.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right = new Node("You head back deep into the cave, deciding to stay away from whatever's happening outside. You wait for the explosions to stop.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You follow him and the boy outside. There's many people outside with weapons, training. You suddenly feel tense. What if the person attacking you was working for them? But that makes no sense, they saved you from him.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right = new Node("The boy leads you to a hut, and leaves you there. It looked like he told you to wait there, but you're not sure. It seems like he can't talk.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"What are these people training for?\", you ask. \"We're rebels\", the man explains. \"We're going to overthrow the oppressive regime in power. And you're going to help us\".", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You hesitate, not knowing what to do. \"Go now!\", the man says. \"Don't worry about me\". \"Thank you for saving me\", you blurt out. \"That's my job as a Warrior\", he says. \"Now go\".", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right = new Node("There's a boy on the other side. He smiles as soon as he sees you, and runs towards you, waving. He seems to recognize you.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right.right.right.left = new Node("You walk outside, and are shocked at what you see. There's people everywhere, and they're fighting each other. Some have swords, some have bows, and then there's some people shooting out bursts of light with their hands, causing the explosions. You can't believe your eyes.", "", "Next");
        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right.right.right.right = new Node("You head back deep into the cave, deciding to stay away from whatever's happening outside. You wait for the explosions to stop.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.left.right.right.right = new Node("\"I need to, well, tell you about everything you've forgotten\", he says. \"Oh yes, please tell me\", you say, eager to learn about your past.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"Very well\", he says. \"You can leave\". You nod, and start walking away. You hope to get away from them as fast as possible.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right = new Node("You think, and remember the dead body you saw. \"I heard someone screaming, and when I went to go check it out, I saw a dead body. Could that person be a victim of these people?\", you ask.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("As you enter the cave, you feel a sharp pain in your back, and fall over in pain. Someone just shot an arrow at you. Your vision gets blurry, and the last thing you see is a figure walking towards you.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.left.right = new Node("You want to find out more, but it seems to dangerous to be outside in the middle of a warzone. You quickly turn around and start running back into the cave. Suddenly, you feel a sharp pain in your back. You scream and fall to the ground. An arrow hit you.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right.right = new Node("A few days later...", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"What are these people training for?\", you ask. \"We're rebels\", the man explains. \"We're going to overthrow the oppressive regime in power. And you're going to help us\".", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right.right = new Node("A man walks into the room, smiling. \"You're finally back\", he says. \"Who are you?\", you ask. The man looks at you. \"Don't you remember me?\", he ask. \"No\", you reply.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"Me?\", you ask, surprised. \"Yes\", the man said. \"In fact\", he continues, \"you're going to lead us\". You stare at him, thinking he might be crazy.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You start walking in the direction he told you. You're head's spinning, and you can barely think straight. But you have to get to those people the man was talking about.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right = new Node("Before you can react, he grabs you by the arm. and takes you deeper in the forest. A few minutes later, you see what looks like an army camp. You seem to be in the right place.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right.right.right.left.right = new Node("You want to find out more, but it seems to dangerous to be outside in the middle of a warzone. You quickly turn around and start running back into the cave. Suddenly, you feel a sharp pain in your back. You scream and fall to the ground. An arrow hit you.", "", "Next");
        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right.right.right.right.right = new Node("A few days later...", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right = new Node("\"You see, we are actually fighters. There are some very evil people out here, and our job is to fight them\", he says. \"I don't understand\", you reply.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You keep walking, hoping to find a shelter. The sun is starting to rise now. But why are you here? Who killed that person you saw? And who were those people in the camp? Your head starts spinning again.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right = new Node("The man looks at you grimly. \"Most likely, yes\", he replies. \"And, the thing is...\", he trails off. \"What?\", you ask.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.left.right.right = new Node("You get up, and try to get to the cave. Another arrow hits you on the head, and all goes dark.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right.right.right = new Node("You're sitting alone at the edge of the underground lake. You've had nothing to do over the past few days, and you feel like you're going crazy. The explosions had gotten less intense over time.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"Me?\", you ask, surprised. \"Yes\", the man said. \"In fact\", he continues, \"you're going to lead us\". You stare at him, thinking he might be crazy.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right.right.right = new Node("The boy walks in. He smiles, and waves at you. \"Do you remember him?\", the man asks. \"I don't really remember anything\", you say.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"W-What do you mean?\", you asked, shocked. He takes you to a group of people training.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You remember how he saved you, and how you couldn't help him. Maybe those people he was talking about can help him. You quicken your pace, trying to get there as fast as you can.", "", "Next");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right = new Node("The boy leads you to a hut, and leaves you there. It looked like he told you to wait there, but you're not sure. It seems like he can't talk.", "", "Next");

        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right.right.right.left.right.right = new Node("You get up, and try to get to the cave. Another arrow hits you on the head, and all goes dark.", "", "Next");
        tree.root.left.right.left.left.right.left.right.right.right.right.right.right.left.right.right.right.right.right.left.right.right.right.right.right.right = new Node("You're sitting alone at the edge of the underground lake. You've had nothing to do over the past few days, and you feel like you're going crazy. The explosions had gotten less intense over time.", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right.right = new Node("\"These people rule the entire world\", he continues. \"And they kill off anyone who stands against them. No one is free or safe under their regime. And we're the last hope for the people\".", "", "Next");
        tree.root.left.right.left.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("After walking for a few more hours, you see a cave. You barely have any energy left in you, so you decide to go inside.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right = new Node("\"Well you see, there was a time when things weren't so bad. We used to have a good king, and people lived happily and freely under him. Of course, he was overthrown by our... current rulers\", he says.", "", "Next");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.left.right.right.right = new Node("GAME OVER", "", "");
        tree.root.left.right.right.left.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right = new Node("The explosions and voices kept on growing quieter and less frequent. Suddenly, you look around you, and hear something you've never heard before. Complete silence.", "", "Next");
        tree.root.left.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("\"W-What do you mean?\", you asked, shocked. He takes you to a group of people training.", "", "Next");
        tree.root.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right = new Node("\"Who are you guys anyway?\", you ask. The man just stares at you. \"How do you not remember anything?\", he asks. Suddenly, your head starts hurting again. Whatever caused it probably made you lose your memory as well, you think.", "", "Next");
        tree.root.left.right.right.right.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("You see that these people are like the boy. Some of them can shoot energy blasts from their hands, while others can also fly.", "", "Next");
        tree.root.right.right.right.left.right.left.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new Node("Suddenly, two figures appear in front of you, blocking your path. \"Going somewhere?\", one of them asks.", "Run the\nother way", "Fight them");
        tree.root.right.right.right.left.right.right.right.right.left.right.right.right.right.right.right.right.right.right.right.left.right.right.right.right.right = new Node("A man walks into the room, smiling. \"You're finally back\", he says. \"Who are you?\", you ask. The man looks at you. \"Don't you remember me?\", he ask. \"No\", you reply.", "", "Next");

        newTree.root = tree.root;
        setContentView(R.layout.activity_game);
        /*
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tree);
        prefsEditor.putString("MyObject", json);
        prefsEditor.commit();
        */
    }

    public void rightClick(View view){
        TypingEffect tv1 = (TypingEffect)findViewById(R.id.textView2);
        Button buttonRight = (Button)findViewById(R.id.button2);
        if (buttonRight.getText().toString().equals("Yes")) {
            tree.root = newTree.root;
        }
        else {
            tree.root = tree.root.right;
        }

        tv1.setText("");
        tv1.setCharacterDelay(25);
        tv1.animateText(tree.root.text);

        if (!tree.root.rightButton.equals("")) {
            buttonRight.setVisibility(View.VISIBLE);
            buttonRight.setText(tree.root.rightButton);
        }
        else {
            buttonRight.setVisibility(View.GONE);
        }

        Button buttonLeft = (Button)findViewById(R.id.button3);
        if (!tree.root.leftButton.equals("")) {
            buttonLeft.setVisibility(View.VISIBLE);
            buttonLeft.setText(tree.root.leftButton);
        }
        else {
            buttonLeft.setVisibility(View.GONE);
        }

        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tree);
        prefsEditor.putString("MyObject", json);
        prefsEditor.apply();
    }

    public void leftClick(View view){
        TypingEffect tv1 = (TypingEffect)findViewById(R.id.textView2);
        Button buttonLeft = (Button)findViewById(R.id.button3);
        if (!buttonLeft.getText().toString().equals("No")) {
            tree.root = tree.root.left;
        }

        tv1.setText("");
        tv1.setCharacterDelay(25);
        tv1.animateText(tree.root.text);

        Button buttonRight = (Button)findViewById(R.id.button2);
        if (!tree.root.rightButton.equals("")) {
            buttonRight.setVisibility(View.VISIBLE);
            buttonRight.setText(tree.root.rightButton);
        }
        else {
            buttonRight.setVisibility(View.GONE);
        }

        if (!tree.root.leftButton.equals("")) {
            buttonLeft.setVisibility(View.VISIBLE);
            buttonLeft.setText(tree.root.leftButton);
        }
        else {
            buttonLeft.setVisibility(View.GONE);
        }

        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tree);
        prefsEditor.putString("MyObject", json);
        prefsEditor.apply();
    }

    @SuppressLint("SetTextI18n")
    public void restart(View view) {
        TypingEffect tv1 = (TypingEffect)findViewById(R.id.textView2);
        tv1.setText("");
        tv1.setCharacterDelay(25);
        tv1.animateText("Are you sure you'd like to restart?");

        Button buttonRight = (Button)findViewById(R.id.button2);
        buttonRight.setVisibility(View.VISIBLE);
        buttonRight.setText("Yes");

        Button buttonLeft = (Button)findViewById(R.id.button3);
        buttonLeft.setVisibility(View.VISIBLE);
        buttonLeft.setText("No");

        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tree);
        prefsEditor.putString("MyObject", json);
        prefsEditor.apply();
    }

    @Override
    protected void onResume() {

        super.onResume();
        Gson gson = new Gson();
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        String json = mPrefs.getString("MyObject", "");
        tree = gson.fromJson(json, BinaryTree.class);
        TypingEffect tv1 = (TypingEffect)findViewById(R.id.textView2);
        tv1.setText("");
        tv1.setCharacterDelay(25);
        tv1.animateText(tree.root.text);

        Button buttonRight = (Button)findViewById(R.id.button2);
        if (!tree.root.rightButton.equals("")) {
            buttonRight.setVisibility(View.VISIBLE);
            buttonRight.setText(tree.root.rightButton);
        }
        else {
            buttonRight.setVisibility(View.GONE);
        }

        Button buttonLeft = (Button)findViewById(R.id.button3);
        if (!tree.root.leftButton.equals("")) {
            buttonLeft.setVisibility(View.VISIBLE);
            buttonLeft.setText(tree.root.leftButton);
        }
        else {
            buttonLeft.setVisibility(View.GONE);
        }
    }

/*
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tree);
        prefsEditor.putString("MyObject", json);
        prefsEditor.apply();
    }
*/
}