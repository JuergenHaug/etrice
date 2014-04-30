package org.eclipse.etrice.core.etphys.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.etrice.core.etphys.services.ETPhysGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalETPhysParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_HEX", "RULE_INT", "RULE_EXP", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Thread'", "'+'", "'-'", "'model'", "'mandatory'", "'false'", "'polled'", "'blocked'", "'mixed'", "'singleThreaded'", "'multiThreaded'", "'ptBoolean'", "'ptInteger'", "'ptReal'", "'ptCharacter'", "'PhysicalModel'", "'{'", "'}'", "'PhysicalSystem'", "'NodeRef'", "':'", "'NodeClass'", "'runtime'", "'='", "'priomin'", "'priomax'", "'execmode'", "'interval'", "'prio'", "'stacksize'", "'msgblocksize'", "'msgpoolsize'", "'RuntimeClass'", "'import'", "'from'", "'.*'", "'.'", "'attribute'", "','", "'['", "']'", "'s'", "'ms'", "'us'", "'ns'", "'DefaultThread'", "'optional'", "'true'"
    };
    public static final int RULE_EXP=7;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=5;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=8;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalETPhysParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalETPhysParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalETPhysParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g"; }


     
     	private ETPhysGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ETPhysGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRulePhysicalModel"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:60:1: entryRulePhysicalModel : rulePhysicalModel EOF ;
    public final void entryRulePhysicalModel() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:61:1: ( rulePhysicalModel EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:62:1: rulePhysicalModel EOF
            {
             before(grammarAccess.getPhysicalModelRule()); 
            pushFollow(FOLLOW_rulePhysicalModel_in_entryRulePhysicalModel61);
            rulePhysicalModel();

            state._fsp--;

             after(grammarAccess.getPhysicalModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePhysicalModel"


    // $ANTLR start "rulePhysicalModel"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:69:1: rulePhysicalModel : ( ( rule__PhysicalModel__Group__0 ) ) ;
    public final void rulePhysicalModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:73:2: ( ( ( rule__PhysicalModel__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:74:1: ( ( rule__PhysicalModel__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:74:1: ( ( rule__PhysicalModel__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:75:1: ( rule__PhysicalModel__Group__0 )
            {
             before(grammarAccess.getPhysicalModelAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:76:1: ( rule__PhysicalModel__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:76:2: rule__PhysicalModel__Group__0
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__0_in_rulePhysicalModel94);
            rule__PhysicalModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicalModel"


    // $ANTLR start "entryRulePhysicalSystem"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:88:1: entryRulePhysicalSystem : rulePhysicalSystem EOF ;
    public final void entryRulePhysicalSystem() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:89:1: ( rulePhysicalSystem EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:90:1: rulePhysicalSystem EOF
            {
             before(grammarAccess.getPhysicalSystemRule()); 
            pushFollow(FOLLOW_rulePhysicalSystem_in_entryRulePhysicalSystem121);
            rulePhysicalSystem();

            state._fsp--;

             after(grammarAccess.getPhysicalSystemRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalSystem128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePhysicalSystem"


    // $ANTLR start "rulePhysicalSystem"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:97:1: rulePhysicalSystem : ( ( rule__PhysicalSystem__Group__0 ) ) ;
    public final void rulePhysicalSystem() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:101:2: ( ( ( rule__PhysicalSystem__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:102:1: ( ( rule__PhysicalSystem__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:102:1: ( ( rule__PhysicalSystem__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:103:1: ( rule__PhysicalSystem__Group__0 )
            {
             before(grammarAccess.getPhysicalSystemAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:104:1: ( rule__PhysicalSystem__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:104:2: rule__PhysicalSystem__Group__0
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__0_in_rulePhysicalSystem154);
            rule__PhysicalSystem__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalSystemAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicalSystem"


    // $ANTLR start "entryRuleNodeRef"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:116:1: entryRuleNodeRef : ruleNodeRef EOF ;
    public final void entryRuleNodeRef() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:117:1: ( ruleNodeRef EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:118:1: ruleNodeRef EOF
            {
             before(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef181);
            ruleNodeRef();

            state._fsp--;

             after(grammarAccess.getNodeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNodeRef"


    // $ANTLR start "ruleNodeRef"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:125:1: ruleNodeRef : ( ( rule__NodeRef__Group__0 ) ) ;
    public final void ruleNodeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:129:2: ( ( ( rule__NodeRef__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:130:1: ( ( rule__NodeRef__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:130:1: ( ( rule__NodeRef__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:131:1: ( rule__NodeRef__Group__0 )
            {
             before(grammarAccess.getNodeRefAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:132:1: ( rule__NodeRef__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:132:2: rule__NodeRef__Group__0
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef214);
            rule__NodeRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeRef"


    // $ANTLR start "entryRuleNodeClass"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:144:1: entryRuleNodeClass : ruleNodeClass EOF ;
    public final void entryRuleNodeClass() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:145:1: ( ruleNodeClass EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:146:1: ruleNodeClass EOF
            {
             before(grammarAccess.getNodeClassRule()); 
            pushFollow(FOLLOW_ruleNodeClass_in_entryRuleNodeClass241);
            ruleNodeClass();

            state._fsp--;

             after(grammarAccess.getNodeClassRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeClass248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNodeClass"


    // $ANTLR start "ruleNodeClass"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:153:1: ruleNodeClass : ( ( rule__NodeClass__Group__0 ) ) ;
    public final void ruleNodeClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:157:2: ( ( ( rule__NodeClass__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:158:1: ( ( rule__NodeClass__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:158:1: ( ( rule__NodeClass__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:159:1: ( rule__NodeClass__Group__0 )
            {
             before(grammarAccess.getNodeClassAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:160:1: ( rule__NodeClass__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:160:2: rule__NodeClass__Group__0
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__0_in_ruleNodeClass274);
            rule__NodeClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeClass"


    // $ANTLR start "entryRulePhysicalThread"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:172:1: entryRulePhysicalThread : rulePhysicalThread EOF ;
    public final void entryRulePhysicalThread() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:173:1: ( rulePhysicalThread EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:174:1: rulePhysicalThread EOF
            {
             before(grammarAccess.getPhysicalThreadRule()); 
            pushFollow(FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread301);
            rulePhysicalThread();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhysicalThread308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePhysicalThread"


    // $ANTLR start "rulePhysicalThread"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:181:1: rulePhysicalThread : ( ( rule__PhysicalThread__Group__0 ) ) ;
    public final void rulePhysicalThread() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:185:2: ( ( ( rule__PhysicalThread__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:186:1: ( ( rule__PhysicalThread__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:186:1: ( ( rule__PhysicalThread__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:187:1: ( rule__PhysicalThread__Group__0 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:188:1: ( rule__PhysicalThread__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:188:2: rule__PhysicalThread__Group__0
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__0_in_rulePhysicalThread334);
            rule__PhysicalThread__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhysicalThread"


    // $ANTLR start "entryRuleRuntimeClass"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:200:1: entryRuleRuntimeClass : ruleRuntimeClass EOF ;
    public final void entryRuleRuntimeClass() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:201:1: ( ruleRuntimeClass EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:202:1: ruleRuntimeClass EOF
            {
             before(grammarAccess.getRuntimeClassRule()); 
            pushFollow(FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass361);
            ruleRuntimeClass();

            state._fsp--;

             after(grammarAccess.getRuntimeClassRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuntimeClass368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuntimeClass"


    // $ANTLR start "ruleRuntimeClass"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:209:1: ruleRuntimeClass : ( ( rule__RuntimeClass__Group__0 ) ) ;
    public final void ruleRuntimeClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:213:2: ( ( ( rule__RuntimeClass__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:214:1: ( ( rule__RuntimeClass__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:214:1: ( ( rule__RuntimeClass__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:215:1: ( rule__RuntimeClass__Group__0 )
            {
             before(grammarAccess.getRuntimeClassAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:216:1: ( rule__RuntimeClass__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:216:2: rule__RuntimeClass__Group__0
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__0_in_ruleRuntimeClass394);
            rule__RuntimeClass__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuntimeClassAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuntimeClass"


    // $ANTLR start "entryRulePRIO"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:228:1: entryRulePRIO : rulePRIO EOF ;
    public final void entryRulePRIO() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:232:1: ( rulePRIO EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:233:1: rulePRIO EOF
            {
             before(grammarAccess.getPRIORule()); 
            pushFollow(FOLLOW_rulePRIO_in_entryRulePRIO426);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getPRIORule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePRIO433); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRulePRIO"


    // $ANTLR start "rulePRIO"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:243:1: rulePRIO : ( ( rule__PRIO__Group__0 ) ) ;
    public final void rulePRIO() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:248:2: ( ( ( rule__PRIO__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:249:1: ( ( rule__PRIO__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:249:1: ( ( rule__PRIO__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:250:1: ( rule__PRIO__Group__0 )
            {
             before(grammarAccess.getPRIOAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:251:1: ( rule__PRIO__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:251:2: rule__PRIO__Group__0
            {
            pushFollow(FOLLOW_rule__PRIO__Group__0_in_rulePRIO463);
            rule__PRIO__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPRIOAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "rulePRIO"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:264:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:265:1: ( ruleImport EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:266:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport490);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport497); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:273:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:277:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:278:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:278:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:279:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:280:1: ( rule__Import__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:280:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport523);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:292:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:293:1: ( ruleImportedFQN EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:294:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN550);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportedFQN557); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:301:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:305:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:306:1: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:306:1: ( ( rule__ImportedFQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:307:1: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:308:1: ( rule__ImportedFQN__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:308:2: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN583);
            rule__ImportedFQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportedFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:320:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:321:1: ( ruleFQN EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:322:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN610);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN617); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:329:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:333:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:334:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:334:1: ( ( rule__FQN__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:335:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:336:1: ( rule__FQN__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:336:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN643);
            rule__FQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleKeyValue"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:350:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:351:1: ( ruleKeyValue EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:352:1: ruleKeyValue EOF
            {
             before(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_ruleKeyValue_in_entryRuleKeyValue672);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getKeyValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValue679); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKeyValue"


    // $ANTLR start "ruleKeyValue"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:359:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:363:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:364:1: ( ( rule__KeyValue__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:364:1: ( ( rule__KeyValue__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:365:1: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:366:1: ( rule__KeyValue__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:366:2: rule__KeyValue__Group__0
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0_in_ruleKeyValue705);
            rule__KeyValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleAnnotationTargetType"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:380:1: entryRuleAnnotationTargetType : ruleAnnotationTargetType EOF ;
    public final void entryRuleAnnotationTargetType() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:381:1: ( ruleAnnotationTargetType EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:382:1: ruleAnnotationTargetType EOF
            {
             before(grammarAccess.getAnnotationTargetTypeRule()); 
            pushFollow(FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType734);
            ruleAnnotationTargetType();

            state._fsp--;

             after(grammarAccess.getAnnotationTargetTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationTargetType741); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnnotationTargetType"


    // $ANTLR start "ruleAnnotationTargetType"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:389:1: ruleAnnotationTargetType : ( RULE_ID ) ;
    public final void ruleAnnotationTargetType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:393:2: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:394:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:394:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:395:1: RULE_ID
            {
             before(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotationTargetType767); 
             after(grammarAccess.getAnnotationTargetTypeAccess().getIDTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnnotationTargetType"


    // $ANTLR start "entryRuleAnnotationAttribute"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:408:1: entryRuleAnnotationAttribute : ruleAnnotationAttribute EOF ;
    public final void entryRuleAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:409:1: ( ruleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:410:1: ruleAnnotationAttribute EOF
            {
             before(grammarAccess.getAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute793);
            ruleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationAttribute800); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnnotationAttribute"


    // $ANTLR start "ruleAnnotationAttribute"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:417:1: ruleAnnotationAttribute : ( ( rule__AnnotationAttribute__Alternatives ) ) ;
    public final void ruleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:421:2: ( ( ( rule__AnnotationAttribute__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:422:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:422:1: ( ( rule__AnnotationAttribute__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:423:1: ( rule__AnnotationAttribute__Alternatives )
            {
             before(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:424:1: ( rule__AnnotationAttribute__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:424:2: rule__AnnotationAttribute__Alternatives
            {
            pushFollow(FOLLOW_rule__AnnotationAttribute__Alternatives_in_ruleAnnotationAttribute826);
            rule__AnnotationAttribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAttributeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnnotationAttribute"


    // $ANTLR start "entryRuleSimpleAnnotationAttribute"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:436:1: entryRuleSimpleAnnotationAttribute : ruleSimpleAnnotationAttribute EOF ;
    public final void entryRuleSimpleAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:437:1: ( ruleSimpleAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:438:1: ruleSimpleAnnotationAttribute EOF
            {
             before(grammarAccess.getSimpleAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute853);
            ruleSimpleAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getSimpleAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute860); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleAnnotationAttribute"


    // $ANTLR start "ruleSimpleAnnotationAttribute"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:445:1: ruleSimpleAnnotationAttribute : ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) ;
    public final void ruleSimpleAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:449:2: ( ( ( rule__SimpleAnnotationAttribute__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:450:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:450:1: ( ( rule__SimpleAnnotationAttribute__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:451:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:452:1: ( rule__SimpleAnnotationAttribute__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:452:2: rule__SimpleAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0_in_ruleSimpleAnnotationAttribute886);
            rule__SimpleAnnotationAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleAnnotationAttribute"


    // $ANTLR start "entryRuleEnumAnnotationAttribute"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:464:1: entryRuleEnumAnnotationAttribute : ruleEnumAnnotationAttribute EOF ;
    public final void entryRuleEnumAnnotationAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:465:1: ( ruleEnumAnnotationAttribute EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:466:1: ruleEnumAnnotationAttribute EOF
            {
             before(grammarAccess.getEnumAnnotationAttributeRule()); 
            pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute913);
            ruleEnumAnnotationAttribute();

            state._fsp--;

             after(grammarAccess.getEnumAnnotationAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute920); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumAnnotationAttribute"


    // $ANTLR start "ruleEnumAnnotationAttribute"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:473:1: ruleEnumAnnotationAttribute : ( ( rule__EnumAnnotationAttribute__Group__0 ) ) ;
    public final void ruleEnumAnnotationAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:477:2: ( ( ( rule__EnumAnnotationAttribute__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:478:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:478:1: ( ( rule__EnumAnnotationAttribute__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:479:1: ( rule__EnumAnnotationAttribute__Group__0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:480:1: ( rule__EnumAnnotationAttribute__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:480:2: rule__EnumAnnotationAttribute__Group__0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0_in_ruleEnumAnnotationAttribute946);
            rule__EnumAnnotationAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumAnnotationAttribute"


    // $ANTLR start "entryRuleDocumentation"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:492:1: entryRuleDocumentation : ruleDocumentation EOF ;
    public final void entryRuleDocumentation() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:493:1: ( ruleDocumentation EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:494:1: ruleDocumentation EOF
            {
             before(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_ruleDocumentation_in_entryRuleDocumentation973);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getDocumentationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentation980); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDocumentation"


    // $ANTLR start "ruleDocumentation"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:501:1: ruleDocumentation : ( ( rule__Documentation__Group__0 ) ) ;
    public final void ruleDocumentation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:505:2: ( ( ( rule__Documentation__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:506:1: ( ( rule__Documentation__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:506:1: ( ( rule__Documentation__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:507:1: ( rule__Documentation__Group__0 )
            {
             before(grammarAccess.getDocumentationAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:508:1: ( rule__Documentation__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:508:2: rule__Documentation__Group__0
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation1006);
            rule__Documentation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDocumentationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDocumentation"


    // $ANTLR start "entryRuleTIME"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:520:1: entryRuleTIME : ruleTIME EOF ;
    public final void entryRuleTIME() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:521:1: ( ruleTIME EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:522:1: ruleTIME EOF
            {
             before(grammarAccess.getTIMERule()); 
            pushFollow(FOLLOW_ruleTIME_in_entryRuleTIME1033);
            ruleTIME();

            state._fsp--;

             after(grammarAccess.getTIMERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTIME1040); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTIME"


    // $ANTLR start "ruleTIME"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:529:1: ruleTIME : ( ( rule__TIME__Alternatives ) ) ;
    public final void ruleTIME() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:533:2: ( ( ( rule__TIME__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:534:1: ( ( rule__TIME__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:534:1: ( ( rule__TIME__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:535:1: ( rule__TIME__Alternatives )
            {
             before(grammarAccess.getTIMEAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:536:1: ( rule__TIME__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:536:2: rule__TIME__Alternatives
            {
            pushFollow(FOLLOW_rule__TIME__Alternatives_in_ruleTIME1066);
            rule__TIME__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTIMEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTIME"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:550:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:551:1: ( ruleLiteral EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:552:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1095);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1102); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:559:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:563:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:564:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:564:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:565:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:566:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:566:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1128);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:578:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:579:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:580:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1155);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral1162); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:587:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__Group__0 ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:591:2: ( ( ( rule__BooleanLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:592:1: ( ( rule__BooleanLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:592:1: ( ( rule__BooleanLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:593:1: ( rule__BooleanLiteral__Group__0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:594:1: ( rule__BooleanLiteral__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:594:2: rule__BooleanLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral1188);
            rule__BooleanLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:606:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:607:1: ( ruleNumberLiteral EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:608:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1215);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral1222); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:615:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Alternatives ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:619:2: ( ( ( rule__NumberLiteral__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:620:1: ( ( rule__NumberLiteral__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:620:1: ( ( rule__NumberLiteral__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:621:1: ( rule__NumberLiteral__Alternatives )
            {
             before(grammarAccess.getNumberLiteralAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:622:1: ( rule__NumberLiteral__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:622:2: rule__NumberLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral1248);
            rule__NumberLiteral__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNumberLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:634:1: entryRuleRealLiteral : ruleRealLiteral EOF ;
    public final void entryRuleRealLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:635:1: ( ruleRealLiteral EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:636:1: ruleRealLiteral EOF
            {
             before(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1275);
            ruleRealLiteral();

            state._fsp--;

             after(grammarAccess.getRealLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral1282); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:643:1: ruleRealLiteral : ( ( rule__RealLiteral__Group__0 ) ) ;
    public final void ruleRealLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:647:2: ( ( ( rule__RealLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:648:1: ( ( rule__RealLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:648:1: ( ( rule__RealLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:649:1: ( rule__RealLiteral__Group__0 )
            {
             before(grammarAccess.getRealLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:650:1: ( rule__RealLiteral__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:650:2: rule__RealLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1308);
            rule__RealLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRealLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:662:1: entryRuleIntLiteral : ruleIntLiteral EOF ;
    public final void entryRuleIntLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:663:1: ( ruleIntLiteral EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:664:1: ruleIntLiteral EOF
            {
             before(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1335);
            ruleIntLiteral();

            state._fsp--;

             after(grammarAccess.getIntLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral1342); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:671:1: ruleIntLiteral : ( ( rule__IntLiteral__Group__0 ) ) ;
    public final void ruleIntLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:675:2: ( ( ( rule__IntLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:676:1: ( ( rule__IntLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:676:1: ( ( rule__IntLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:677:1: ( rule__IntLiteral__Group__0 )
            {
             before(grammarAccess.getIntLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:678:1: ( rule__IntLiteral__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:678:2: rule__IntLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1368);
            rule__IntLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:690:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:691:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:692:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1395);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1402); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:699:1: ruleStringLiteral : ( ( rule__StringLiteral__Group__0 ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:703:2: ( ( ( rule__StringLiteral__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:704:1: ( ( rule__StringLiteral__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:704:1: ( ( rule__StringLiteral__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:705:1: ( rule__StringLiteral__Group__0 )
            {
             before(grammarAccess.getStringLiteralAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:706:1: ( rule__StringLiteral__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:706:2: rule__StringLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1428);
            rule__StringLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleInteger"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:718:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:719:1: ( ruleInteger EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:720:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger1455);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger1462); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:727:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:731:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:732:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:732:1: ( ( rule__Integer__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:733:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:734:1: ( rule__Integer__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:734:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger1488);
            rule__Integer__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIntegerAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleSignedInteger"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:746:1: entryRuleSignedInteger : ruleSignedInteger EOF ;
    public final void entryRuleSignedInteger() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:750:1: ( ruleSignedInteger EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:751:1: ruleSignedInteger EOF
            {
             before(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1520);
            ruleSignedInteger();

            state._fsp--;

             after(grammarAccess.getSignedIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInteger1527); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleSignedInteger"


    // $ANTLR start "ruleSignedInteger"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:761:1: ruleSignedInteger : ( ( rule__SignedInteger__Group__0 ) ) ;
    public final void ruleSignedInteger() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:766:2: ( ( ( rule__SignedInteger__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:767:1: ( ( rule__SignedInteger__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:767:1: ( ( rule__SignedInteger__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:768:1: ( rule__SignedInteger__Group__0 )
            {
             before(grammarAccess.getSignedIntegerAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:769:1: ( rule__SignedInteger__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:769:2: rule__SignedInteger__Group__0
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1557);
            rule__SignedInteger__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSignedIntegerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleSignedInteger"


    // $ANTLR start "entryRuleHexadecimal"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:782:1: entryRuleHexadecimal : ruleHexadecimal EOF ;
    public final void entryRuleHexadecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:786:1: ( ruleHexadecimal EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:787:1: ruleHexadecimal EOF
            {
             before(grammarAccess.getHexadecimalRule()); 
            pushFollow(FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1589);
            ruleHexadecimal();

            state._fsp--;

             after(grammarAccess.getHexadecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexadecimal1596); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleHexadecimal"


    // $ANTLR start "ruleHexadecimal"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:797:1: ruleHexadecimal : ( RULE_HEX ) ;
    public final void ruleHexadecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:802:2: ( ( RULE_HEX ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:803:1: ( RULE_HEX )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:803:1: ( RULE_HEX )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:804:1: RULE_HEX
            {
             before(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 
            match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexadecimal1626); 
             after(grammarAccess.getHexadecimalAccess().getHEXTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleHexadecimal"


    // $ANTLR start "entryRuleReal"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:818:1: entryRuleReal : ruleReal EOF ;
    public final void entryRuleReal() throws RecognitionException {
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:819:1: ( ruleReal EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:820:1: ruleReal EOF
            {
             before(grammarAccess.getRealRule()); 
            pushFollow(FOLLOW_ruleReal_in_entryRuleReal1652);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReal1659); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReal"


    // $ANTLR start "ruleReal"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:827:1: ruleReal : ( ( rule__Real__Alternatives ) ) ;
    public final void ruleReal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:831:2: ( ( ( rule__Real__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:832:1: ( ( rule__Real__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:832:1: ( ( rule__Real__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:833:1: ( rule__Real__Alternatives )
            {
             before(grammarAccess.getRealAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:834:1: ( rule__Real__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:834:2: rule__Real__Alternatives
            {
            pushFollow(FOLLOW_rule__Real__Alternatives_in_ruleReal1685);
            rule__Real__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRealAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReal"


    // $ANTLR start "entryRuleDecimal"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:846:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:850:1: ( ruleDecimal EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:851:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_ruleDecimal_in_entryRuleDecimal1717);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimal1724); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDecimal"


    // $ANTLR start "ruleDecimal"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:861:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:866:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:867:1: ( ( rule__Decimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:867:1: ( ( rule__Decimal__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:868:1: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:869:1: ( rule__Decimal__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:869:2: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1754);
            rule__Decimal__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecimalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDecimal"


    // $ANTLR start "entryRuleDotDecimal"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:882:1: entryRuleDotDecimal : ruleDotDecimal EOF ;
    public final void entryRuleDotDecimal() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:886:1: ( ruleDotDecimal EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:887:1: ruleDotDecimal EOF
            {
             before(grammarAccess.getDotDecimalRule()); 
            pushFollow(FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1786);
            ruleDotDecimal();

            state._fsp--;

             after(grammarAccess.getDotDecimalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotDecimal1793); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDotDecimal"


    // $ANTLR start "ruleDotDecimal"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:897:1: ruleDotDecimal : ( ( rule__DotDecimal__Group__0 ) ) ;
    public final void ruleDotDecimal() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:902:2: ( ( ( rule__DotDecimal__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:903:1: ( ( rule__DotDecimal__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:903:1: ( ( rule__DotDecimal__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:904:1: ( rule__DotDecimal__Group__0 )
            {
             before(grammarAccess.getDotDecimalAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:905:1: ( rule__DotDecimal__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:905:2: rule__DotDecimal__Group__0
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1823);
            rule__DotDecimal__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDotDecimalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDotDecimal"


    // $ANTLR start "entryRuleDecimalDot"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:918:1: entryRuleDecimalDot : ruleDecimalDot EOF ;
    public final void entryRuleDecimalDot() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:922:1: ( ruleDecimalDot EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:923:1: ruleDecimalDot EOF
            {
             before(grammarAccess.getDecimalDotRule()); 
            pushFollow(FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1855);
            ruleDecimalDot();

            state._fsp--;

             after(grammarAccess.getDecimalDotRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalDot1862); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDecimalDot"


    // $ANTLR start "ruleDecimalDot"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:933:1: ruleDecimalDot : ( ( rule__DecimalDot__Group__0 ) ) ;
    public final void ruleDecimalDot() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:938:2: ( ( ( rule__DecimalDot__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:939:1: ( ( rule__DecimalDot__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:939:1: ( ( rule__DecimalDot__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:940:1: ( rule__DecimalDot__Group__0 )
            {
             before(grammarAccess.getDecimalDotAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:941:1: ( rule__DecimalDot__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:941:2: rule__DecimalDot__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1892);
            rule__DecimalDot__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecimalDotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDecimalDot"


    // $ANTLR start "entryRuleDecimalExp"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:954:1: entryRuleDecimalExp : ruleDecimalExp EOF ;
    public final void entryRuleDecimalExp() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:958:1: ( ruleDecimalExp EOF )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:959:1: ruleDecimalExp EOF
            {
             before(grammarAccess.getDecimalExpRule()); 
            pushFollow(FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1924);
            ruleDecimalExp();

            state._fsp--;

             after(grammarAccess.getDecimalExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalExp1931); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDecimalExp"


    // $ANTLR start "ruleDecimalExp"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:969:1: ruleDecimalExp : ( ( rule__DecimalExp__Group__0 ) ) ;
    public final void ruleDecimalExp() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:974:2: ( ( ( rule__DecimalExp__Group__0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:975:1: ( ( rule__DecimalExp__Group__0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:975:1: ( ( rule__DecimalExp__Group__0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:976:1: ( rule__DecimalExp__Group__0 )
            {
             before(grammarAccess.getDecimalExpAccess().getGroup()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:977:1: ( rule__DecimalExp__Group__0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:977:2: rule__DecimalExp__Group__0
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1961);
            rule__DecimalExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecimalExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDecimalExp"


    // $ANTLR start "ruleExecMode"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:991:1: ruleExecMode : ( ( rule__ExecMode__Alternatives ) ) ;
    public final void ruleExecMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:995:1: ( ( ( rule__ExecMode__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:996:1: ( ( rule__ExecMode__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:996:1: ( ( rule__ExecMode__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:997:1: ( rule__ExecMode__Alternatives )
            {
             before(grammarAccess.getExecModeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:998:1: ( rule__ExecMode__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:998:2: rule__ExecMode__Alternatives
            {
            pushFollow(FOLLOW_rule__ExecMode__Alternatives_in_ruleExecMode1998);
            rule__ExecMode__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExecModeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExecMode"


    // $ANTLR start "ruleThreadModel"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1010:1: ruleThreadModel : ( ( rule__ThreadModel__Alternatives ) ) ;
    public final void ruleThreadModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1014:1: ( ( ( rule__ThreadModel__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1015:1: ( ( rule__ThreadModel__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1015:1: ( ( rule__ThreadModel__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1016:1: ( rule__ThreadModel__Alternatives )
            {
             before(grammarAccess.getThreadModelAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1017:1: ( rule__ThreadModel__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1017:2: rule__ThreadModel__Alternatives
            {
            pushFollow(FOLLOW_rule__ThreadModel__Alternatives_in_ruleThreadModel2034);
            rule__ThreadModel__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getThreadModelAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleThreadModel"


    // $ANTLR start "ruleLiteralType"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1029:1: ruleLiteralType : ( ( rule__LiteralType__Alternatives ) ) ;
    public final void ruleLiteralType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1033:1: ( ( ( rule__LiteralType__Alternatives ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1034:1: ( ( rule__LiteralType__Alternatives ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1034:1: ( ( rule__LiteralType__Alternatives ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1035:1: ( rule__LiteralType__Alternatives )
            {
             before(grammarAccess.getLiteralTypeAccess().getAlternatives()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1036:1: ( rule__LiteralType__Alternatives )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1036:2: rule__LiteralType__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType2070);
            rule__LiteralType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralType"


    // $ANTLR start "rule__PhysicalModel__Alternatives_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1047:1: rule__PhysicalModel__Alternatives_4 : ( ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) ) | ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) ) | ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) ) );
    public final void rule__PhysicalModel__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1051:1: ( ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) ) | ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) ) | ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt1=1;
                }
                break;
            case 34:
                {
                alt1=2;
                }
                break;
            case 45:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1052:1: ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1052:1: ( ( rule__PhysicalModel__SystemsAssignment_4_0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1053:1: ( rule__PhysicalModel__SystemsAssignment_4_0 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getSystemsAssignment_4_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1054:1: ( rule__PhysicalModel__SystemsAssignment_4_0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1054:2: rule__PhysicalModel__SystemsAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__SystemsAssignment_4_0_in_rule__PhysicalModel__Alternatives_42105);
                    rule__PhysicalModel__SystemsAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalModelAccess().getSystemsAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1058:6: ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1058:6: ( ( rule__PhysicalModel__NodeClassesAssignment_4_1 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1059:1: ( rule__PhysicalModel__NodeClassesAssignment_4_1 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getNodeClassesAssignment_4_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1060:1: ( rule__PhysicalModel__NodeClassesAssignment_4_1 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1060:2: rule__PhysicalModel__NodeClassesAssignment_4_1
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__NodeClassesAssignment_4_1_in_rule__PhysicalModel__Alternatives_42123);
                    rule__PhysicalModel__NodeClassesAssignment_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalModelAccess().getNodeClassesAssignment_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1064:6: ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1064:6: ( ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1065:1: ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 )
                    {
                     before(grammarAccess.getPhysicalModelAccess().getRuntimeClassesAssignment_4_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1066:1: ( rule__PhysicalModel__RuntimeClassesAssignment_4_2 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1066:2: rule__PhysicalModel__RuntimeClassesAssignment_4_2
                    {
                    pushFollow(FOLLOW_rule__PhysicalModel__RuntimeClassesAssignment_4_2_in_rule__PhysicalModel__Alternatives_42141);
                    rule__PhysicalModel__RuntimeClassesAssignment_4_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalModelAccess().getRuntimeClassesAssignment_4_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Alternatives_4"


    // $ANTLR start "rule__PhysicalThread__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1075:1: rule__PhysicalThread__Alternatives_0 : ( ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) ) | ( 'Thread' ) );
    public final void rule__PhysicalThread__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1079:1: ( ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) ) | ( 'Thread' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==58) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1080:1: ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1080:1: ( ( rule__PhysicalThread__DefaultAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1081:1: ( rule__PhysicalThread__DefaultAssignment_0_0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getDefaultAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1082:1: ( rule__PhysicalThread__DefaultAssignment_0_0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1082:2: rule__PhysicalThread__DefaultAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__DefaultAssignment_0_0_in_rule__PhysicalThread__Alternatives_02174);
                    rule__PhysicalThread__DefaultAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getDefaultAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1086:6: ( 'Thread' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1086:6: ( 'Thread' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1087:1: 'Thread'
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getThreadKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__PhysicalThread__Alternatives_02193); 
                     after(grammarAccess.getPhysicalThreadAccess().getThreadKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Alternatives_0"


    // $ANTLR start "rule__PRIO__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1099:1: rule__PRIO__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__PRIO__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1103:1: ( ( '+' ) | ( '-' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1104:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1104:1: ( '+' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1105:1: '+'
                    {
                     before(grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__PRIO__Alternatives_02228); 
                     after(grammarAccess.getPRIOAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1112:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1112:6: ( '-' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1113:1: '-'
                    {
                     before(grammarAccess.getPRIOAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__PRIO__Alternatives_02248); 
                     after(grammarAccess.getPRIOAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Alternatives_0"


    // $ANTLR start "rule__Import__Alternatives_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1125:1: rule__Import__Alternatives_1 : ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) );
    public final void rule__Import__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1129:1: ( ( ( rule__Import__Group_1_0__0 ) ) | ( 'model' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==16) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1130:1: ( ( rule__Import__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1130:1: ( ( rule__Import__Group_1_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1131:1: ( rule__Import__Group_1_0__0 )
                    {
                     before(grammarAccess.getImportAccess().getGroup_1_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1132:1: ( rule__Import__Group_1_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1132:2: rule__Import__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_12282);
                    rule__Import__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1136:6: ( 'model' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1136:6: ( 'model' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1137:1: 'model'
                    {
                     before(grammarAccess.getImportAccess().getModelKeyword_1_1()); 
                    match(input,16,FOLLOW_16_in_rule__Import__Alternatives_12301); 
                     after(grammarAccess.getImportAccess().getModelKeyword_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Alternatives_1"


    // $ANTLR start "rule__AnnotationAttribute__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1150:1: rule__AnnotationAttribute__Alternatives : ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) );
    public final void rule__AnnotationAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1154:1: ( ( ruleSimpleAnnotationAttribute ) | ( ruleEnumAnnotationAttribute ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==59) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==50) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==RULE_ID) ) {
                        int LA5_4 = input.LA(4);

                        if ( (LA5_4==33) ) {
                            int LA5_5 = input.LA(5);

                            if ( ((LA5_5>=24 && LA5_5<=27)) ) {
                                alt5=1;
                            }
                            else if ( (LA5_5==29) ) {
                                alt5=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA5_0==17) ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==50) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==RULE_ID) ) {
                        int LA5_4 = input.LA(4);

                        if ( (LA5_4==33) ) {
                            int LA5_5 = input.LA(5);

                            if ( ((LA5_5>=24 && LA5_5<=27)) ) {
                                alt5=1;
                            }
                            else if ( (LA5_5==29) ) {
                                alt5=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1155:1: ( ruleSimpleAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1155:1: ( ruleSimpleAnnotationAttribute )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1156:1: ruleSimpleAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives2336);
                    ruleSimpleAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getSimpleAnnotationAttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1161:6: ( ruleEnumAnnotationAttribute )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1161:6: ( ruleEnumAnnotationAttribute )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1162:1: ruleEnumAnnotationAttribute
                    {
                     before(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives2353);
                    ruleEnumAnnotationAttribute();

                    state._fsp--;

                     after(grammarAccess.getAnnotationAttributeAccess().getEnumAnnotationAttributeParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AnnotationAttribute__Alternatives"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1172:1: rule__SimpleAnnotationAttribute__Alternatives_0 : ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__SimpleAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1176:1: ( ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==59) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1177:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1177:1: ( ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1178:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1179:1: ( rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1179:2: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_02385);
                    rule__SimpleAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1183:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1183:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1184:1: 'mandatory'
                    {
                     before(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__SimpleAnnotationAttribute__Alternatives_02404); 
                     after(grammarAccess.getSimpleAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Alternatives_0"


    // $ANTLR start "rule__EnumAnnotationAttribute__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1196:1: rule__EnumAnnotationAttribute__Alternatives_0 : ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) );
    public final void rule__EnumAnnotationAttribute__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1200:1: ( ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) ) | ( 'mandatory' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==59) ) {
                alt7=1;
            }
            else if ( (LA7_0==17) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1201:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1201:1: ( ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1202:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1203:1: ( rule__EnumAnnotationAttribute__OptionalAssignment_0_0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1203:2: rule__EnumAnnotationAttribute__OptionalAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_02438);
                    rule__EnumAnnotationAttribute__OptionalAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1207:6: ( 'mandatory' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1207:6: ( 'mandatory' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1208:1: 'mandatory'
                    {
                     before(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__EnumAnnotationAttribute__Alternatives_02457); 
                     after(grammarAccess.getEnumAnnotationAttributeAccess().getMandatoryKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Alternatives_0"


    // $ANTLR start "rule__TIME__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1220:1: rule__TIME__Alternatives : ( ( ( rule__TIME__Group_0__0 ) ) | ( ( rule__TIME__Group_1__0 ) ) | ( ( rule__TIME__Group_2__0 ) ) | ( ( rule__TIME__Group_3__0 ) ) );
    public final void rule__TIME__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1224:1: ( ( ( rule__TIME__Group_0__0 ) ) | ( ( rule__TIME__Group_1__0 ) ) | ( ( rule__TIME__Group_2__0 ) ) | ( ( rule__TIME__Group_3__0 ) ) )
            int alt8=4;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 55:
                    {
                    alt8=2;
                    }
                    break;
                case 54:
                    {
                    alt8=1;
                    }
                    break;
                case 57:
                    {
                    alt8=4;
                    }
                    break;
                case 56:
                    {
                    alt8=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1225:1: ( ( rule__TIME__Group_0__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1225:1: ( ( rule__TIME__Group_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1226:1: ( rule__TIME__Group_0__0 )
                    {
                     before(grammarAccess.getTIMEAccess().getGroup_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1227:1: ( rule__TIME__Group_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1227:2: rule__TIME__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__TIME__Group_0__0_in_rule__TIME__Alternatives2491);
                    rule__TIME__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTIMEAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1231:6: ( ( rule__TIME__Group_1__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1231:6: ( ( rule__TIME__Group_1__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1232:1: ( rule__TIME__Group_1__0 )
                    {
                     before(grammarAccess.getTIMEAccess().getGroup_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1233:1: ( rule__TIME__Group_1__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1233:2: rule__TIME__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TIME__Group_1__0_in_rule__TIME__Alternatives2509);
                    rule__TIME__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTIMEAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1237:6: ( ( rule__TIME__Group_2__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1237:6: ( ( rule__TIME__Group_2__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1238:1: ( rule__TIME__Group_2__0 )
                    {
                     before(grammarAccess.getTIMEAccess().getGroup_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1239:1: ( rule__TIME__Group_2__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1239:2: rule__TIME__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__TIME__Group_2__0_in_rule__TIME__Alternatives2527);
                    rule__TIME__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTIMEAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1243:6: ( ( rule__TIME__Group_3__0 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1243:6: ( ( rule__TIME__Group_3__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1244:1: ( rule__TIME__Group_3__0 )
                    {
                     before(grammarAccess.getTIMEAccess().getGroup_3()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1245:1: ( rule__TIME__Group_3__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1245:2: rule__TIME__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__TIME__Group_3__0_in_rule__TIME__Alternatives2545);
                    rule__TIME__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTIMEAccess().getGroup_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1254:1: rule__Literal__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1258:1: ( ( ruleBooleanLiteral ) | ( ruleNumberLiteral ) | ( ruleStringLiteral ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 18:
            case 60:
                {
                alt9=1;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case 14:
            case 15:
            case 49:
                {
                alt9=2;
                }
                break;
            case RULE_STRING:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1259:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1259:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1260:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives2578);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1265:6: ( ruleNumberLiteral )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1265:6: ( ruleNumberLiteral )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1266:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2595);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1271:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1271:6: ( ruleStringLiteral )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1272:1: ruleStringLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2612);
                    ruleStringLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__BooleanLiteral__Alternatives_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1282:1: rule__BooleanLiteral__Alternatives_1 : ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) );
    public final void rule__BooleanLiteral__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1286:1: ( ( 'false' ) | ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==60) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1287:1: ( 'false' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1287:1: ( 'false' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1288:1: 'false'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 
                    match(input,18,FOLLOW_18_in_rule__BooleanLiteral__Alternatives_12645); 
                     after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1295:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1295:6: ( ( rule__BooleanLiteral__IsTrueAssignment_1_1 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1296:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1297:1: ( rule__BooleanLiteral__IsTrueAssignment_1_1 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1297:2: rule__BooleanLiteral__IsTrueAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12664);
                    rule__BooleanLiteral__IsTrueAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Alternatives_1"


    // $ANTLR start "rule__NumberLiteral__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1306:1: rule__NumberLiteral__Alternatives : ( ( ruleIntLiteral ) | ( ruleRealLiteral ) );
    public final void rule__NumberLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1310:1: ( ( ruleIntLiteral ) | ( ruleRealLiteral ) )
            int alt11=2;
            switch ( input.LA(1) ) {
            case 14:
                {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==49) ) {
                    alt11=2;
                }
                else if ( (LA11_1==RULE_INT) ) {
                    int LA11_3 = input.LA(3);

                    if ( (LA11_3==49) ) {
                        alt11=2;
                    }
                    else if ( (LA11_3==EOF) ) {
                        alt11=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==RULE_INT) ) {
                    int LA11_3 = input.LA(3);

                    if ( (LA11_3==49) ) {
                        alt11=2;
                    }
                    else if ( (LA11_3==EOF) ) {
                        alt11=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA11_2==49) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA11_3 = input.LA(2);

                if ( (LA11_3==49) ) {
                    alt11=2;
                }
                else if ( (LA11_3==EOF) ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_HEX:
                {
                alt11=1;
                }
                break;
            case 49:
                {
                alt11=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1311:1: ( ruleIntLiteral )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1311:1: ( ruleIntLiteral )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1312:1: ruleIntLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2697);
                    ruleIntLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getIntLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1317:6: ( ruleRealLiteral )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1317:6: ( ruleRealLiteral )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1318:1: ruleRealLiteral
                    {
                     before(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2714);
                    ruleRealLiteral();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralAccess().getRealLiteralParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__Alternatives"


    // $ANTLR start "rule__Integer__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1328:1: rule__Integer__Alternatives : ( ( ruleSignedInteger ) | ( ruleHexadecimal ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1332:1: ( ( ruleSignedInteger ) | ( ruleHexadecimal ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_INT||(LA12_0>=14 && LA12_0<=15)) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_HEX) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1333:1: ( ruleSignedInteger )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1333:1: ( ruleSignedInteger )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1334:1: ruleSignedInteger
                    {
                     before(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2746);
                    ruleSignedInteger();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getSignedIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1339:6: ( ruleHexadecimal )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1339:6: ( ruleHexadecimal )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1340:1: ruleHexadecimal
                    {
                     before(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2763);
                    ruleHexadecimal();

                    state._fsp--;

                     after(grammarAccess.getIntegerAccess().getHexadecimalParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__Alternatives"


    // $ANTLR start "rule__SignedInteger__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1350:1: rule__SignedInteger__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__SignedInteger__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1354:1: ( ( '+' ) | ( '-' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            else if ( (LA13_0==15) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1355:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1355:1: ( '+' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1356:1: '+'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__SignedInteger__Alternatives_02796); 
                     after(grammarAccess.getSignedIntegerAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1363:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1363:6: ( '-' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1364:1: '-'
                    {
                     before(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__SignedInteger__Alternatives_02816); 
                     after(grammarAccess.getSignedIntegerAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Alternatives_0"


    // $ANTLR start "rule__Real__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1376:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );
    public final void rule__Real__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1380:1: ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) )
            int alt14=4;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1381:1: ( ruleDecimal )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1381:1: ( ruleDecimal )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1382:1: ruleDecimal
                    {
                     before(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDecimal_in_rule__Real__Alternatives2850);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1387:6: ( ruleDotDecimal )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1387:6: ( ruleDotDecimal )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1388:1: ruleDotDecimal
                    {
                     before(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2867);
                    ruleDotDecimal();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDotDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1393:6: ( ruleDecimalDot )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1393:6: ( ruleDecimalDot )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1394:1: ruleDecimalDot
                    {
                     before(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2884);
                    ruleDecimalDot();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalDotParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1399:6: ( ruleDecimalExp )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1399:6: ( ruleDecimalExp )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1400:1: ruleDecimalExp
                    {
                     before(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2901);
                    ruleDecimalExp();

                    state._fsp--;

                     after(grammarAccess.getRealAccess().getDecimalExpParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Real__Alternatives"


    // $ANTLR start "rule__Decimal__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1410:1: rule__Decimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__Decimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1414:1: ( ( '+' ) | ( '-' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            else if ( (LA15_0==15) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1415:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1415:1: ( '+' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1416:1: '+'
                    {
                     before(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__Decimal__Alternatives_02934); 
                     after(grammarAccess.getDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1423:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1423:6: ( '-' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1424:1: '-'
                    {
                     before(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__Decimal__Alternatives_02954); 
                     after(grammarAccess.getDecimalAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Alternatives_0"


    // $ANTLR start "rule__DotDecimal__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1436:1: rule__DotDecimal__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DotDecimal__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1440:1: ( ( '+' ) | ( '-' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            else if ( (LA16_0==15) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1441:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1441:1: ( '+' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1442:1: '+'
                    {
                     before(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__DotDecimal__Alternatives_02989); 
                     after(grammarAccess.getDotDecimalAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1449:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1449:6: ( '-' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1450:1: '-'
                    {
                     before(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__DotDecimal__Alternatives_03009); 
                     after(grammarAccess.getDotDecimalAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Alternatives_0"


    // $ANTLR start "rule__DecimalDot__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1462:1: rule__DecimalDot__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalDot__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1466:1: ( ( '+' ) | ( '-' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            else if ( (LA17_0==15) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1467:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1467:1: ( '+' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1468:1: '+'
                    {
                     before(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__DecimalDot__Alternatives_03044); 
                     after(grammarAccess.getDecimalDotAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1475:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1475:6: ( '-' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1476:1: '-'
                    {
                     before(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalDot__Alternatives_03064); 
                     after(grammarAccess.getDecimalDotAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Alternatives_0"


    // $ANTLR start "rule__DecimalExp__Alternatives_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1488:1: rule__DecimalExp__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__DecimalExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1492:1: ( ( '+' ) | ( '-' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==14) ) {
                alt18=1;
            }
            else if ( (LA18_0==15) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1493:1: ( '+' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1493:1: ( '+' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1494:1: '+'
                    {
                     before(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__DecimalExp__Alternatives_03099); 
                     after(grammarAccess.getDecimalExpAccess().getPlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1501:6: ( '-' )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1501:6: ( '-' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1502:1: '-'
                    {
                     before(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__DecimalExp__Alternatives_03119); 
                     after(grammarAccess.getDecimalExpAccess().getHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Alternatives_0"


    // $ANTLR start "rule__ExecMode__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1514:1: rule__ExecMode__Alternatives : ( ( ( 'polled' ) ) | ( ( 'blocked' ) ) | ( ( 'mixed' ) ) );
    public final void rule__ExecMode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1518:1: ( ( ( 'polled' ) ) | ( ( 'blocked' ) ) | ( ( 'mixed' ) ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt19=1;
                }
                break;
            case 20:
                {
                alt19=2;
                }
                break;
            case 21:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1519:1: ( ( 'polled' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1519:1: ( ( 'polled' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1520:1: ( 'polled' )
                    {
                     before(grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1521:1: ( 'polled' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1521:3: 'polled'
                    {
                    match(input,19,FOLLOW_19_in_rule__ExecMode__Alternatives3154); 

                    }

                     after(grammarAccess.getExecModeAccess().getPOLLEDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1526:6: ( ( 'blocked' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1526:6: ( ( 'blocked' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1527:1: ( 'blocked' )
                    {
                     before(grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1528:1: ( 'blocked' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1528:3: 'blocked'
                    {
                    match(input,20,FOLLOW_20_in_rule__ExecMode__Alternatives3175); 

                    }

                     after(grammarAccess.getExecModeAccess().getBLOCKEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1533:6: ( ( 'mixed' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1533:6: ( ( 'mixed' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1534:1: ( 'mixed' )
                    {
                     before(grammarAccess.getExecModeAccess().getMIXEDEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1535:1: ( 'mixed' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1535:3: 'mixed'
                    {
                    match(input,21,FOLLOW_21_in_rule__ExecMode__Alternatives3196); 

                    }

                     after(grammarAccess.getExecModeAccess().getMIXEDEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecMode__Alternatives"


    // $ANTLR start "rule__ThreadModel__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1545:1: rule__ThreadModel__Alternatives : ( ( ( 'singleThreaded' ) ) | ( ( 'multiThreaded' ) ) );
    public final void rule__ThreadModel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1549:1: ( ( ( 'singleThreaded' ) ) | ( ( 'multiThreaded' ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                alt20=1;
            }
            else if ( (LA20_0==23) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1550:1: ( ( 'singleThreaded' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1550:1: ( ( 'singleThreaded' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1551:1: ( 'singleThreaded' )
                    {
                     before(grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1552:1: ( 'singleThreaded' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1552:3: 'singleThreaded'
                    {
                    match(input,22,FOLLOW_22_in_rule__ThreadModel__Alternatives3232); 

                    }

                     after(grammarAccess.getThreadModelAccess().getSINGLE_THREADEDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1557:6: ( ( 'multiThreaded' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1557:6: ( ( 'multiThreaded' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1558:1: ( 'multiThreaded' )
                    {
                     before(grammarAccess.getThreadModelAccess().getMULTI_THREADEDEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1559:1: ( 'multiThreaded' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1559:3: 'multiThreaded'
                    {
                    match(input,23,FOLLOW_23_in_rule__ThreadModel__Alternatives3253); 

                    }

                     after(grammarAccess.getThreadModelAccess().getMULTI_THREADEDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ThreadModel__Alternatives"


    // $ANTLR start "rule__LiteralType__Alternatives"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1569:1: rule__LiteralType__Alternatives : ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) );
    public final void rule__LiteralType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1573:1: ( ( ( 'ptBoolean' ) ) | ( ( 'ptInteger' ) ) | ( ( 'ptReal' ) ) | ( ( 'ptCharacter' ) ) )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt21=1;
                }
                break;
            case 25:
                {
                alt21=2;
                }
                break;
            case 26:
                {
                alt21=3;
                }
                break;
            case 27:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1574:1: ( ( 'ptBoolean' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1574:1: ( ( 'ptBoolean' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1575:1: ( 'ptBoolean' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1576:1: ( 'ptBoolean' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1576:3: 'ptBoolean'
                    {
                    match(input,24,FOLLOW_24_in_rule__LiteralType__Alternatives3289); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getBOOLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1581:6: ( ( 'ptInteger' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1581:6: ( ( 'ptInteger' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1582:1: ( 'ptInteger' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1583:1: ( 'ptInteger' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1583:3: 'ptInteger'
                    {
                    match(input,25,FOLLOW_25_in_rule__LiteralType__Alternatives3310); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getINTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1588:6: ( ( 'ptReal' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1588:6: ( ( 'ptReal' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1589:1: ( 'ptReal' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1590:1: ( 'ptReal' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1590:3: 'ptReal'
                    {
                    match(input,26,FOLLOW_26_in_rule__LiteralType__Alternatives3331); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getREALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1595:6: ( ( 'ptCharacter' ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1595:6: ( ( 'ptCharacter' ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1596:1: ( 'ptCharacter' )
                    {
                     before(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1597:1: ( 'ptCharacter' )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1597:3: 'ptCharacter'
                    {
                    match(input,27,FOLLOW_27_in_rule__LiteralType__Alternatives3352); 

                    }

                     after(grammarAccess.getLiteralTypeAccess().getCHAREnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralType__Alternatives"


    // $ANTLR start "rule__PhysicalModel__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1609:1: rule__PhysicalModel__Group__0 : rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1 ;
    public final void rule__PhysicalModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1613:1: ( rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1614:2: rule__PhysicalModel__Group__0__Impl rule__PhysicalModel__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__0__Impl_in_rule__PhysicalModel__Group__03385);
            rule__PhysicalModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__1_in_rule__PhysicalModel__Group__03388);
            rule__PhysicalModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__0"


    // $ANTLR start "rule__PhysicalModel__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1621:1: rule__PhysicalModel__Group__0__Impl : ( 'PhysicalModel' ) ;
    public final void rule__PhysicalModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1625:1: ( ( 'PhysicalModel' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1626:1: ( 'PhysicalModel' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1626:1: ( 'PhysicalModel' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1627:1: 'PhysicalModel'
            {
             before(grammarAccess.getPhysicalModelAccess().getPhysicalModelKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__PhysicalModel__Group__0__Impl3416); 
             after(grammarAccess.getPhysicalModelAccess().getPhysicalModelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__0__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1640:1: rule__PhysicalModel__Group__1 : rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2 ;
    public final void rule__PhysicalModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1644:1: ( rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1645:2: rule__PhysicalModel__Group__1__Impl rule__PhysicalModel__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__1__Impl_in_rule__PhysicalModel__Group__13447);
            rule__PhysicalModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__2_in_rule__PhysicalModel__Group__13450);
            rule__PhysicalModel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__1"


    // $ANTLR start "rule__PhysicalModel__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1652:1: rule__PhysicalModel__Group__1__Impl : ( ( rule__PhysicalModel__NameAssignment_1 ) ) ;
    public final void rule__PhysicalModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1656:1: ( ( ( rule__PhysicalModel__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1657:1: ( ( rule__PhysicalModel__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1657:1: ( ( rule__PhysicalModel__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1658:1: ( rule__PhysicalModel__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalModelAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1659:1: ( rule__PhysicalModel__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1659:2: rule__PhysicalModel__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalModel__NameAssignment_1_in_rule__PhysicalModel__Group__1__Impl3477);
            rule__PhysicalModel__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalModelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__1__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1669:1: rule__PhysicalModel__Group__2 : rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3 ;
    public final void rule__PhysicalModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1673:1: ( rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1674:2: rule__PhysicalModel__Group__2__Impl rule__PhysicalModel__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__2__Impl_in_rule__PhysicalModel__Group__23507);
            rule__PhysicalModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__3_in_rule__PhysicalModel__Group__23510);
            rule__PhysicalModel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__2"


    // $ANTLR start "rule__PhysicalModel__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1681:1: rule__PhysicalModel__Group__2__Impl : ( '{' ) ;
    public final void rule__PhysicalModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1685:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1686:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1686:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1687:1: '{'
            {
             before(grammarAccess.getPhysicalModelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__PhysicalModel__Group__2__Impl3538); 
             after(grammarAccess.getPhysicalModelAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__2__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1700:1: rule__PhysicalModel__Group__3 : rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4 ;
    public final void rule__PhysicalModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1704:1: ( rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1705:2: rule__PhysicalModel__Group__3__Impl rule__PhysicalModel__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__3__Impl_in_rule__PhysicalModel__Group__33569);
            rule__PhysicalModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__4_in_rule__PhysicalModel__Group__33572);
            rule__PhysicalModel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__3"


    // $ANTLR start "rule__PhysicalModel__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1712:1: rule__PhysicalModel__Group__3__Impl : ( ( rule__PhysicalModel__ImportsAssignment_3 )* ) ;
    public final void rule__PhysicalModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1716:1: ( ( ( rule__PhysicalModel__ImportsAssignment_3 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1717:1: ( ( rule__PhysicalModel__ImportsAssignment_3 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1717:1: ( ( rule__PhysicalModel__ImportsAssignment_3 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1718:1: ( rule__PhysicalModel__ImportsAssignment_3 )*
            {
             before(grammarAccess.getPhysicalModelAccess().getImportsAssignment_3()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1719:1: ( rule__PhysicalModel__ImportsAssignment_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==46) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1719:2: rule__PhysicalModel__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalModel__ImportsAssignment_3_in_rule__PhysicalModel__Group__3__Impl3599);
            	    rule__PhysicalModel__ImportsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getPhysicalModelAccess().getImportsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__3__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1729:1: rule__PhysicalModel__Group__4 : rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5 ;
    public final void rule__PhysicalModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1733:1: ( rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1734:2: rule__PhysicalModel__Group__4__Impl rule__PhysicalModel__Group__5
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__4__Impl_in_rule__PhysicalModel__Group__43630);
            rule__PhysicalModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalModel__Group__5_in_rule__PhysicalModel__Group__43633);
            rule__PhysicalModel__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__4"


    // $ANTLR start "rule__PhysicalModel__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1741:1: rule__PhysicalModel__Group__4__Impl : ( ( rule__PhysicalModel__Alternatives_4 )* ) ;
    public final void rule__PhysicalModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1745:1: ( ( ( rule__PhysicalModel__Alternatives_4 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1746:1: ( ( rule__PhysicalModel__Alternatives_4 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1746:1: ( ( rule__PhysicalModel__Alternatives_4 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1747:1: ( rule__PhysicalModel__Alternatives_4 )*
            {
             before(grammarAccess.getPhysicalModelAccess().getAlternatives_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1748:1: ( rule__PhysicalModel__Alternatives_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==31||LA23_0==34||LA23_0==45) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1748:2: rule__PhysicalModel__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalModel__Alternatives_4_in_rule__PhysicalModel__Group__4__Impl3660);
            	    rule__PhysicalModel__Alternatives_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getPhysicalModelAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__4__Impl"


    // $ANTLR start "rule__PhysicalModel__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1758:1: rule__PhysicalModel__Group__5 : rule__PhysicalModel__Group__5__Impl ;
    public final void rule__PhysicalModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1762:1: ( rule__PhysicalModel__Group__5__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1763:2: rule__PhysicalModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalModel__Group__5__Impl_in_rule__PhysicalModel__Group__53691);
            rule__PhysicalModel__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__5"


    // $ANTLR start "rule__PhysicalModel__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1769:1: rule__PhysicalModel__Group__5__Impl : ( '}' ) ;
    public final void rule__PhysicalModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1773:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1774:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1774:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1775:1: '}'
            {
             before(grammarAccess.getPhysicalModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,30,FOLLOW_30_in_rule__PhysicalModel__Group__5__Impl3719); 
             after(grammarAccess.getPhysicalModelAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__Group__5__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1800:1: rule__PhysicalSystem__Group__0 : rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1 ;
    public final void rule__PhysicalSystem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1804:1: ( rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1805:2: rule__PhysicalSystem__Group__0__Impl rule__PhysicalSystem__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__0__Impl_in_rule__PhysicalSystem__Group__03762);
            rule__PhysicalSystem__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__1_in_rule__PhysicalSystem__Group__03765);
            rule__PhysicalSystem__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__0"


    // $ANTLR start "rule__PhysicalSystem__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1812:1: rule__PhysicalSystem__Group__0__Impl : ( 'PhysicalSystem' ) ;
    public final void rule__PhysicalSystem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1816:1: ( ( 'PhysicalSystem' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1817:1: ( 'PhysicalSystem' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1817:1: ( 'PhysicalSystem' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1818:1: 'PhysicalSystem'
            {
             before(grammarAccess.getPhysicalSystemAccess().getPhysicalSystemKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__PhysicalSystem__Group__0__Impl3793); 
             after(grammarAccess.getPhysicalSystemAccess().getPhysicalSystemKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__0__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1831:1: rule__PhysicalSystem__Group__1 : rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2 ;
    public final void rule__PhysicalSystem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1835:1: ( rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1836:2: rule__PhysicalSystem__Group__1__Impl rule__PhysicalSystem__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__1__Impl_in_rule__PhysicalSystem__Group__13824);
            rule__PhysicalSystem__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__2_in_rule__PhysicalSystem__Group__13827);
            rule__PhysicalSystem__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__1"


    // $ANTLR start "rule__PhysicalSystem__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1843:1: rule__PhysicalSystem__Group__1__Impl : ( ( rule__PhysicalSystem__NameAssignment_1 ) ) ;
    public final void rule__PhysicalSystem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1847:1: ( ( ( rule__PhysicalSystem__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1848:1: ( ( rule__PhysicalSystem__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1848:1: ( ( rule__PhysicalSystem__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1849:1: ( rule__PhysicalSystem__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalSystemAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1850:1: ( rule__PhysicalSystem__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1850:2: rule__PhysicalSystem__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__NameAssignment_1_in_rule__PhysicalSystem__Group__1__Impl3854);
            rule__PhysicalSystem__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalSystemAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__1__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1860:1: rule__PhysicalSystem__Group__2 : rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3 ;
    public final void rule__PhysicalSystem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1864:1: ( rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1865:2: rule__PhysicalSystem__Group__2__Impl rule__PhysicalSystem__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__2__Impl_in_rule__PhysicalSystem__Group__23884);
            rule__PhysicalSystem__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__3_in_rule__PhysicalSystem__Group__23887);
            rule__PhysicalSystem__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__2"


    // $ANTLR start "rule__PhysicalSystem__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1872:1: rule__PhysicalSystem__Group__2__Impl : ( ( rule__PhysicalSystem__DocuAssignment_2 )? ) ;
    public final void rule__PhysicalSystem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1876:1: ( ( ( rule__PhysicalSystem__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1877:1: ( ( rule__PhysicalSystem__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1877:1: ( ( rule__PhysicalSystem__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1878:1: ( rule__PhysicalSystem__DocuAssignment_2 )?
            {
             before(grammarAccess.getPhysicalSystemAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1879:1: ( rule__PhysicalSystem__DocuAssignment_2 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==52) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1879:2: rule__PhysicalSystem__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__PhysicalSystem__DocuAssignment_2_in_rule__PhysicalSystem__Group__2__Impl3914);
                    rule__PhysicalSystem__DocuAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPhysicalSystemAccess().getDocuAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__2__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1889:1: rule__PhysicalSystem__Group__3 : rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4 ;
    public final void rule__PhysicalSystem__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1893:1: ( rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1894:2: rule__PhysicalSystem__Group__3__Impl rule__PhysicalSystem__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__3__Impl_in_rule__PhysicalSystem__Group__33945);
            rule__PhysicalSystem__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__4_in_rule__PhysicalSystem__Group__33948);
            rule__PhysicalSystem__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__3"


    // $ANTLR start "rule__PhysicalSystem__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1901:1: rule__PhysicalSystem__Group__3__Impl : ( '{' ) ;
    public final void rule__PhysicalSystem__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1905:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1906:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1906:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1907:1: '{'
            {
             before(grammarAccess.getPhysicalSystemAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__PhysicalSystem__Group__3__Impl3976); 
             after(grammarAccess.getPhysicalSystemAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__3__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1920:1: rule__PhysicalSystem__Group__4 : rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5 ;
    public final void rule__PhysicalSystem__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1924:1: ( rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1925:2: rule__PhysicalSystem__Group__4__Impl rule__PhysicalSystem__Group__5
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__4__Impl_in_rule__PhysicalSystem__Group__44007);
            rule__PhysicalSystem__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalSystem__Group__5_in_rule__PhysicalSystem__Group__44010);
            rule__PhysicalSystem__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__4"


    // $ANTLR start "rule__PhysicalSystem__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1932:1: rule__PhysicalSystem__Group__4__Impl : ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* ) ;
    public final void rule__PhysicalSystem__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1936:1: ( ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1937:1: ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1937:1: ( ( rule__PhysicalSystem__NodeRefsAssignment_4 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1938:1: ( rule__PhysicalSystem__NodeRefsAssignment_4 )*
            {
             before(grammarAccess.getPhysicalSystemAccess().getNodeRefsAssignment_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1939:1: ( rule__PhysicalSystem__NodeRefsAssignment_4 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==32) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1939:2: rule__PhysicalSystem__NodeRefsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__PhysicalSystem__NodeRefsAssignment_4_in_rule__PhysicalSystem__Group__4__Impl4037);
            	    rule__PhysicalSystem__NodeRefsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getPhysicalSystemAccess().getNodeRefsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__4__Impl"


    // $ANTLR start "rule__PhysicalSystem__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1949:1: rule__PhysicalSystem__Group__5 : rule__PhysicalSystem__Group__5__Impl ;
    public final void rule__PhysicalSystem__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1953:1: ( rule__PhysicalSystem__Group__5__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1954:2: rule__PhysicalSystem__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalSystem__Group__5__Impl_in_rule__PhysicalSystem__Group__54068);
            rule__PhysicalSystem__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__5"


    // $ANTLR start "rule__PhysicalSystem__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1960:1: rule__PhysicalSystem__Group__5__Impl : ( '}' ) ;
    public final void rule__PhysicalSystem__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1964:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1965:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1965:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1966:1: '}'
            {
             before(grammarAccess.getPhysicalSystemAccess().getRightCurlyBracketKeyword_5()); 
            match(input,30,FOLLOW_30_in_rule__PhysicalSystem__Group__5__Impl4096); 
             after(grammarAccess.getPhysicalSystemAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__Group__5__Impl"


    // $ANTLR start "rule__NodeRef__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1991:1: rule__NodeRef__Group__0 : rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 ;
    public final void rule__NodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1995:1: ( rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:1996:2: rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__04139);
            rule__NodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__04142);
            rule__NodeRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__0"


    // $ANTLR start "rule__NodeRef__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2003:1: rule__NodeRef__Group__0__Impl : ( 'NodeRef' ) ;
    public final void rule__NodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2007:1: ( ( 'NodeRef' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2008:1: ( 'NodeRef' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2008:1: ( 'NodeRef' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2009:1: 'NodeRef'
            {
             before(grammarAccess.getNodeRefAccess().getNodeRefKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__NodeRef__Group__0__Impl4170); 
             after(grammarAccess.getNodeRefAccess().getNodeRefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__0__Impl"


    // $ANTLR start "rule__NodeRef__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2022:1: rule__NodeRef__Group__1 : rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2 ;
    public final void rule__NodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2026:1: ( rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2027:2: rule__NodeRef__Group__1__Impl rule__NodeRef__Group__2
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__14201);
            rule__NodeRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__2_in_rule__NodeRef__Group__14204);
            rule__NodeRef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__1"


    // $ANTLR start "rule__NodeRef__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2034:1: rule__NodeRef__Group__1__Impl : ( ( rule__NodeRef__NameAssignment_1 ) ) ;
    public final void rule__NodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2038:1: ( ( ( rule__NodeRef__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2039:1: ( ( rule__NodeRef__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2039:1: ( ( rule__NodeRef__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2040:1: ( rule__NodeRef__NameAssignment_1 )
            {
             before(grammarAccess.getNodeRefAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2041:1: ( rule__NodeRef__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2041:2: rule__NodeRef__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__NodeRef__NameAssignment_1_in_rule__NodeRef__Group__1__Impl4231);
            rule__NodeRef__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__1__Impl"


    // $ANTLR start "rule__NodeRef__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2051:1: rule__NodeRef__Group__2 : rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3 ;
    public final void rule__NodeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2055:1: ( rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2056:2: rule__NodeRef__Group__2__Impl rule__NodeRef__Group__3
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__2__Impl_in_rule__NodeRef__Group__24261);
            rule__NodeRef__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__3_in_rule__NodeRef__Group__24264);
            rule__NodeRef__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__2"


    // $ANTLR start "rule__NodeRef__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2063:1: rule__NodeRef__Group__2__Impl : ( ':' ) ;
    public final void rule__NodeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2067:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2068:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2068:1: ( ':' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2069:1: ':'
            {
             before(grammarAccess.getNodeRefAccess().getColonKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__NodeRef__Group__2__Impl4292); 
             after(grammarAccess.getNodeRefAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__2__Impl"


    // $ANTLR start "rule__NodeRef__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2082:1: rule__NodeRef__Group__3 : rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4 ;
    public final void rule__NodeRef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2086:1: ( rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2087:2: rule__NodeRef__Group__3__Impl rule__NodeRef__Group__4
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__3__Impl_in_rule__NodeRef__Group__34323);
            rule__NodeRef__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__4_in_rule__NodeRef__Group__34326);
            rule__NodeRef__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__3"


    // $ANTLR start "rule__NodeRef__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2094:1: rule__NodeRef__Group__3__Impl : ( ( rule__NodeRef__TypeAssignment_3 ) ) ;
    public final void rule__NodeRef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2098:1: ( ( ( rule__NodeRef__TypeAssignment_3 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2099:1: ( ( rule__NodeRef__TypeAssignment_3 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2099:1: ( ( rule__NodeRef__TypeAssignment_3 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2100:1: ( rule__NodeRef__TypeAssignment_3 )
            {
             before(grammarAccess.getNodeRefAccess().getTypeAssignment_3()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2101:1: ( rule__NodeRef__TypeAssignment_3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2101:2: rule__NodeRef__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__NodeRef__TypeAssignment_3_in_rule__NodeRef__Group__3__Impl4353);
            rule__NodeRef__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__3__Impl"


    // $ANTLR start "rule__NodeRef__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2111:1: rule__NodeRef__Group__4 : rule__NodeRef__Group__4__Impl ;
    public final void rule__NodeRef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2115:1: ( rule__NodeRef__Group__4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2116:2: rule__NodeRef__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__4__Impl_in_rule__NodeRef__Group__44383);
            rule__NodeRef__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__4"


    // $ANTLR start "rule__NodeRef__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2122:1: rule__NodeRef__Group__4__Impl : ( ( rule__NodeRef__DocuAssignment_4 )? ) ;
    public final void rule__NodeRef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2126:1: ( ( ( rule__NodeRef__DocuAssignment_4 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2127:1: ( ( rule__NodeRef__DocuAssignment_4 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2127:1: ( ( rule__NodeRef__DocuAssignment_4 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2128:1: ( rule__NodeRef__DocuAssignment_4 )?
            {
             before(grammarAccess.getNodeRefAccess().getDocuAssignment_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2129:1: ( rule__NodeRef__DocuAssignment_4 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==52) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2129:2: rule__NodeRef__DocuAssignment_4
                    {
                    pushFollow(FOLLOW_rule__NodeRef__DocuAssignment_4_in_rule__NodeRef__Group__4__Impl4410);
                    rule__NodeRef__DocuAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeRefAccess().getDocuAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__4__Impl"


    // $ANTLR start "rule__NodeClass__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2149:1: rule__NodeClass__Group__0 : rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1 ;
    public final void rule__NodeClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2153:1: ( rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2154:2: rule__NodeClass__Group__0__Impl rule__NodeClass__Group__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__0__Impl_in_rule__NodeClass__Group__04451);
            rule__NodeClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__1_in_rule__NodeClass__Group__04454);
            rule__NodeClass__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__0"


    // $ANTLR start "rule__NodeClass__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2161:1: rule__NodeClass__Group__0__Impl : ( 'NodeClass' ) ;
    public final void rule__NodeClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2165:1: ( ( 'NodeClass' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2166:1: ( 'NodeClass' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2166:1: ( 'NodeClass' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2167:1: 'NodeClass'
            {
             before(grammarAccess.getNodeClassAccess().getNodeClassKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__NodeClass__Group__0__Impl4482); 
             after(grammarAccess.getNodeClassAccess().getNodeClassKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__0__Impl"


    // $ANTLR start "rule__NodeClass__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2180:1: rule__NodeClass__Group__1 : rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2 ;
    public final void rule__NodeClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2184:1: ( rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2185:2: rule__NodeClass__Group__1__Impl rule__NodeClass__Group__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__1__Impl_in_rule__NodeClass__Group__14513);
            rule__NodeClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__2_in_rule__NodeClass__Group__14516);
            rule__NodeClass__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__1"


    // $ANTLR start "rule__NodeClass__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2192:1: rule__NodeClass__Group__1__Impl : ( ( rule__NodeClass__NameAssignment_1 ) ) ;
    public final void rule__NodeClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2196:1: ( ( ( rule__NodeClass__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2197:1: ( ( rule__NodeClass__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2197:1: ( ( rule__NodeClass__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2198:1: ( rule__NodeClass__NameAssignment_1 )
            {
             before(grammarAccess.getNodeClassAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2199:1: ( rule__NodeClass__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2199:2: rule__NodeClass__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__NodeClass__NameAssignment_1_in_rule__NodeClass__Group__1__Impl4543);
            rule__NodeClass__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__1__Impl"


    // $ANTLR start "rule__NodeClass__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2209:1: rule__NodeClass__Group__2 : rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3 ;
    public final void rule__NodeClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2213:1: ( rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2214:2: rule__NodeClass__Group__2__Impl rule__NodeClass__Group__3
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__2__Impl_in_rule__NodeClass__Group__24573);
            rule__NodeClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__3_in_rule__NodeClass__Group__24576);
            rule__NodeClass__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__2"


    // $ANTLR start "rule__NodeClass__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2221:1: rule__NodeClass__Group__2__Impl : ( ( rule__NodeClass__DocuAssignment_2 )? ) ;
    public final void rule__NodeClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2225:1: ( ( ( rule__NodeClass__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2226:1: ( ( rule__NodeClass__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2226:1: ( ( rule__NodeClass__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2227:1: ( rule__NodeClass__DocuAssignment_2 )?
            {
             before(grammarAccess.getNodeClassAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2228:1: ( rule__NodeClass__DocuAssignment_2 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==52) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2228:2: rule__NodeClass__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__NodeClass__DocuAssignment_2_in_rule__NodeClass__Group__2__Impl4603);
                    rule__NodeClass__DocuAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeClassAccess().getDocuAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__2__Impl"


    // $ANTLR start "rule__NodeClass__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2238:1: rule__NodeClass__Group__3 : rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4 ;
    public final void rule__NodeClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2242:1: ( rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2243:2: rule__NodeClass__Group__3__Impl rule__NodeClass__Group__4
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__3__Impl_in_rule__NodeClass__Group__34634);
            rule__NodeClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__4_in_rule__NodeClass__Group__34637);
            rule__NodeClass__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__3"


    // $ANTLR start "rule__NodeClass__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2250:1: rule__NodeClass__Group__3__Impl : ( '{' ) ;
    public final void rule__NodeClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2254:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2255:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2255:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2256:1: '{'
            {
             before(grammarAccess.getNodeClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__NodeClass__Group__3__Impl4665); 
             after(grammarAccess.getNodeClassAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__3__Impl"


    // $ANTLR start "rule__NodeClass__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2269:1: rule__NodeClass__Group__4 : rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5 ;
    public final void rule__NodeClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2273:1: ( rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2274:2: rule__NodeClass__Group__4__Impl rule__NodeClass__Group__5
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__4__Impl_in_rule__NodeClass__Group__44696);
            rule__NodeClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__5_in_rule__NodeClass__Group__44699);
            rule__NodeClass__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__4"


    // $ANTLR start "rule__NodeClass__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2281:1: rule__NodeClass__Group__4__Impl : ( ( rule__NodeClass__UnorderedGroup_4 ) ) ;
    public final void rule__NodeClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2285:1: ( ( ( rule__NodeClass__UnorderedGroup_4 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2286:1: ( ( rule__NodeClass__UnorderedGroup_4 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2286:1: ( ( rule__NodeClass__UnorderedGroup_4 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2287:1: ( rule__NodeClass__UnorderedGroup_4 )
            {
             before(grammarAccess.getNodeClassAccess().getUnorderedGroup_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2288:1: ( rule__NodeClass__UnorderedGroup_4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2288:2: rule__NodeClass__UnorderedGroup_4
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4_in_rule__NodeClass__Group__4__Impl4726);
            rule__NodeClass__UnorderedGroup_4();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getUnorderedGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__4__Impl"


    // $ANTLR start "rule__NodeClass__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2298:1: rule__NodeClass__Group__5 : rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6 ;
    public final void rule__NodeClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2302:1: ( rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2303:2: rule__NodeClass__Group__5__Impl rule__NodeClass__Group__6
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__5__Impl_in_rule__NodeClass__Group__54756);
            rule__NodeClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group__6_in_rule__NodeClass__Group__54759);
            rule__NodeClass__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__5"


    // $ANTLR start "rule__NodeClass__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2310:1: rule__NodeClass__Group__5__Impl : ( ( rule__NodeClass__ThreadsAssignment_5 )* ) ;
    public final void rule__NodeClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2314:1: ( ( ( rule__NodeClass__ThreadsAssignment_5 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2315:1: ( ( rule__NodeClass__ThreadsAssignment_5 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2315:1: ( ( rule__NodeClass__ThreadsAssignment_5 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2316:1: ( rule__NodeClass__ThreadsAssignment_5 )*
            {
             before(grammarAccess.getNodeClassAccess().getThreadsAssignment_5()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2317:1: ( rule__NodeClass__ThreadsAssignment_5 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==13||LA28_0==58) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2317:2: rule__NodeClass__ThreadsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__NodeClass__ThreadsAssignment_5_in_rule__NodeClass__Group__5__Impl4786);
            	    rule__NodeClass__ThreadsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getNodeClassAccess().getThreadsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__5__Impl"


    // $ANTLR start "rule__NodeClass__Group__6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2327:1: rule__NodeClass__Group__6 : rule__NodeClass__Group__6__Impl ;
    public final void rule__NodeClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2331:1: ( rule__NodeClass__Group__6__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2332:2: rule__NodeClass__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group__6__Impl_in_rule__NodeClass__Group__64817);
            rule__NodeClass__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__6"


    // $ANTLR start "rule__NodeClass__Group__6__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2338:1: rule__NodeClass__Group__6__Impl : ( '}' ) ;
    public final void rule__NodeClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2342:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2343:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2343:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2344:1: '}'
            {
             before(grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_6()); 
            match(input,30,FOLLOW_30_in_rule__NodeClass__Group__6__Impl4845); 
             after(grammarAccess.getNodeClassAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group__6__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_0__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2371:1: rule__NodeClass__Group_4_0__0 : rule__NodeClass__Group_4_0__0__Impl rule__NodeClass__Group_4_0__1 ;
    public final void rule__NodeClass__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2375:1: ( rule__NodeClass__Group_4_0__0__Impl rule__NodeClass__Group_4_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2376:2: rule__NodeClass__Group_4_0__0__Impl rule__NodeClass__Group_4_0__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__0__Impl_in_rule__NodeClass__Group_4_0__04890);
            rule__NodeClass__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__1_in_rule__NodeClass__Group_4_0__04893);
            rule__NodeClass__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__0"


    // $ANTLR start "rule__NodeClass__Group_4_0__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2383:1: rule__NodeClass__Group_4_0__0__Impl : ( 'runtime' ) ;
    public final void rule__NodeClass__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2387:1: ( ( 'runtime' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2388:1: ( 'runtime' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2388:1: ( 'runtime' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2389:1: 'runtime'
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeKeyword_4_0_0()); 
            match(input,35,FOLLOW_35_in_rule__NodeClass__Group_4_0__0__Impl4921); 
             after(grammarAccess.getNodeClassAccess().getRuntimeKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__0__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_0__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2402:1: rule__NodeClass__Group_4_0__1 : rule__NodeClass__Group_4_0__1__Impl rule__NodeClass__Group_4_0__2 ;
    public final void rule__NodeClass__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2406:1: ( rule__NodeClass__Group_4_0__1__Impl rule__NodeClass__Group_4_0__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2407:2: rule__NodeClass__Group_4_0__1__Impl rule__NodeClass__Group_4_0__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__1__Impl_in_rule__NodeClass__Group_4_0__14952);
            rule__NodeClass__Group_4_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__2_in_rule__NodeClass__Group_4_0__14955);
            rule__NodeClass__Group_4_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__1"


    // $ANTLR start "rule__NodeClass__Group_4_0__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2414:1: rule__NodeClass__Group_4_0__1__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2418:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2419:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2419:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2420:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_0_1()); 
            match(input,36,FOLLOW_36_in_rule__NodeClass__Group_4_0__1__Impl4983); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__1__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_0__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2433:1: rule__NodeClass__Group_4_0__2 : rule__NodeClass__Group_4_0__2__Impl ;
    public final void rule__NodeClass__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2437:1: ( rule__NodeClass__Group_4_0__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2438:2: rule__NodeClass__Group_4_0__2__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_0__2__Impl_in_rule__NodeClass__Group_4_0__25014);
            rule__NodeClass__Group_4_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__2"


    // $ANTLR start "rule__NodeClass__Group_4_0__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2444:1: rule__NodeClass__Group_4_0__2__Impl : ( ( rule__NodeClass__RuntimeAssignment_4_0_2 ) ) ;
    public final void rule__NodeClass__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2448:1: ( ( ( rule__NodeClass__RuntimeAssignment_4_0_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2449:1: ( ( rule__NodeClass__RuntimeAssignment_4_0_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2449:1: ( ( rule__NodeClass__RuntimeAssignment_4_0_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2450:1: ( rule__NodeClass__RuntimeAssignment_4_0_2 )
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeAssignment_4_0_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2451:1: ( rule__NodeClass__RuntimeAssignment_4_0_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2451:2: rule__NodeClass__RuntimeAssignment_4_0_2
            {
            pushFollow(FOLLOW_rule__NodeClass__RuntimeAssignment_4_0_2_in_rule__NodeClass__Group_4_0__2__Impl5041);
            rule__NodeClass__RuntimeAssignment_4_0_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getRuntimeAssignment_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_0__2__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_1__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2467:1: rule__NodeClass__Group_4_1__0 : rule__NodeClass__Group_4_1__0__Impl rule__NodeClass__Group_4_1__1 ;
    public final void rule__NodeClass__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2471:1: ( rule__NodeClass__Group_4_1__0__Impl rule__NodeClass__Group_4_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2472:2: rule__NodeClass__Group_4_1__0__Impl rule__NodeClass__Group_4_1__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__0__Impl_in_rule__NodeClass__Group_4_1__05077);
            rule__NodeClass__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__1_in_rule__NodeClass__Group_4_1__05080);
            rule__NodeClass__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__0"


    // $ANTLR start "rule__NodeClass__Group_4_1__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2479:1: rule__NodeClass__Group_4_1__0__Impl : ( 'priomin' ) ;
    public final void rule__NodeClass__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2483:1: ( ( 'priomin' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2484:1: ( 'priomin' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2484:1: ( 'priomin' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2485:1: 'priomin'
            {
             before(grammarAccess.getNodeClassAccess().getPriominKeyword_4_1_0()); 
            match(input,37,FOLLOW_37_in_rule__NodeClass__Group_4_1__0__Impl5108); 
             after(grammarAccess.getNodeClassAccess().getPriominKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__0__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_1__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2498:1: rule__NodeClass__Group_4_1__1 : rule__NodeClass__Group_4_1__1__Impl rule__NodeClass__Group_4_1__2 ;
    public final void rule__NodeClass__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2502:1: ( rule__NodeClass__Group_4_1__1__Impl rule__NodeClass__Group_4_1__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2503:2: rule__NodeClass__Group_4_1__1__Impl rule__NodeClass__Group_4_1__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__1__Impl_in_rule__NodeClass__Group_4_1__15139);
            rule__NodeClass__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__2_in_rule__NodeClass__Group_4_1__15142);
            rule__NodeClass__Group_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__1"


    // $ANTLR start "rule__NodeClass__Group_4_1__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2510:1: rule__NodeClass__Group_4_1__1__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2514:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2515:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2515:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2516:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_1_1()); 
            match(input,36,FOLLOW_36_in_rule__NodeClass__Group_4_1__1__Impl5170); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__1__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_1__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2529:1: rule__NodeClass__Group_4_1__2 : rule__NodeClass__Group_4_1__2__Impl ;
    public final void rule__NodeClass__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2533:1: ( rule__NodeClass__Group_4_1__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2534:2: rule__NodeClass__Group_4_1__2__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_1__2__Impl_in_rule__NodeClass__Group_4_1__25201);
            rule__NodeClass__Group_4_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__2"


    // $ANTLR start "rule__NodeClass__Group_4_1__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2540:1: rule__NodeClass__Group_4_1__2__Impl : ( ( rule__NodeClass__PriominAssignment_4_1_2 ) ) ;
    public final void rule__NodeClass__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2544:1: ( ( ( rule__NodeClass__PriominAssignment_4_1_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2545:1: ( ( rule__NodeClass__PriominAssignment_4_1_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2545:1: ( ( rule__NodeClass__PriominAssignment_4_1_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2546:1: ( rule__NodeClass__PriominAssignment_4_1_2 )
            {
             before(grammarAccess.getNodeClassAccess().getPriominAssignment_4_1_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2547:1: ( rule__NodeClass__PriominAssignment_4_1_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2547:2: rule__NodeClass__PriominAssignment_4_1_2
            {
            pushFollow(FOLLOW_rule__NodeClass__PriominAssignment_4_1_2_in_rule__NodeClass__Group_4_1__2__Impl5228);
            rule__NodeClass__PriominAssignment_4_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getPriominAssignment_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_1__2__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_2__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2563:1: rule__NodeClass__Group_4_2__0 : rule__NodeClass__Group_4_2__0__Impl rule__NodeClass__Group_4_2__1 ;
    public final void rule__NodeClass__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2567:1: ( rule__NodeClass__Group_4_2__0__Impl rule__NodeClass__Group_4_2__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2568:2: rule__NodeClass__Group_4_2__0__Impl rule__NodeClass__Group_4_2__1
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__0__Impl_in_rule__NodeClass__Group_4_2__05264);
            rule__NodeClass__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__1_in_rule__NodeClass__Group_4_2__05267);
            rule__NodeClass__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__0"


    // $ANTLR start "rule__NodeClass__Group_4_2__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2575:1: rule__NodeClass__Group_4_2__0__Impl : ( 'priomax' ) ;
    public final void rule__NodeClass__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2579:1: ( ( 'priomax' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2580:1: ( 'priomax' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2580:1: ( 'priomax' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2581:1: 'priomax'
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxKeyword_4_2_0()); 
            match(input,38,FOLLOW_38_in_rule__NodeClass__Group_4_2__0__Impl5295); 
             after(grammarAccess.getNodeClassAccess().getPriomaxKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__0__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_2__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2594:1: rule__NodeClass__Group_4_2__1 : rule__NodeClass__Group_4_2__1__Impl rule__NodeClass__Group_4_2__2 ;
    public final void rule__NodeClass__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2598:1: ( rule__NodeClass__Group_4_2__1__Impl rule__NodeClass__Group_4_2__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2599:2: rule__NodeClass__Group_4_2__1__Impl rule__NodeClass__Group_4_2__2
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__1__Impl_in_rule__NodeClass__Group_4_2__15326);
            rule__NodeClass__Group_4_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__2_in_rule__NodeClass__Group_4_2__15329);
            rule__NodeClass__Group_4_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__1"


    // $ANTLR start "rule__NodeClass__Group_4_2__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2606:1: rule__NodeClass__Group_4_2__1__Impl : ( '=' ) ;
    public final void rule__NodeClass__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2610:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2611:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2611:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2612:1: '='
            {
             before(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_2_1()); 
            match(input,36,FOLLOW_36_in_rule__NodeClass__Group_4_2__1__Impl5357); 
             after(grammarAccess.getNodeClassAccess().getEqualsSignKeyword_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__1__Impl"


    // $ANTLR start "rule__NodeClass__Group_4_2__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2625:1: rule__NodeClass__Group_4_2__2 : rule__NodeClass__Group_4_2__2__Impl ;
    public final void rule__NodeClass__Group_4_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2629:1: ( rule__NodeClass__Group_4_2__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2630:2: rule__NodeClass__Group_4_2__2__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__Group_4_2__2__Impl_in_rule__NodeClass__Group_4_2__25388);
            rule__NodeClass__Group_4_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__2"


    // $ANTLR start "rule__NodeClass__Group_4_2__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2636:1: rule__NodeClass__Group_4_2__2__Impl : ( ( rule__NodeClass__PriomaxAssignment_4_2_2 ) ) ;
    public final void rule__NodeClass__Group_4_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2640:1: ( ( ( rule__NodeClass__PriomaxAssignment_4_2_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2641:1: ( ( rule__NodeClass__PriomaxAssignment_4_2_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2641:1: ( ( rule__NodeClass__PriomaxAssignment_4_2_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2642:1: ( rule__NodeClass__PriomaxAssignment_4_2_2 )
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxAssignment_4_2_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2643:1: ( rule__NodeClass__PriomaxAssignment_4_2_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2643:2: rule__NodeClass__PriomaxAssignment_4_2_2
            {
            pushFollow(FOLLOW_rule__NodeClass__PriomaxAssignment_4_2_2_in_rule__NodeClass__Group_4_2__2__Impl5415);
            rule__NodeClass__PriomaxAssignment_4_2_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeClassAccess().getPriomaxAssignment_4_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__Group_4_2__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2659:1: rule__PhysicalThread__Group__0 : rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1 ;
    public final void rule__PhysicalThread__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2663:1: ( rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2664:2: rule__PhysicalThread__Group__0__Impl rule__PhysicalThread__Group__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__0__Impl_in_rule__PhysicalThread__Group__05451);
            rule__PhysicalThread__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__1_in_rule__PhysicalThread__Group__05454);
            rule__PhysicalThread__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__0"


    // $ANTLR start "rule__PhysicalThread__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2671:1: rule__PhysicalThread__Group__0__Impl : ( ( rule__PhysicalThread__Alternatives_0 ) ) ;
    public final void rule__PhysicalThread__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2675:1: ( ( ( rule__PhysicalThread__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2676:1: ( ( rule__PhysicalThread__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2676:1: ( ( rule__PhysicalThread__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2677:1: ( rule__PhysicalThread__Alternatives_0 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2678:1: ( rule__PhysicalThread__Alternatives_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2678:2: rule__PhysicalThread__Alternatives_0
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Alternatives_0_in_rule__PhysicalThread__Group__0__Impl5481);
            rule__PhysicalThread__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2688:1: rule__PhysicalThread__Group__1 : rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2 ;
    public final void rule__PhysicalThread__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2692:1: ( rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2693:2: rule__PhysicalThread__Group__1__Impl rule__PhysicalThread__Group__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__1__Impl_in_rule__PhysicalThread__Group__15511);
            rule__PhysicalThread__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__2_in_rule__PhysicalThread__Group__15514);
            rule__PhysicalThread__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__1"


    // $ANTLR start "rule__PhysicalThread__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2700:1: rule__PhysicalThread__Group__1__Impl : ( ( rule__PhysicalThread__NameAssignment_1 ) ) ;
    public final void rule__PhysicalThread__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2704:1: ( ( ( rule__PhysicalThread__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2705:1: ( ( rule__PhysicalThread__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2705:1: ( ( rule__PhysicalThread__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2706:1: ( rule__PhysicalThread__NameAssignment_1 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2707:1: ( rule__PhysicalThread__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2707:2: rule__PhysicalThread__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__NameAssignment_1_in_rule__PhysicalThread__Group__1__Impl5541);
            rule__PhysicalThread__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2717:1: rule__PhysicalThread__Group__2 : rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3 ;
    public final void rule__PhysicalThread__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2721:1: ( rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2722:2: rule__PhysicalThread__Group__2__Impl rule__PhysicalThread__Group__3
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__2__Impl_in_rule__PhysicalThread__Group__25571);
            rule__PhysicalThread__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__3_in_rule__PhysicalThread__Group__25574);
            rule__PhysicalThread__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__2"


    // $ANTLR start "rule__PhysicalThread__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2729:1: rule__PhysicalThread__Group__2__Impl : ( '{' ) ;
    public final void rule__PhysicalThread__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2733:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2734:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2734:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2735:1: '{'
            {
             before(grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__PhysicalThread__Group__2__Impl5602); 
             after(grammarAccess.getPhysicalThreadAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2748:1: rule__PhysicalThread__Group__3 : rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4 ;
    public final void rule__PhysicalThread__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2752:1: ( rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2753:2: rule__PhysicalThread__Group__3__Impl rule__PhysicalThread__Group__4
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__3__Impl_in_rule__PhysicalThread__Group__35633);
            rule__PhysicalThread__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group__4_in_rule__PhysicalThread__Group__35636);
            rule__PhysicalThread__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__3"


    // $ANTLR start "rule__PhysicalThread__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2760:1: rule__PhysicalThread__Group__3__Impl : ( ( rule__PhysicalThread__UnorderedGroup_3 ) ) ;
    public final void rule__PhysicalThread__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2764:1: ( ( ( rule__PhysicalThread__UnorderedGroup_3 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2765:1: ( ( rule__PhysicalThread__UnorderedGroup_3 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2765:1: ( ( rule__PhysicalThread__UnorderedGroup_3 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2766:1: ( rule__PhysicalThread__UnorderedGroup_3 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2767:1: ( rule__PhysicalThread__UnorderedGroup_3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2767:2: rule__PhysicalThread__UnorderedGroup_3
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3_in_rule__PhysicalThread__Group__3__Impl5663);
            rule__PhysicalThread__UnorderedGroup_3();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__3__Impl"


    // $ANTLR start "rule__PhysicalThread__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2777:1: rule__PhysicalThread__Group__4 : rule__PhysicalThread__Group__4__Impl ;
    public final void rule__PhysicalThread__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2781:1: ( rule__PhysicalThread__Group__4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2782:2: rule__PhysicalThread__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group__4__Impl_in_rule__PhysicalThread__Group__45693);
            rule__PhysicalThread__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__4"


    // $ANTLR start "rule__PhysicalThread__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2788:1: rule__PhysicalThread__Group__4__Impl : ( '}' ) ;
    public final void rule__PhysicalThread__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2792:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2793:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2793:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2794:1: '}'
            {
             before(grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_4()); 
            match(input,30,FOLLOW_30_in_rule__PhysicalThread__Group__4__Impl5721); 
             after(grammarAccess.getPhysicalThreadAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group__4__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2817:1: rule__PhysicalThread__Group_3_0__0 : rule__PhysicalThread__Group_3_0__0__Impl rule__PhysicalThread__Group_3_0__1 ;
    public final void rule__PhysicalThread__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2821:1: ( rule__PhysicalThread__Group_3_0__0__Impl rule__PhysicalThread__Group_3_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2822:2: rule__PhysicalThread__Group_3_0__0__Impl rule__PhysicalThread__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__0__Impl_in_rule__PhysicalThread__Group_3_0__05762);
            rule__PhysicalThread__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__1_in_rule__PhysicalThread__Group_3_0__05765);
            rule__PhysicalThread__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2829:1: rule__PhysicalThread__Group_3_0__0__Impl : ( 'execmode' ) ;
    public final void rule__PhysicalThread__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2833:1: ( ( 'execmode' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2834:1: ( 'execmode' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2834:1: ( 'execmode' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2835:1: 'execmode'
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3_0_0()); 
            match(input,39,FOLLOW_39_in_rule__PhysicalThread__Group_3_0__0__Impl5793); 
             after(grammarAccess.getPhysicalThreadAccess().getExecmodeKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2848:1: rule__PhysicalThread__Group_3_0__1 : rule__PhysicalThread__Group_3_0__1__Impl rule__PhysicalThread__Group_3_0__2 ;
    public final void rule__PhysicalThread__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2852:1: ( rule__PhysicalThread__Group_3_0__1__Impl rule__PhysicalThread__Group_3_0__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2853:2: rule__PhysicalThread__Group_3_0__1__Impl rule__PhysicalThread__Group_3_0__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__1__Impl_in_rule__PhysicalThread__Group_3_0__15824);
            rule__PhysicalThread__Group_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__2_in_rule__PhysicalThread__Group_3_0__15827);
            rule__PhysicalThread__Group_3_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2860:1: rule__PhysicalThread__Group_3_0__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2864:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2865:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2865:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2866:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_0_1()); 
            match(input,36,FOLLOW_36_in_rule__PhysicalThread__Group_3_0__1__Impl5855); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2879:1: rule__PhysicalThread__Group_3_0__2 : rule__PhysicalThread__Group_3_0__2__Impl ;
    public final void rule__PhysicalThread__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2883:1: ( rule__PhysicalThread__Group_3_0__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2884:2: rule__PhysicalThread__Group_3_0__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__2__Impl_in_rule__PhysicalThread__Group_3_0__25886);
            rule__PhysicalThread__Group_3_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_0__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2890:1: rule__PhysicalThread__Group_3_0__2__Impl : ( ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2894:1: ( ( ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2895:1: ( ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2895:1: ( ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2896:1: ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeAssignment_3_0_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2897:1: ( rule__PhysicalThread__ExecmodeAssignment_3_0_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2897:2: rule__PhysicalThread__ExecmodeAssignment_3_0_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__ExecmodeAssignment_3_0_2_in_rule__PhysicalThread__Group_3_0__2__Impl5913);
            rule__PhysicalThread__ExecmodeAssignment_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getExecmodeAssignment_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_0__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2913:1: rule__PhysicalThread__Group_3_1__0 : rule__PhysicalThread__Group_3_1__0__Impl rule__PhysicalThread__Group_3_1__1 ;
    public final void rule__PhysicalThread__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2917:1: ( rule__PhysicalThread__Group_3_1__0__Impl rule__PhysicalThread__Group_3_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2918:2: rule__PhysicalThread__Group_3_1__0__Impl rule__PhysicalThread__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__0__Impl_in_rule__PhysicalThread__Group_3_1__05949);
            rule__PhysicalThread__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__1_in_rule__PhysicalThread__Group_3_1__05952);
            rule__PhysicalThread__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2925:1: rule__PhysicalThread__Group_3_1__0__Impl : ( 'interval' ) ;
    public final void rule__PhysicalThread__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2929:1: ( ( 'interval' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2930:1: ( 'interval' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2930:1: ( 'interval' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2931:1: 'interval'
            {
             before(grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_3_1_0()); 
            match(input,40,FOLLOW_40_in_rule__PhysicalThread__Group_3_1__0__Impl5980); 
             after(grammarAccess.getPhysicalThreadAccess().getIntervalKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2944:1: rule__PhysicalThread__Group_3_1__1 : rule__PhysicalThread__Group_3_1__1__Impl rule__PhysicalThread__Group_3_1__2 ;
    public final void rule__PhysicalThread__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2948:1: ( rule__PhysicalThread__Group_3_1__1__Impl rule__PhysicalThread__Group_3_1__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2949:2: rule__PhysicalThread__Group_3_1__1__Impl rule__PhysicalThread__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__1__Impl_in_rule__PhysicalThread__Group_3_1__16011);
            rule__PhysicalThread__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__2_in_rule__PhysicalThread__Group_3_1__16014);
            rule__PhysicalThread__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2956:1: rule__PhysicalThread__Group_3_1__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2960:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2961:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2961:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2962:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_1_1()); 
            match(input,36,FOLLOW_36_in_rule__PhysicalThread__Group_3_1__1__Impl6042); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2975:1: rule__PhysicalThread__Group_3_1__2 : rule__PhysicalThread__Group_3_1__2__Impl ;
    public final void rule__PhysicalThread__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2979:1: ( rule__PhysicalThread__Group_3_1__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2980:2: rule__PhysicalThread__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__2__Impl_in_rule__PhysicalThread__Group_3_1__26073);
            rule__PhysicalThread__Group_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_1__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2986:1: rule__PhysicalThread__Group_3_1__2__Impl : ( ( rule__PhysicalThread__TimeAssignment_3_1_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2990:1: ( ( ( rule__PhysicalThread__TimeAssignment_3_1_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2991:1: ( ( rule__PhysicalThread__TimeAssignment_3_1_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2991:1: ( ( rule__PhysicalThread__TimeAssignment_3_1_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2992:1: ( rule__PhysicalThread__TimeAssignment_3_1_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getTimeAssignment_3_1_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2993:1: ( rule__PhysicalThread__TimeAssignment_3_1_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:2993:2: rule__PhysicalThread__TimeAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__TimeAssignment_3_1_2_in_rule__PhysicalThread__Group_3_1__2__Impl6100);
            rule__PhysicalThread__TimeAssignment_3_1_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getTimeAssignment_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_1__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3009:1: rule__PhysicalThread__Group_3_2__0 : rule__PhysicalThread__Group_3_2__0__Impl rule__PhysicalThread__Group_3_2__1 ;
    public final void rule__PhysicalThread__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3013:1: ( rule__PhysicalThread__Group_3_2__0__Impl rule__PhysicalThread__Group_3_2__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3014:2: rule__PhysicalThread__Group_3_2__0__Impl rule__PhysicalThread__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__0__Impl_in_rule__PhysicalThread__Group_3_2__06136);
            rule__PhysicalThread__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__1_in_rule__PhysicalThread__Group_3_2__06139);
            rule__PhysicalThread__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3021:1: rule__PhysicalThread__Group_3_2__0__Impl : ( 'prio' ) ;
    public final void rule__PhysicalThread__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3025:1: ( ( 'prio' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3026:1: ( 'prio' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3026:1: ( 'prio' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3027:1: 'prio'
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioKeyword_3_2_0()); 
            match(input,41,FOLLOW_41_in_rule__PhysicalThread__Group_3_2__0__Impl6167); 
             after(grammarAccess.getPhysicalThreadAccess().getPrioKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3040:1: rule__PhysicalThread__Group_3_2__1 : rule__PhysicalThread__Group_3_2__1__Impl rule__PhysicalThread__Group_3_2__2 ;
    public final void rule__PhysicalThread__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3044:1: ( rule__PhysicalThread__Group_3_2__1__Impl rule__PhysicalThread__Group_3_2__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3045:2: rule__PhysicalThread__Group_3_2__1__Impl rule__PhysicalThread__Group_3_2__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__1__Impl_in_rule__PhysicalThread__Group_3_2__16198);
            rule__PhysicalThread__Group_3_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__2_in_rule__PhysicalThread__Group_3_2__16201);
            rule__PhysicalThread__Group_3_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3052:1: rule__PhysicalThread__Group_3_2__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3056:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3057:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3057:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3058:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_2_1()); 
            match(input,36,FOLLOW_36_in_rule__PhysicalThread__Group_3_2__1__Impl6229); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3071:1: rule__PhysicalThread__Group_3_2__2 : rule__PhysicalThread__Group_3_2__2__Impl ;
    public final void rule__PhysicalThread__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3075:1: ( rule__PhysicalThread__Group_3_2__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3076:2: rule__PhysicalThread__Group_3_2__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__2__Impl_in_rule__PhysicalThread__Group_3_2__26260);
            rule__PhysicalThread__Group_3_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_2__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3082:1: rule__PhysicalThread__Group_3_2__2__Impl : ( ( rule__PhysicalThread__PrioAssignment_3_2_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3086:1: ( ( ( rule__PhysicalThread__PrioAssignment_3_2_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3087:1: ( ( rule__PhysicalThread__PrioAssignment_3_2_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3087:1: ( ( rule__PhysicalThread__PrioAssignment_3_2_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3088:1: ( rule__PhysicalThread__PrioAssignment_3_2_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_3_2_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3089:1: ( rule__PhysicalThread__PrioAssignment_3_2_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3089:2: rule__PhysicalThread__PrioAssignment_3_2_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__PrioAssignment_3_2_2_in_rule__PhysicalThread__Group_3_2__2__Impl6287);
            rule__PhysicalThread__PrioAssignment_3_2_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getPrioAssignment_3_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_2__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3105:1: rule__PhysicalThread__Group_3_3__0 : rule__PhysicalThread__Group_3_3__0__Impl rule__PhysicalThread__Group_3_3__1 ;
    public final void rule__PhysicalThread__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3109:1: ( rule__PhysicalThread__Group_3_3__0__Impl rule__PhysicalThread__Group_3_3__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3110:2: rule__PhysicalThread__Group_3_3__0__Impl rule__PhysicalThread__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__0__Impl_in_rule__PhysicalThread__Group_3_3__06323);
            rule__PhysicalThread__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__1_in_rule__PhysicalThread__Group_3_3__06326);
            rule__PhysicalThread__Group_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3117:1: rule__PhysicalThread__Group_3_3__0__Impl : ( 'stacksize' ) ;
    public final void rule__PhysicalThread__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3121:1: ( ( 'stacksize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3122:1: ( 'stacksize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3122:1: ( 'stacksize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3123:1: 'stacksize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_3_3_0()); 
            match(input,42,FOLLOW_42_in_rule__PhysicalThread__Group_3_3__0__Impl6354); 
             after(grammarAccess.getPhysicalThreadAccess().getStacksizeKeyword_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3136:1: rule__PhysicalThread__Group_3_3__1 : rule__PhysicalThread__Group_3_3__1__Impl rule__PhysicalThread__Group_3_3__2 ;
    public final void rule__PhysicalThread__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3140:1: ( rule__PhysicalThread__Group_3_3__1__Impl rule__PhysicalThread__Group_3_3__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3141:2: rule__PhysicalThread__Group_3_3__1__Impl rule__PhysicalThread__Group_3_3__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__1__Impl_in_rule__PhysicalThread__Group_3_3__16385);
            rule__PhysicalThread__Group_3_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__2_in_rule__PhysicalThread__Group_3_3__16388);
            rule__PhysicalThread__Group_3_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3148:1: rule__PhysicalThread__Group_3_3__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3152:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3153:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3153:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3154:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_3_1()); 
            match(input,36,FOLLOW_36_in_rule__PhysicalThread__Group_3_3__1__Impl6416); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3167:1: rule__PhysicalThread__Group_3_3__2 : rule__PhysicalThread__Group_3_3__2__Impl ;
    public final void rule__PhysicalThread__Group_3_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3171:1: ( rule__PhysicalThread__Group_3_3__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3172:2: rule__PhysicalThread__Group_3_3__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__2__Impl_in_rule__PhysicalThread__Group_3_3__26447);
            rule__PhysicalThread__Group_3_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_3__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3178:1: rule__PhysicalThread__Group_3_3__2__Impl : ( ( rule__PhysicalThread__StacksizeAssignment_3_3_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3182:1: ( ( ( rule__PhysicalThread__StacksizeAssignment_3_3_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3183:1: ( ( rule__PhysicalThread__StacksizeAssignment_3_3_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3183:1: ( ( rule__PhysicalThread__StacksizeAssignment_3_3_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3184:1: ( rule__PhysicalThread__StacksizeAssignment_3_3_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_3_3_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3185:1: ( rule__PhysicalThread__StacksizeAssignment_3_3_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3185:2: rule__PhysicalThread__StacksizeAssignment_3_3_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__StacksizeAssignment_3_3_2_in_rule__PhysicalThread__Group_3_3__2__Impl6474);
            rule__PhysicalThread__StacksizeAssignment_3_3_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getStacksizeAssignment_3_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_3__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3201:1: rule__PhysicalThread__Group_3_4__0 : rule__PhysicalThread__Group_3_4__0__Impl rule__PhysicalThread__Group_3_4__1 ;
    public final void rule__PhysicalThread__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3205:1: ( rule__PhysicalThread__Group_3_4__0__Impl rule__PhysicalThread__Group_3_4__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3206:2: rule__PhysicalThread__Group_3_4__0__Impl rule__PhysicalThread__Group_3_4__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__0__Impl_in_rule__PhysicalThread__Group_3_4__06510);
            rule__PhysicalThread__Group_3_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__1_in_rule__PhysicalThread__Group_3_4__06513);
            rule__PhysicalThread__Group_3_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3213:1: rule__PhysicalThread__Group_3_4__0__Impl : ( 'msgblocksize' ) ;
    public final void rule__PhysicalThread__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3217:1: ( ( 'msgblocksize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3218:1: ( 'msgblocksize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3218:1: ( 'msgblocksize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3219:1: 'msgblocksize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_3_4_0()); 
            match(input,43,FOLLOW_43_in_rule__PhysicalThread__Group_3_4__0__Impl6541); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeKeyword_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3232:1: rule__PhysicalThread__Group_3_4__1 : rule__PhysicalThread__Group_3_4__1__Impl rule__PhysicalThread__Group_3_4__2 ;
    public final void rule__PhysicalThread__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3236:1: ( rule__PhysicalThread__Group_3_4__1__Impl rule__PhysicalThread__Group_3_4__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3237:2: rule__PhysicalThread__Group_3_4__1__Impl rule__PhysicalThread__Group_3_4__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__1__Impl_in_rule__PhysicalThread__Group_3_4__16572);
            rule__PhysicalThread__Group_3_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__2_in_rule__PhysicalThread__Group_3_4__16575);
            rule__PhysicalThread__Group_3_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3244:1: rule__PhysicalThread__Group_3_4__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3248:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3249:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3249:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3250:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_4_1()); 
            match(input,36,FOLLOW_36_in_rule__PhysicalThread__Group_3_4__1__Impl6603); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3263:1: rule__PhysicalThread__Group_3_4__2 : rule__PhysicalThread__Group_3_4__2__Impl ;
    public final void rule__PhysicalThread__Group_3_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3267:1: ( rule__PhysicalThread__Group_3_4__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3268:2: rule__PhysicalThread__Group_3_4__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__2__Impl_in_rule__PhysicalThread__Group_3_4__26634);
            rule__PhysicalThread__Group_3_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_4__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3274:1: rule__PhysicalThread__Group_3_4__2__Impl : ( ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3278:1: ( ( ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3279:1: ( ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3279:1: ( ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3280:1: ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_3_4_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3281:1: ( rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3281:2: rule__PhysicalThread__MsgblocksizeAssignment_3_4_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__MsgblocksizeAssignment_3_4_2_in_rule__PhysicalThread__Group_3_4__2__Impl6661);
            rule__PhysicalThread__MsgblocksizeAssignment_3_4_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeAssignment_3_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_4__2__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3297:1: rule__PhysicalThread__Group_3_5__0 : rule__PhysicalThread__Group_3_5__0__Impl rule__PhysicalThread__Group_3_5__1 ;
    public final void rule__PhysicalThread__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3301:1: ( rule__PhysicalThread__Group_3_5__0__Impl rule__PhysicalThread__Group_3_5__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3302:2: rule__PhysicalThread__Group_3_5__0__Impl rule__PhysicalThread__Group_3_5__1
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__0__Impl_in_rule__PhysicalThread__Group_3_5__06697);
            rule__PhysicalThread__Group_3_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__1_in_rule__PhysicalThread__Group_3_5__06700);
            rule__PhysicalThread__Group_3_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__0"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3309:1: rule__PhysicalThread__Group_3_5__0__Impl : ( 'msgpoolsize' ) ;
    public final void rule__PhysicalThread__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3313:1: ( ( 'msgpoolsize' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3314:1: ( 'msgpoolsize' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3314:1: ( 'msgpoolsize' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3315:1: 'msgpoolsize'
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_3_5_0()); 
            match(input,44,FOLLOW_44_in_rule__PhysicalThread__Group_3_5__0__Impl6728); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeKeyword_3_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__0__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3328:1: rule__PhysicalThread__Group_3_5__1 : rule__PhysicalThread__Group_3_5__1__Impl rule__PhysicalThread__Group_3_5__2 ;
    public final void rule__PhysicalThread__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3332:1: ( rule__PhysicalThread__Group_3_5__1__Impl rule__PhysicalThread__Group_3_5__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3333:2: rule__PhysicalThread__Group_3_5__1__Impl rule__PhysicalThread__Group_3_5__2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__1__Impl_in_rule__PhysicalThread__Group_3_5__16759);
            rule__PhysicalThread__Group_3_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__2_in_rule__PhysicalThread__Group_3_5__16762);
            rule__PhysicalThread__Group_3_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__1"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3340:1: rule__PhysicalThread__Group_3_5__1__Impl : ( '=' ) ;
    public final void rule__PhysicalThread__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3344:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3345:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3345:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3346:1: '='
            {
             before(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_5_1()); 
            match(input,36,FOLLOW_36_in_rule__PhysicalThread__Group_3_5__1__Impl6790); 
             after(grammarAccess.getPhysicalThreadAccess().getEqualsSignKeyword_3_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__1__Impl"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3359:1: rule__PhysicalThread__Group_3_5__2 : rule__PhysicalThread__Group_3_5__2__Impl ;
    public final void rule__PhysicalThread__Group_3_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3363:1: ( rule__PhysicalThread__Group_3_5__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3364:2: rule__PhysicalThread__Group_3_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__2__Impl_in_rule__PhysicalThread__Group_3_5__26821);
            rule__PhysicalThread__Group_3_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__2"


    // $ANTLR start "rule__PhysicalThread__Group_3_5__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3370:1: rule__PhysicalThread__Group_3_5__2__Impl : ( ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 ) ) ;
    public final void rule__PhysicalThread__Group_3_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3374:1: ( ( ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3375:1: ( ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3375:1: ( ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3376:1: ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 )
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_3_5_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3377:1: ( rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3377:2: rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2
            {
            pushFollow(FOLLOW_rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2_in_rule__PhysicalThread__Group_3_5__2__Impl6848);
            rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2();

            state._fsp--;


            }

             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeAssignment_3_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__Group_3_5__2__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3393:1: rule__RuntimeClass__Group__0 : rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1 ;
    public final void rule__RuntimeClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3397:1: ( rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3398:2: rule__RuntimeClass__Group__0__Impl rule__RuntimeClass__Group__1
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__0__Impl_in_rule__RuntimeClass__Group__06884);
            rule__RuntimeClass__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__1_in_rule__RuntimeClass__Group__06887);
            rule__RuntimeClass__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__0"


    // $ANTLR start "rule__RuntimeClass__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3405:1: rule__RuntimeClass__Group__0__Impl : ( 'RuntimeClass' ) ;
    public final void rule__RuntimeClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3409:1: ( ( 'RuntimeClass' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3410:1: ( 'RuntimeClass' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3410:1: ( 'RuntimeClass' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3411:1: 'RuntimeClass'
            {
             before(grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0()); 
            match(input,45,FOLLOW_45_in_rule__RuntimeClass__Group__0__Impl6915); 
             after(grammarAccess.getRuntimeClassAccess().getRuntimeClassKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__0__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3424:1: rule__RuntimeClass__Group__1 : rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2 ;
    public final void rule__RuntimeClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3428:1: ( rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3429:2: rule__RuntimeClass__Group__1__Impl rule__RuntimeClass__Group__2
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__1__Impl_in_rule__RuntimeClass__Group__16946);
            rule__RuntimeClass__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__2_in_rule__RuntimeClass__Group__16949);
            rule__RuntimeClass__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__1"


    // $ANTLR start "rule__RuntimeClass__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3436:1: rule__RuntimeClass__Group__1__Impl : ( ( rule__RuntimeClass__NameAssignment_1 ) ) ;
    public final void rule__RuntimeClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3440:1: ( ( ( rule__RuntimeClass__NameAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3441:1: ( ( rule__RuntimeClass__NameAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3441:1: ( ( rule__RuntimeClass__NameAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3442:1: ( rule__RuntimeClass__NameAssignment_1 )
            {
             before(grammarAccess.getRuntimeClassAccess().getNameAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3443:1: ( rule__RuntimeClass__NameAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3443:2: rule__RuntimeClass__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RuntimeClass__NameAssignment_1_in_rule__RuntimeClass__Group__1__Impl6976);
            rule__RuntimeClass__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRuntimeClassAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__1__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3453:1: rule__RuntimeClass__Group__2 : rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3 ;
    public final void rule__RuntimeClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3457:1: ( rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3458:2: rule__RuntimeClass__Group__2__Impl rule__RuntimeClass__Group__3
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__2__Impl_in_rule__RuntimeClass__Group__27006);
            rule__RuntimeClass__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__3_in_rule__RuntimeClass__Group__27009);
            rule__RuntimeClass__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__2"


    // $ANTLR start "rule__RuntimeClass__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3465:1: rule__RuntimeClass__Group__2__Impl : ( ( rule__RuntimeClass__DocuAssignment_2 )? ) ;
    public final void rule__RuntimeClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3469:1: ( ( ( rule__RuntimeClass__DocuAssignment_2 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3470:1: ( ( rule__RuntimeClass__DocuAssignment_2 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3470:1: ( ( rule__RuntimeClass__DocuAssignment_2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3471:1: ( rule__RuntimeClass__DocuAssignment_2 )?
            {
             before(grammarAccess.getRuntimeClassAccess().getDocuAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3472:1: ( rule__RuntimeClass__DocuAssignment_2 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==52) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3472:2: rule__RuntimeClass__DocuAssignment_2
                    {
                    pushFollow(FOLLOW_rule__RuntimeClass__DocuAssignment_2_in_rule__RuntimeClass__Group__2__Impl7036);
                    rule__RuntimeClass__DocuAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuntimeClassAccess().getDocuAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__2__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3482:1: rule__RuntimeClass__Group__3 : rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4 ;
    public final void rule__RuntimeClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3486:1: ( rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3487:2: rule__RuntimeClass__Group__3__Impl rule__RuntimeClass__Group__4
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__3__Impl_in_rule__RuntimeClass__Group__37067);
            rule__RuntimeClass__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__4_in_rule__RuntimeClass__Group__37070);
            rule__RuntimeClass__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__3"


    // $ANTLR start "rule__RuntimeClass__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3494:1: rule__RuntimeClass__Group__3__Impl : ( '{' ) ;
    public final void rule__RuntimeClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3498:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3499:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3499:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3500:1: '{'
            {
             before(grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__RuntimeClass__Group__3__Impl7098); 
             after(grammarAccess.getRuntimeClassAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__3__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3513:1: rule__RuntimeClass__Group__4 : rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5 ;
    public final void rule__RuntimeClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3517:1: ( rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3518:2: rule__RuntimeClass__Group__4__Impl rule__RuntimeClass__Group__5
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__4__Impl_in_rule__RuntimeClass__Group__47129);
            rule__RuntimeClass__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__5_in_rule__RuntimeClass__Group__47132);
            rule__RuntimeClass__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__4"


    // $ANTLR start "rule__RuntimeClass__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3525:1: rule__RuntimeClass__Group__4__Impl : ( 'model' ) ;
    public final void rule__RuntimeClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3529:1: ( ( 'model' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3530:1: ( 'model' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3530:1: ( 'model' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3531:1: 'model'
            {
             before(grammarAccess.getRuntimeClassAccess().getModelKeyword_4()); 
            match(input,16,FOLLOW_16_in_rule__RuntimeClass__Group__4__Impl7160); 
             after(grammarAccess.getRuntimeClassAccess().getModelKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__4__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3544:1: rule__RuntimeClass__Group__5 : rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6 ;
    public final void rule__RuntimeClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3548:1: ( rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3549:2: rule__RuntimeClass__Group__5__Impl rule__RuntimeClass__Group__6
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__5__Impl_in_rule__RuntimeClass__Group__57191);
            rule__RuntimeClass__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__6_in_rule__RuntimeClass__Group__57194);
            rule__RuntimeClass__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__5"


    // $ANTLR start "rule__RuntimeClass__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3556:1: rule__RuntimeClass__Group__5__Impl : ( '=' ) ;
    public final void rule__RuntimeClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3560:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3561:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3561:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3562:1: '='
            {
             before(grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__RuntimeClass__Group__5__Impl7222); 
             after(grammarAccess.getRuntimeClassAccess().getEqualsSignKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__5__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3575:1: rule__RuntimeClass__Group__6 : rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7 ;
    public final void rule__RuntimeClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3579:1: ( rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3580:2: rule__RuntimeClass__Group__6__Impl rule__RuntimeClass__Group__7
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__6__Impl_in_rule__RuntimeClass__Group__67253);
            rule__RuntimeClass__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuntimeClass__Group__7_in_rule__RuntimeClass__Group__67256);
            rule__RuntimeClass__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__6"


    // $ANTLR start "rule__RuntimeClass__Group__6__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3587:1: rule__RuntimeClass__Group__6__Impl : ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) ) ;
    public final void rule__RuntimeClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3591:1: ( ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3592:1: ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3592:1: ( ( rule__RuntimeClass__ThreadModelAssignment_6 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3593:1: ( rule__RuntimeClass__ThreadModelAssignment_6 )
            {
             before(grammarAccess.getRuntimeClassAccess().getThreadModelAssignment_6()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3594:1: ( rule__RuntimeClass__ThreadModelAssignment_6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3594:2: rule__RuntimeClass__ThreadModelAssignment_6
            {
            pushFollow(FOLLOW_rule__RuntimeClass__ThreadModelAssignment_6_in_rule__RuntimeClass__Group__6__Impl7283);
            rule__RuntimeClass__ThreadModelAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getRuntimeClassAccess().getThreadModelAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__6__Impl"


    // $ANTLR start "rule__RuntimeClass__Group__7"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3604:1: rule__RuntimeClass__Group__7 : rule__RuntimeClass__Group__7__Impl ;
    public final void rule__RuntimeClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3608:1: ( rule__RuntimeClass__Group__7__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3609:2: rule__RuntimeClass__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__RuntimeClass__Group__7__Impl_in_rule__RuntimeClass__Group__77313);
            rule__RuntimeClass__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__7"


    // $ANTLR start "rule__RuntimeClass__Group__7__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3615:1: rule__RuntimeClass__Group__7__Impl : ( '}' ) ;
    public final void rule__RuntimeClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3619:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3620:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3620:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3621:1: '}'
            {
             before(grammarAccess.getRuntimeClassAccess().getRightCurlyBracketKeyword_7()); 
            match(input,30,FOLLOW_30_in_rule__RuntimeClass__Group__7__Impl7341); 
             after(grammarAccess.getRuntimeClassAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__Group__7__Impl"


    // $ANTLR start "rule__PRIO__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3650:1: rule__PRIO__Group__0 : rule__PRIO__Group__0__Impl rule__PRIO__Group__1 ;
    public final void rule__PRIO__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3654:1: ( rule__PRIO__Group__0__Impl rule__PRIO__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3655:2: rule__PRIO__Group__0__Impl rule__PRIO__Group__1
            {
            pushFollow(FOLLOW_rule__PRIO__Group__0__Impl_in_rule__PRIO__Group__07388);
            rule__PRIO__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PRIO__Group__1_in_rule__PRIO__Group__07391);
            rule__PRIO__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Group__0"


    // $ANTLR start "rule__PRIO__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3662:1: rule__PRIO__Group__0__Impl : ( ( rule__PRIO__Alternatives_0 )? ) ;
    public final void rule__PRIO__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3666:1: ( ( ( rule__PRIO__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3667:1: ( ( rule__PRIO__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3667:1: ( ( rule__PRIO__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3668:1: ( rule__PRIO__Alternatives_0 )?
            {
             before(grammarAccess.getPRIOAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3669:1: ( rule__PRIO__Alternatives_0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=14 && LA30_0<=15)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3669:2: rule__PRIO__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__PRIO__Alternatives_0_in_rule__PRIO__Group__0__Impl7418);
                    rule__PRIO__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPRIOAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Group__0__Impl"


    // $ANTLR start "rule__PRIO__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3679:1: rule__PRIO__Group__1 : rule__PRIO__Group__1__Impl ;
    public final void rule__PRIO__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3683:1: ( rule__PRIO__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3684:2: rule__PRIO__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PRIO__Group__1__Impl_in_rule__PRIO__Group__17449);
            rule__PRIO__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Group__1"


    // $ANTLR start "rule__PRIO__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3690:1: rule__PRIO__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__PRIO__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3694:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3695:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3695:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3696:1: RULE_INT
            {
             before(grammarAccess.getPRIOAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PRIO__Group__1__Impl7476); 
             after(grammarAccess.getPRIOAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PRIO__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3711:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3715:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3716:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__07509);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__07512);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3723:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3727:1: ( ( 'import' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3728:1: ( 'import' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3728:1: ( 'import' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3729:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__Import__Group__0__Impl7540); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3742:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3746:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3747:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__17571);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__17574);
            rule__Import__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3754:1: rule__Import__Group__1__Impl : ( ( rule__Import__Alternatives_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3758:1: ( ( ( rule__Import__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3759:1: ( ( rule__Import__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3759:1: ( ( rule__Import__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3760:1: ( rule__Import__Alternatives_1 )
            {
             before(grammarAccess.getImportAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3761:1: ( rule__Import__Alternatives_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3761:2: rule__Import__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl7601);
            rule__Import__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3771:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3775:1: ( rule__Import__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3776:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__27631);
            rule__Import__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2"


    // $ANTLR start "rule__Import__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3782:1: rule__Import__Group__2__Impl : ( ( rule__Import__ImportURIAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3786:1: ( ( ( rule__Import__ImportURIAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3787:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3787:1: ( ( rule__Import__ImportURIAssignment_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3788:1: ( rule__Import__ImportURIAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3789:1: ( rule__Import__ImportURIAssignment_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3789:2: rule__Import__ImportURIAssignment_2
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl7658);
            rule__Import__ImportURIAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2__Impl"


    // $ANTLR start "rule__Import__Group_1_0__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3805:1: rule__Import__Group_1_0__0 : rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 ;
    public final void rule__Import__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3809:1: ( rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3810:2: rule__Import__Group_1_0__0__Impl rule__Import__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__07694);
            rule__Import__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__07697);
            rule__Import__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_0__0"


    // $ANTLR start "rule__Import__Group_1_0__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3817:1: rule__Import__Group_1_0__0__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) ;
    public final void rule__Import__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3821:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3822:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3822:1: ( ( rule__Import__ImportedNamespaceAssignment_1_0_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3823:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3824:1: ( rule__Import__ImportedNamespaceAssignment_1_0_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3824:2: rule__Import__ImportedNamespaceAssignment_1_0_0
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl7724);
            rule__Import__ImportedNamespaceAssignment_1_0_0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_0__0__Impl"


    // $ANTLR start "rule__Import__Group_1_0__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3834:1: rule__Import__Group_1_0__1 : rule__Import__Group_1_0__1__Impl ;
    public final void rule__Import__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3838:1: ( rule__Import__Group_1_0__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3839:2: rule__Import__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__17754);
            rule__Import__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_0__1"


    // $ANTLR start "rule__Import__Group_1_0__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3845:1: rule__Import__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__Import__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3849:1: ( ( 'from' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3850:1: ( 'from' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3850:1: ( 'from' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3851:1: 'from'
            {
             before(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 
            match(input,47,FOLLOW_47_in_rule__Import__Group_1_0__1__Impl7782); 
             after(grammarAccess.getImportAccess().getFromKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_1_0__1__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3868:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3872:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3873:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__07817);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__07820);
            rule__ImportedFQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0"


    // $ANTLR start "rule__ImportedFQN__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3880:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3884:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3885:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3885:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3886:1: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl7847);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3897:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3901:1: ( rule__ImportedFQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3902:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__17876);
            rule__ImportedFQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1"


    // $ANTLR start "rule__ImportedFQN__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3908:1: rule__ImportedFQN__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3912:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3913:1: ( ( '.*' )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3913:1: ( ( '.*' )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3914:1: ( '.*' )?
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3915:1: ( '.*' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==48) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3916:2: '.*'
                    {
                    match(input,48,FOLLOW_48_in_rule__ImportedFQN__Group__1__Impl7905); 

                    }
                    break;

            }

             after(grammarAccess.getImportedFQNAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3931:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3935:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3936:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__07942);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__07945);
            rule__FQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3943:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3947:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3948:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3948:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3949:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl7972); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3960:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3964:1: ( rule__FQN__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3965:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__18001);
            rule__FQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3971:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3975:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3976:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3976:1: ( ( rule__FQN__Group_1__0 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3977:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3978:1: ( rule__FQN__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==49) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3978:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl8028);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3992:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3996:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:3997:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__08063);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__08066);
            rule__FQN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4004:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4008:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4009:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4009:1: ( '.' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4010:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,49,FOLLOW_49_in_rule__FQN__Group_1__0__Impl8094); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4023:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4027:1: ( rule__FQN__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4028:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__18125);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4034:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4038:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4039:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4039:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4040:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl8152); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4058:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4062:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4063:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__08188);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__08191);
            rule__KeyValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__0"


    // $ANTLR start "rule__KeyValue__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4070:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4074:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4075:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4075:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4076:1: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4077:1: ( rule__KeyValue__KeyAssignment_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4077:2: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl8218);
            rule__KeyValue__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__0__Impl"


    // $ANTLR start "rule__KeyValue__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4087:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4091:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4092:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__18248);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__18251);
            rule__KeyValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__1"


    // $ANTLR start "rule__KeyValue__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4099:1: rule__KeyValue__Group__1__Impl : ( '=' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4103:1: ( ( '=' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4104:1: ( '=' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4104:1: ( '=' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4105:1: '='
            {
             before(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__KeyValue__Group__1__Impl8279); 
             after(grammarAccess.getKeyValueAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4118:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4122:1: ( rule__KeyValue__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4123:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__28310);
            rule__KeyValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__2"


    // $ANTLR start "rule__KeyValue__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4129:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4133:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4134:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4134:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4135:1: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4136:1: ( rule__KeyValue__ValueAssignment_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4136:2: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl8337);
            rule__KeyValue__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__2__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4155:1: rule__SimpleAnnotationAttribute__Group__0 : rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 ;
    public final void rule__SimpleAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4159:1: ( rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4160:2: rule__SimpleAnnotationAttribute__Group__0__Impl rule__SimpleAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__08376);
            rule__SimpleAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__08379);
            rule__SimpleAnnotationAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__0"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4167:1: rule__SimpleAnnotationAttribute__Group__0__Impl : ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4171:1: ( ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4172:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4172:1: ( ( rule__SimpleAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4173:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4174:1: ( rule__SimpleAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4174:2: rule__SimpleAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl8406);
            rule__SimpleAnnotationAttribute__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__0__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4184:1: rule__SimpleAnnotationAttribute__Group__1 : rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 ;
    public final void rule__SimpleAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4188:1: ( rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4189:2: rule__SimpleAnnotationAttribute__Group__1__Impl rule__SimpleAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__18436);
            rule__SimpleAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__18439);
            rule__SimpleAnnotationAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__1"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4196:1: rule__SimpleAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4200:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4201:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4201:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4202:1: 'attribute'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,50,FOLLOW_50_in_rule__SimpleAnnotationAttribute__Group__1__Impl8467); 
             after(grammarAccess.getSimpleAnnotationAttributeAccess().getAttributeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__1__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4215:1: rule__SimpleAnnotationAttribute__Group__2 : rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 ;
    public final void rule__SimpleAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4219:1: ( rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4220:2: rule__SimpleAnnotationAttribute__Group__2__Impl rule__SimpleAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__28498);
            rule__SimpleAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__28501);
            rule__SimpleAnnotationAttribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__2"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4227:1: rule__SimpleAnnotationAttribute__Group__2__Impl : ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4231:1: ( ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4232:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4232:1: ( ( rule__SimpleAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4233:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4234:1: ( rule__SimpleAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4234:2: rule__SimpleAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl8528);
            rule__SimpleAnnotationAttribute__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__2__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4244:1: rule__SimpleAnnotationAttribute__Group__3 : rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 ;
    public final void rule__SimpleAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4248:1: ( rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4249:2: rule__SimpleAnnotationAttribute__Group__3__Impl rule__SimpleAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__38558);
            rule__SimpleAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__38561);
            rule__SimpleAnnotationAttribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__3"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4256:1: rule__SimpleAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4260:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4261:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4261:1: ( ':' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4262:1: ':'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,33,FOLLOW_33_in_rule__SimpleAnnotationAttribute__Group__3__Impl8589); 
             after(grammarAccess.getSimpleAnnotationAttributeAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__3__Impl"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4275:1: rule__SimpleAnnotationAttribute__Group__4 : rule__SimpleAnnotationAttribute__Group__4__Impl ;
    public final void rule__SimpleAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4279:1: ( rule__SimpleAnnotationAttribute__Group__4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4280:2: rule__SimpleAnnotationAttribute__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__48620);
            rule__SimpleAnnotationAttribute__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__4"


    // $ANTLR start "rule__SimpleAnnotationAttribute__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4286:1: rule__SimpleAnnotationAttribute__Group__4__Impl : ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) ;
    public final void rule__SimpleAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4290:1: ( ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4291:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4291:1: ( ( rule__SimpleAnnotationAttribute__TypeAssignment_4 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4292:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4293:1: ( rule__SimpleAnnotationAttribute__TypeAssignment_4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4293:2: rule__SimpleAnnotationAttribute__TypeAssignment_4
            {
            pushFollow(FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl8647);
            rule__SimpleAnnotationAttribute__TypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__Group__4__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4313:1: rule__EnumAnnotationAttribute__Group__0 : rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 ;
    public final void rule__EnumAnnotationAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4317:1: ( rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4318:2: rule__EnumAnnotationAttribute__Group__0__Impl rule__EnumAnnotationAttribute__Group__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__08687);
            rule__EnumAnnotationAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__08690);
            rule__EnumAnnotationAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__0"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4325:1: rule__EnumAnnotationAttribute__Group__0__Impl : ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4329:1: ( ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4330:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4330:1: ( ( rule__EnumAnnotationAttribute__Alternatives_0 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4331:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4332:1: ( rule__EnumAnnotationAttribute__Alternatives_0 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4332:2: rule__EnumAnnotationAttribute__Alternatives_0
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl8717);
            rule__EnumAnnotationAttribute__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__0__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4342:1: rule__EnumAnnotationAttribute__Group__1 : rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 ;
    public final void rule__EnumAnnotationAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4346:1: ( rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4347:2: rule__EnumAnnotationAttribute__Group__1__Impl rule__EnumAnnotationAttribute__Group__2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__18747);
            rule__EnumAnnotationAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__18750);
            rule__EnumAnnotationAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__1"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4354:1: rule__EnumAnnotationAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__EnumAnnotationAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4358:1: ( ( 'attribute' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4359:1: ( 'attribute' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4359:1: ( 'attribute' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4360:1: 'attribute'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 
            match(input,50,FOLLOW_50_in_rule__EnumAnnotationAttribute__Group__1__Impl8778); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getAttributeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__1__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4373:1: rule__EnumAnnotationAttribute__Group__2 : rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 ;
    public final void rule__EnumAnnotationAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4377:1: ( rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4378:2: rule__EnumAnnotationAttribute__Group__2__Impl rule__EnumAnnotationAttribute__Group__3
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__28809);
            rule__EnumAnnotationAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__28812);
            rule__EnumAnnotationAttribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__2"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4385:1: rule__EnumAnnotationAttribute__Group__2__Impl : ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4389:1: ( ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4390:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4390:1: ( ( rule__EnumAnnotationAttribute__NameAssignment_2 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4391:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4392:1: ( rule__EnumAnnotationAttribute__NameAssignment_2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4392:2: rule__EnumAnnotationAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl8839);
            rule__EnumAnnotationAttribute__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__2__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4402:1: rule__EnumAnnotationAttribute__Group__3 : rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 ;
    public final void rule__EnumAnnotationAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4406:1: ( rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4407:2: rule__EnumAnnotationAttribute__Group__3__Impl rule__EnumAnnotationAttribute__Group__4
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__38869);
            rule__EnumAnnotationAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__38872);
            rule__EnumAnnotationAttribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__3"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4414:1: rule__EnumAnnotationAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumAnnotationAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4418:1: ( ( ':' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4419:1: ( ':' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4419:1: ( ':' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4420:1: ':'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 
            match(input,33,FOLLOW_33_in_rule__EnumAnnotationAttribute__Group__3__Impl8900); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__3__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4433:1: rule__EnumAnnotationAttribute__Group__4 : rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 ;
    public final void rule__EnumAnnotationAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4437:1: ( rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4438:2: rule__EnumAnnotationAttribute__Group__4__Impl rule__EnumAnnotationAttribute__Group__5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__48931);
            rule__EnumAnnotationAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__48934);
            rule__EnumAnnotationAttribute__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__4"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4445:1: rule__EnumAnnotationAttribute__Group__4__Impl : ( '{' ) ;
    public final void rule__EnumAnnotationAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4449:1: ( ( '{' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4450:1: ( '{' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4450:1: ( '{' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4451:1: '{'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,29,FOLLOW_29_in_rule__EnumAnnotationAttribute__Group__4__Impl8962); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__4__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4464:1: rule__EnumAnnotationAttribute__Group__5 : rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 ;
    public final void rule__EnumAnnotationAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4468:1: ( rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4469:2: rule__EnumAnnotationAttribute__Group__5__Impl rule__EnumAnnotationAttribute__Group__6
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__58993);
            rule__EnumAnnotationAttribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__58996);
            rule__EnumAnnotationAttribute__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__5"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__5__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4476:1: rule__EnumAnnotationAttribute__Group__5__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4480:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4481:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4481:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_5 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4482:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4483:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_5 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4483:2: rule__EnumAnnotationAttribute__ValuesAssignment_5
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl9023);
            rule__EnumAnnotationAttribute__ValuesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__5__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4493:1: rule__EnumAnnotationAttribute__Group__6 : rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 ;
    public final void rule__EnumAnnotationAttribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4497:1: ( rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4498:2: rule__EnumAnnotationAttribute__Group__6__Impl rule__EnumAnnotationAttribute__Group__7
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__69053);
            rule__EnumAnnotationAttribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__69056);
            rule__EnumAnnotationAttribute__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__6"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__6__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4505:1: rule__EnumAnnotationAttribute__Group__6__Impl : ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) ;
    public final void rule__EnumAnnotationAttribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4509:1: ( ( ( rule__EnumAnnotationAttribute__Group_6__0 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4510:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4510:1: ( ( rule__EnumAnnotationAttribute__Group_6__0 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4511:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4512:1: ( rule__EnumAnnotationAttribute__Group_6__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==51) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4512:2: rule__EnumAnnotationAttribute__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl9083);
            	    rule__EnumAnnotationAttribute__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__6__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__7"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4522:1: rule__EnumAnnotationAttribute__Group__7 : rule__EnumAnnotationAttribute__Group__7__Impl ;
    public final void rule__EnumAnnotationAttribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4526:1: ( rule__EnumAnnotationAttribute__Group__7__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4527:2: rule__EnumAnnotationAttribute__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__79114);
            rule__EnumAnnotationAttribute__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__7"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group__7__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4533:1: rule__EnumAnnotationAttribute__Group__7__Impl : ( '}' ) ;
    public final void rule__EnumAnnotationAttribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4537:1: ( ( '}' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4538:1: ( '}' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4538:1: ( '}' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4539:1: '}'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,30,FOLLOW_30_in_rule__EnumAnnotationAttribute__Group__7__Impl9142); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group__7__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group_6__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4568:1: rule__EnumAnnotationAttribute__Group_6__0 : rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 ;
    public final void rule__EnumAnnotationAttribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4572:1: ( rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4573:2: rule__EnumAnnotationAttribute__Group_6__0__Impl rule__EnumAnnotationAttribute__Group_6__1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__09189);
            rule__EnumAnnotationAttribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__09192);
            rule__EnumAnnotationAttribute__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group_6__0"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group_6__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4580:1: rule__EnumAnnotationAttribute__Group_6__0__Impl : ( ',' ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4584:1: ( ( ',' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4585:1: ( ',' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4585:1: ( ',' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4586:1: ','
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 
            match(input,51,FOLLOW_51_in_rule__EnumAnnotationAttribute__Group_6__0__Impl9220); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group_6__0__Impl"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group_6__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4599:1: rule__EnumAnnotationAttribute__Group_6__1 : rule__EnumAnnotationAttribute__Group_6__1__Impl ;
    public final void rule__EnumAnnotationAttribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4603:1: ( rule__EnumAnnotationAttribute__Group_6__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4604:2: rule__EnumAnnotationAttribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__19251);
            rule__EnumAnnotationAttribute__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group_6__1"


    // $ANTLR start "rule__EnumAnnotationAttribute__Group_6__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4610:1: rule__EnumAnnotationAttribute__Group_6__1__Impl : ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) ;
    public final void rule__EnumAnnotationAttribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4614:1: ( ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4615:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4615:1: ( ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4616:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4617:1: ( rule__EnumAnnotationAttribute__ValuesAssignment_6_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4617:2: rule__EnumAnnotationAttribute__ValuesAssignment_6_1
            {
            pushFollow(FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl9278);
            rule__EnumAnnotationAttribute__ValuesAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__Group_6__1__Impl"


    // $ANTLR start "rule__Documentation__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4631:1: rule__Documentation__Group__0 : rule__Documentation__Group__0__Impl rule__Documentation__Group__1 ;
    public final void rule__Documentation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4635:1: ( rule__Documentation__Group__0__Impl rule__Documentation__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4636:2: rule__Documentation__Group__0__Impl rule__Documentation__Group__1
            {
            pushFollow(FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__09312);
            rule__Documentation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__09315);
            rule__Documentation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__0"


    // $ANTLR start "rule__Documentation__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4643:1: rule__Documentation__Group__0__Impl : ( () ) ;
    public final void rule__Documentation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4647:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4648:1: ( () )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4648:1: ( () )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4649:1: ()
            {
             before(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4650:1: ()
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4652:1: 
            {
            }

             after(grammarAccess.getDocumentationAccess().getDocumentationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__0__Impl"


    // $ANTLR start "rule__Documentation__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4662:1: rule__Documentation__Group__1 : rule__Documentation__Group__1__Impl rule__Documentation__Group__2 ;
    public final void rule__Documentation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4666:1: ( rule__Documentation__Group__1__Impl rule__Documentation__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4667:2: rule__Documentation__Group__1__Impl rule__Documentation__Group__2
            {
            pushFollow(FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__19373);
            rule__Documentation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__19376);
            rule__Documentation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__1"


    // $ANTLR start "rule__Documentation__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4674:1: rule__Documentation__Group__1__Impl : ( '[' ) ;
    public final void rule__Documentation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4678:1: ( ( '[' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4679:1: ( '[' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4679:1: ( '[' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4680:1: '['
            {
             before(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 
            match(input,52,FOLLOW_52_in_rule__Documentation__Group__1__Impl9404); 
             after(grammarAccess.getDocumentationAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__1__Impl"


    // $ANTLR start "rule__Documentation__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4693:1: rule__Documentation__Group__2 : rule__Documentation__Group__2__Impl rule__Documentation__Group__3 ;
    public final void rule__Documentation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4697:1: ( rule__Documentation__Group__2__Impl rule__Documentation__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4698:2: rule__Documentation__Group__2__Impl rule__Documentation__Group__3
            {
            pushFollow(FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__29435);
            rule__Documentation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__29438);
            rule__Documentation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__2"


    // $ANTLR start "rule__Documentation__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4705:1: rule__Documentation__Group__2__Impl : ( ( rule__Documentation__LinesAssignment_2 )* ) ;
    public final void rule__Documentation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4709:1: ( ( ( rule__Documentation__LinesAssignment_2 )* ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4710:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4710:1: ( ( rule__Documentation__LinesAssignment_2 )* )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4711:1: ( rule__Documentation__LinesAssignment_2 )*
            {
             before(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4712:1: ( rule__Documentation__LinesAssignment_2 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_STRING) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4712:2: rule__Documentation__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl9465);
            	    rule__Documentation__LinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getDocumentationAccess().getLinesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__2__Impl"


    // $ANTLR start "rule__Documentation__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4722:1: rule__Documentation__Group__3 : rule__Documentation__Group__3__Impl ;
    public final void rule__Documentation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4726:1: ( rule__Documentation__Group__3__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4727:2: rule__Documentation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__39496);
            rule__Documentation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__3"


    // $ANTLR start "rule__Documentation__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4733:1: rule__Documentation__Group__3__Impl : ( ']' ) ;
    public final void rule__Documentation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4737:1: ( ( ']' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4738:1: ( ']' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4738:1: ( ']' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4739:1: ']'
            {
             before(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 
            match(input,53,FOLLOW_53_in_rule__Documentation__Group__3__Impl9524); 
             after(grammarAccess.getDocumentationAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__Group__3__Impl"


    // $ANTLR start "rule__TIME__Group_0__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4760:1: rule__TIME__Group_0__0 : rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 ;
    public final void rule__TIME__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4764:1: ( rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4765:2: rule__TIME__Group_0__0__Impl rule__TIME__Group_0__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_0__0__Impl_in_rule__TIME__Group_0__09563);
            rule__TIME__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_0__1_in_rule__TIME__Group_0__09566);
            rule__TIME__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__0"


    // $ANTLR start "rule__TIME__Group_0__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4772:1: rule__TIME__Group_0__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4776:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4777:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4777:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4778:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_0__0__Impl9593); 
             after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__0__Impl"


    // $ANTLR start "rule__TIME__Group_0__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4789:1: rule__TIME__Group_0__1 : rule__TIME__Group_0__1__Impl ;
    public final void rule__TIME__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4793:1: ( rule__TIME__Group_0__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4794:2: rule__TIME__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_0__1__Impl_in_rule__TIME__Group_0__19622);
            rule__TIME__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__1"


    // $ANTLR start "rule__TIME__Group_0__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4800:1: rule__TIME__Group_0__1__Impl : ( 's' ) ;
    public final void rule__TIME__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4804:1: ( ( 's' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4805:1: ( 's' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4805:1: ( 's' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4806:1: 's'
            {
             before(grammarAccess.getTIMEAccess().getSKeyword_0_1()); 
            match(input,54,FOLLOW_54_in_rule__TIME__Group_0__1__Impl9650); 
             after(grammarAccess.getTIMEAccess().getSKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_0__1__Impl"


    // $ANTLR start "rule__TIME__Group_1__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4823:1: rule__TIME__Group_1__0 : rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 ;
    public final void rule__TIME__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4827:1: ( rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4828:2: rule__TIME__Group_1__0__Impl rule__TIME__Group_1__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_1__0__Impl_in_rule__TIME__Group_1__09685);
            rule__TIME__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_1__1_in_rule__TIME__Group_1__09688);
            rule__TIME__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__0"


    // $ANTLR start "rule__TIME__Group_1__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4835:1: rule__TIME__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4839:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4840:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4840:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4841:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_1__0__Impl9715); 
             after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__0__Impl"


    // $ANTLR start "rule__TIME__Group_1__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4852:1: rule__TIME__Group_1__1 : rule__TIME__Group_1__1__Impl ;
    public final void rule__TIME__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4856:1: ( rule__TIME__Group_1__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4857:2: rule__TIME__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_1__1__Impl_in_rule__TIME__Group_1__19744);
            rule__TIME__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__1"


    // $ANTLR start "rule__TIME__Group_1__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4863:1: rule__TIME__Group_1__1__Impl : ( 'ms' ) ;
    public final void rule__TIME__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4867:1: ( ( 'ms' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4868:1: ( 'ms' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4868:1: ( 'ms' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4869:1: 'ms'
            {
             before(grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 
            match(input,55,FOLLOW_55_in_rule__TIME__Group_1__1__Impl9772); 
             after(grammarAccess.getTIMEAccess().getMsKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_1__1__Impl"


    // $ANTLR start "rule__TIME__Group_2__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4886:1: rule__TIME__Group_2__0 : rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 ;
    public final void rule__TIME__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4890:1: ( rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4891:2: rule__TIME__Group_2__0__Impl rule__TIME__Group_2__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_2__0__Impl_in_rule__TIME__Group_2__09807);
            rule__TIME__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_2__1_in_rule__TIME__Group_2__09810);
            rule__TIME__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__0"


    // $ANTLR start "rule__TIME__Group_2__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4898:1: rule__TIME__Group_2__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4902:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4903:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4903:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4904:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_2__0__Impl9837); 
             after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__0__Impl"


    // $ANTLR start "rule__TIME__Group_2__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4915:1: rule__TIME__Group_2__1 : rule__TIME__Group_2__1__Impl ;
    public final void rule__TIME__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4919:1: ( rule__TIME__Group_2__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4920:2: rule__TIME__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_2__1__Impl_in_rule__TIME__Group_2__19866);
            rule__TIME__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__1"


    // $ANTLR start "rule__TIME__Group_2__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4926:1: rule__TIME__Group_2__1__Impl : ( 'us' ) ;
    public final void rule__TIME__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4930:1: ( ( 'us' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4931:1: ( 'us' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4931:1: ( 'us' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4932:1: 'us'
            {
             before(grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 
            match(input,56,FOLLOW_56_in_rule__TIME__Group_2__1__Impl9894); 
             after(grammarAccess.getTIMEAccess().getUsKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_2__1__Impl"


    // $ANTLR start "rule__TIME__Group_3__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4949:1: rule__TIME__Group_3__0 : rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 ;
    public final void rule__TIME__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4953:1: ( rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4954:2: rule__TIME__Group_3__0__Impl rule__TIME__Group_3__1
            {
            pushFollow(FOLLOW_rule__TIME__Group_3__0__Impl_in_rule__TIME__Group_3__09929);
            rule__TIME__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TIME__Group_3__1_in_rule__TIME__Group_3__09932);
            rule__TIME__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__0"


    // $ANTLR start "rule__TIME__Group_3__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4961:1: rule__TIME__Group_3__0__Impl : ( RULE_INT ) ;
    public final void rule__TIME__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4965:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4966:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4966:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4967:1: RULE_INT
            {
             before(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TIME__Group_3__0__Impl9959); 
             after(grammarAccess.getTIMEAccess().getINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__0__Impl"


    // $ANTLR start "rule__TIME__Group_3__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4978:1: rule__TIME__Group_3__1 : rule__TIME__Group_3__1__Impl ;
    public final void rule__TIME__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4982:1: ( rule__TIME__Group_3__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4983:2: rule__TIME__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__TIME__Group_3__1__Impl_in_rule__TIME__Group_3__19988);
            rule__TIME__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__1"


    // $ANTLR start "rule__TIME__Group_3__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4989:1: rule__TIME__Group_3__1__Impl : ( 'ns' ) ;
    public final void rule__TIME__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4993:1: ( ( 'ns' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4994:1: ( 'ns' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4994:1: ( 'ns' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:4995:1: 'ns'
            {
             before(grammarAccess.getTIMEAccess().getNsKeyword_3_1()); 
            match(input,57,FOLLOW_57_in_rule__TIME__Group_3__1__Impl10016); 
             after(grammarAccess.getTIMEAccess().getNsKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIME__Group_3__1__Impl"


    // $ANTLR start "rule__BooleanLiteral__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5014:1: rule__BooleanLiteral__Group__0 : rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 ;
    public final void rule__BooleanLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5018:1: ( rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5019:2: rule__BooleanLiteral__Group__0__Impl rule__BooleanLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__010053);
            rule__BooleanLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__010056);
            rule__BooleanLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__0"


    // $ANTLR start "rule__BooleanLiteral__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5026:1: rule__BooleanLiteral__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5030:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5031:1: ( () )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5031:1: ( () )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5032:1: ()
            {
             before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5033:1: ()
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5035:1: 
            {
            }

             after(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__0__Impl"


    // $ANTLR start "rule__BooleanLiteral__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5045:1: rule__BooleanLiteral__Group__1 : rule__BooleanLiteral__Group__1__Impl ;
    public final void rule__BooleanLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5049:1: ( rule__BooleanLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5050:2: rule__BooleanLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__110114);
            rule__BooleanLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__1"


    // $ANTLR start "rule__BooleanLiteral__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5056:1: rule__BooleanLiteral__Group__1__Impl : ( ( rule__BooleanLiteral__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5060:1: ( ( ( rule__BooleanLiteral__Alternatives_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5061:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5061:1: ( ( rule__BooleanLiteral__Alternatives_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5062:1: ( rule__BooleanLiteral__Alternatives_1 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5063:1: ( rule__BooleanLiteral__Alternatives_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5063:2: rule__BooleanLiteral__Alternatives_1
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl10141);
            rule__BooleanLiteral__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__Group__1__Impl"


    // $ANTLR start "rule__RealLiteral__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5077:1: rule__RealLiteral__Group__0 : rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 ;
    public final void rule__RealLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5081:1: ( rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5082:2: rule__RealLiteral__Group__0__Impl rule__RealLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__010175);
            rule__RealLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__010178);
            rule__RealLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__0"


    // $ANTLR start "rule__RealLiteral__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5089:1: rule__RealLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RealLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5093:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5094:1: ( () )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5094:1: ( () )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5095:1: ()
            {
             before(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5096:1: ()
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5098:1: 
            {
            }

             after(grammarAccess.getRealLiteralAccess().getRealLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__0__Impl"


    // $ANTLR start "rule__RealLiteral__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5108:1: rule__RealLiteral__Group__1 : rule__RealLiteral__Group__1__Impl ;
    public final void rule__RealLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5112:1: ( rule__RealLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5113:2: rule__RealLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__110236);
            rule__RealLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__1"


    // $ANTLR start "rule__RealLiteral__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5119:1: rule__RealLiteral__Group__1__Impl : ( ( rule__RealLiteral__ValueAssignment_1 ) ) ;
    public final void rule__RealLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5123:1: ( ( ( rule__RealLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5124:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5124:1: ( ( rule__RealLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5125:1: ( rule__RealLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5126:1: ( rule__RealLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5126:2: rule__RealLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl10263);
            rule__RealLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRealLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__Group__1__Impl"


    // $ANTLR start "rule__IntLiteral__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5140:1: rule__IntLiteral__Group__0 : rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 ;
    public final void rule__IntLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5144:1: ( rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5145:2: rule__IntLiteral__Group__0__Impl rule__IntLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__010297);
            rule__IntLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__010300);
            rule__IntLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__0"


    // $ANTLR start "rule__IntLiteral__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5152:1: rule__IntLiteral__Group__0__Impl : ( () ) ;
    public final void rule__IntLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5156:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5157:1: ( () )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5157:1: ( () )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5158:1: ()
            {
             before(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5159:1: ()
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5161:1: 
            {
            }

             after(grammarAccess.getIntLiteralAccess().getIntLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__0__Impl"


    // $ANTLR start "rule__IntLiteral__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5171:1: rule__IntLiteral__Group__1 : rule__IntLiteral__Group__1__Impl ;
    public final void rule__IntLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5175:1: ( rule__IntLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5176:2: rule__IntLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__110358);
            rule__IntLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__1"


    // $ANTLR start "rule__IntLiteral__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5182:1: rule__IntLiteral__Group__1__Impl : ( ( rule__IntLiteral__ValueAssignment_1 ) ) ;
    public final void rule__IntLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5186:1: ( ( ( rule__IntLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5187:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5187:1: ( ( rule__IntLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5188:1: ( rule__IntLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5189:1: ( rule__IntLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5189:2: rule__IntLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl10385);
            rule__IntLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__Group__1__Impl"


    // $ANTLR start "rule__StringLiteral__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5203:1: rule__StringLiteral__Group__0 : rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 ;
    public final void rule__StringLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5207:1: ( rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5208:2: rule__StringLiteral__Group__0__Impl rule__StringLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__010419);
            rule__StringLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__010422);
            rule__StringLiteral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0"


    // $ANTLR start "rule__StringLiteral__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5215:1: rule__StringLiteral__Group__0__Impl : ( () ) ;
    public final void rule__StringLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5219:1: ( ( () ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5220:1: ( () )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5220:1: ( () )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5221:1: ()
            {
             before(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5222:1: ()
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5224:1: 
            {
            }

             after(grammarAccess.getStringLiteralAccess().getStringLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__0__Impl"


    // $ANTLR start "rule__StringLiteral__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5234:1: rule__StringLiteral__Group__1 : rule__StringLiteral__Group__1__Impl ;
    public final void rule__StringLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5238:1: ( rule__StringLiteral__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5239:2: rule__StringLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__110480);
            rule__StringLiteral__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1"


    // $ANTLR start "rule__StringLiteral__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5245:1: rule__StringLiteral__Group__1__Impl : ( ( rule__StringLiteral__ValueAssignment_1 ) ) ;
    public final void rule__StringLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5249:1: ( ( ( rule__StringLiteral__ValueAssignment_1 ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5250:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5250:1: ( ( rule__StringLiteral__ValueAssignment_1 ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5251:1: ( rule__StringLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5252:1: ( rule__StringLiteral__ValueAssignment_1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5252:2: rule__StringLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl10507);
            rule__StringLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__Group__1__Impl"


    // $ANTLR start "rule__SignedInteger__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5266:1: rule__SignedInteger__Group__0 : rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 ;
    public final void rule__SignedInteger__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5270:1: ( rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5271:2: rule__SignedInteger__Group__0__Impl rule__SignedInteger__Group__1
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__010541);
            rule__SignedInteger__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__010544);
            rule__SignedInteger__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Group__0"


    // $ANTLR start "rule__SignedInteger__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5278:1: rule__SignedInteger__Group__0__Impl : ( ( rule__SignedInteger__Alternatives_0 )? ) ;
    public final void rule__SignedInteger__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5282:1: ( ( ( rule__SignedInteger__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5283:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5283:1: ( ( rule__SignedInteger__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5284:1: ( rule__SignedInteger__Alternatives_0 )?
            {
             before(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5285:1: ( rule__SignedInteger__Alternatives_0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=14 && LA35_0<=15)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5285:2: rule__SignedInteger__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl10571);
                    rule__SignedInteger__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSignedIntegerAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Group__0__Impl"


    // $ANTLR start "rule__SignedInteger__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5295:1: rule__SignedInteger__Group__1 : rule__SignedInteger__Group__1__Impl ;
    public final void rule__SignedInteger__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5299:1: ( rule__SignedInteger__Group__1__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5300:2: rule__SignedInteger__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__110602);
            rule__SignedInteger__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Group__1"


    // $ANTLR start "rule__SignedInteger__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5306:1: rule__SignedInteger__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__SignedInteger__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5310:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5311:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5311:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5312:1: RULE_INT
            {
             before(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl10629); 
             after(grammarAccess.getSignedIntegerAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SignedInteger__Group__1__Impl"


    // $ANTLR start "rule__Decimal__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5327:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5331:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5332:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__010662);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__010665);
            rule__Decimal__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__0"


    // $ANTLR start "rule__Decimal__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5339:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__Alternatives_0 )? ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5343:1: ( ( ( rule__Decimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5344:1: ( ( rule__Decimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5344:1: ( ( rule__Decimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5345:1: ( rule__Decimal__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5346:1: ( rule__Decimal__Alternatives_0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=14 && LA36_0<=15)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5346:2: rule__Decimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl10692);
                    rule__Decimal__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDecimalAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__0__Impl"


    // $ANTLR start "rule__Decimal__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5356:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5360:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5361:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__110723);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__110726);
            rule__Decimal__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__1"


    // $ANTLR start "rule__Decimal__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5368:1: rule__Decimal__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5372:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5373:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5373:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5374:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl10753); 
             after(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__1__Impl"


    // $ANTLR start "rule__Decimal__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5385:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl rule__Decimal__Group__3 ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5389:1: ( rule__Decimal__Group__2__Impl rule__Decimal__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5390:2: rule__Decimal__Group__2__Impl rule__Decimal__Group__3
            {
            pushFollow(FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__210782);
            rule__Decimal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__210785);
            rule__Decimal__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__2"


    // $ANTLR start "rule__Decimal__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5397:1: rule__Decimal__Group__2__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5401:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5402:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5402:1: ( '.' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5403:1: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 
            match(input,49,FOLLOW_49_in_rule__Decimal__Group__2__Impl10813); 
             after(grammarAccess.getDecimalAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__2__Impl"


    // $ANTLR start "rule__Decimal__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5416:1: rule__Decimal__Group__3 : rule__Decimal__Group__3__Impl ;
    public final void rule__Decimal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5420:1: ( rule__Decimal__Group__3__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5421:2: rule__Decimal__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__310844);
            rule__Decimal__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__3"


    // $ANTLR start "rule__Decimal__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5427:1: rule__Decimal__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__Decimal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5431:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5432:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5432:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5433:1: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl10871); 
             after(grammarAccess.getDecimalAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__3__Impl"


    // $ANTLR start "rule__DotDecimal__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5452:1: rule__DotDecimal__Group__0 : rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 ;
    public final void rule__DotDecimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5456:1: ( rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5457:2: rule__DotDecimal__Group__0__Impl rule__DotDecimal__Group__1
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__010908);
            rule__DotDecimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__010911);
            rule__DotDecimal__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__0"


    // $ANTLR start "rule__DotDecimal__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5464:1: rule__DotDecimal__Group__0__Impl : ( ( rule__DotDecimal__Alternatives_0 )? ) ;
    public final void rule__DotDecimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5468:1: ( ( ( rule__DotDecimal__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5469:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5469:1: ( ( rule__DotDecimal__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5470:1: ( rule__DotDecimal__Alternatives_0 )?
            {
             before(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5471:1: ( rule__DotDecimal__Alternatives_0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=14 && LA37_0<=15)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5471:2: rule__DotDecimal__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl10938);
                    rule__DotDecimal__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDotDecimalAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__0__Impl"


    // $ANTLR start "rule__DotDecimal__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5481:1: rule__DotDecimal__Group__1 : rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 ;
    public final void rule__DotDecimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5485:1: ( rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5486:2: rule__DotDecimal__Group__1__Impl rule__DotDecimal__Group__2
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__110969);
            rule__DotDecimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__110972);
            rule__DotDecimal__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__1"


    // $ANTLR start "rule__DotDecimal__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5493:1: rule__DotDecimal__Group__1__Impl : ( '.' ) ;
    public final void rule__DotDecimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5497:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5498:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5498:1: ( '.' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5499:1: '.'
            {
             before(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 
            match(input,49,FOLLOW_49_in_rule__DotDecimal__Group__1__Impl11000); 
             after(grammarAccess.getDotDecimalAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__1__Impl"


    // $ANTLR start "rule__DotDecimal__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5512:1: rule__DotDecimal__Group__2 : rule__DotDecimal__Group__2__Impl ;
    public final void rule__DotDecimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5516:1: ( rule__DotDecimal__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5517:2: rule__DotDecimal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__211031);
            rule__DotDecimal__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__2"


    // $ANTLR start "rule__DotDecimal__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5523:1: rule__DotDecimal__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DotDecimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5527:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5528:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5528:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5529:1: RULE_INT
            {
             before(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl11058); 
             after(grammarAccess.getDotDecimalAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DotDecimal__Group__2__Impl"


    // $ANTLR start "rule__DecimalDot__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5546:1: rule__DecimalDot__Group__0 : rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 ;
    public final void rule__DecimalDot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5550:1: ( rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5551:2: rule__DecimalDot__Group__0__Impl rule__DecimalDot__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__011093);
            rule__DecimalDot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__011096);
            rule__DecimalDot__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__0"


    // $ANTLR start "rule__DecimalDot__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5558:1: rule__DecimalDot__Group__0__Impl : ( ( rule__DecimalDot__Alternatives_0 )? ) ;
    public final void rule__DecimalDot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5562:1: ( ( ( rule__DecimalDot__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5563:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5563:1: ( ( rule__DecimalDot__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5564:1: ( rule__DecimalDot__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5565:1: ( rule__DecimalDot__Alternatives_0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=14 && LA38_0<=15)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5565:2: rule__DecimalDot__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl11123);
                    rule__DecimalDot__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDecimalDotAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__0__Impl"


    // $ANTLR start "rule__DecimalDot__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5575:1: rule__DecimalDot__Group__1 : rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 ;
    public final void rule__DecimalDot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5579:1: ( rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5580:2: rule__DecimalDot__Group__1__Impl rule__DecimalDot__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__111154);
            rule__DecimalDot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__111157);
            rule__DecimalDot__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__1"


    // $ANTLR start "rule__DecimalDot__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5587:1: rule__DecimalDot__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalDot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5591:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5592:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5592:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5593:1: RULE_INT
            {
             before(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl11184); 
             after(grammarAccess.getDecimalDotAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__1__Impl"


    // $ANTLR start "rule__DecimalDot__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5604:1: rule__DecimalDot__Group__2 : rule__DecimalDot__Group__2__Impl ;
    public final void rule__DecimalDot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5608:1: ( rule__DecimalDot__Group__2__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5609:2: rule__DecimalDot__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__211213);
            rule__DecimalDot__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__2"


    // $ANTLR start "rule__DecimalDot__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5615:1: rule__DecimalDot__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalDot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5619:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5620:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5620:1: ( '.' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5621:1: '.'
            {
             before(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 
            match(input,49,FOLLOW_49_in_rule__DecimalDot__Group__2__Impl11241); 
             after(grammarAccess.getDecimalDotAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalDot__Group__2__Impl"


    // $ANTLR start "rule__DecimalExp__Group__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5640:1: rule__DecimalExp__Group__0 : rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 ;
    public final void rule__DecimalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5644:1: ( rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5645:2: rule__DecimalExp__Group__0__Impl rule__DecimalExp__Group__1
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__011278);
            rule__DecimalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__011281);
            rule__DecimalExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__0"


    // $ANTLR start "rule__DecimalExp__Group__0__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5652:1: rule__DecimalExp__Group__0__Impl : ( ( rule__DecimalExp__Alternatives_0 )? ) ;
    public final void rule__DecimalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5656:1: ( ( ( rule__DecimalExp__Alternatives_0 )? ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5657:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5657:1: ( ( rule__DecimalExp__Alternatives_0 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5658:1: ( rule__DecimalExp__Alternatives_0 )?
            {
             before(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5659:1: ( rule__DecimalExp__Alternatives_0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=14 && LA39_0<=15)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5659:2: rule__DecimalExp__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl11308);
                    rule__DecimalExp__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDecimalExpAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__0__Impl"


    // $ANTLR start "rule__DecimalExp__Group__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5669:1: rule__DecimalExp__Group__1 : rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 ;
    public final void rule__DecimalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5673:1: ( rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5674:2: rule__DecimalExp__Group__1__Impl rule__DecimalExp__Group__2
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__111339);
            rule__DecimalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__111342);
            rule__DecimalExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__1"


    // $ANTLR start "rule__DecimalExp__Group__1__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5681:1: rule__DecimalExp__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5685:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5686:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5686:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5687:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl11369); 
             after(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__1__Impl"


    // $ANTLR start "rule__DecimalExp__Group__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5698:1: rule__DecimalExp__Group__2 : rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 ;
    public final void rule__DecimalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5702:1: ( rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5703:2: rule__DecimalExp__Group__2__Impl rule__DecimalExp__Group__3
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__211398);
            rule__DecimalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__211401);
            rule__DecimalExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__2"


    // $ANTLR start "rule__DecimalExp__Group__2__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5710:1: rule__DecimalExp__Group__2__Impl : ( '.' ) ;
    public final void rule__DecimalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5714:1: ( ( '.' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5715:1: ( '.' )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5715:1: ( '.' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5716:1: '.'
            {
             before(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 
            match(input,49,FOLLOW_49_in_rule__DecimalExp__Group__2__Impl11429); 
             after(grammarAccess.getDecimalExpAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__2__Impl"


    // $ANTLR start "rule__DecimalExp__Group__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5729:1: rule__DecimalExp__Group__3 : rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 ;
    public final void rule__DecimalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5733:1: ( rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4 )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5734:2: rule__DecimalExp__Group__3__Impl rule__DecimalExp__Group__4
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__311460);
            rule__DecimalExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__311463);
            rule__DecimalExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__3"


    // $ANTLR start "rule__DecimalExp__Group__3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5741:1: rule__DecimalExp__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__DecimalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5745:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5746:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5746:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5747:1: RULE_INT
            {
             before(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl11490); 
             after(grammarAccess.getDecimalExpAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__3__Impl"


    // $ANTLR start "rule__DecimalExp__Group__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5758:1: rule__DecimalExp__Group__4 : rule__DecimalExp__Group__4__Impl ;
    public final void rule__DecimalExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5762:1: ( rule__DecimalExp__Group__4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5763:2: rule__DecimalExp__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__411519);
            rule__DecimalExp__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__4"


    // $ANTLR start "rule__DecimalExp__Group__4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5769:1: rule__DecimalExp__Group__4__Impl : ( RULE_EXP ) ;
    public final void rule__DecimalExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5773:1: ( ( RULE_EXP ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5774:1: ( RULE_EXP )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5774:1: ( RULE_EXP )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5775:1: RULE_EXP
            {
             before(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 
            match(input,RULE_EXP,FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl11546); 
             after(grammarAccess.getDecimalExpAccess().getEXPTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalExp__Group__4__Impl"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5797:1: rule__NodeClass__UnorderedGroup_4 : rule__NodeClass__UnorderedGroup_4__0 {...}?;
    public final void rule__NodeClass__UnorderedGroup_4() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5802:1: ( rule__NodeClass__UnorderedGroup_4__0 {...}?)
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5803:2: rule__NodeClass__UnorderedGroup_4__0 {...}?
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__0_in_rule__NodeClass__UnorderedGroup_411586);
            rule__NodeClass__UnorderedGroup_4__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "rule__NodeClass__UnorderedGroup_4", "getUnorderedGroupHelper().canLeave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5814:1: rule__NodeClass__UnorderedGroup_4__Impl : ( ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) ) ) ;
    public final void rule__NodeClass__UnorderedGroup_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5819:1: ( ( ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5820:3: ( ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5820:3: ( ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) ) )
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( LA40_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                alt40=1;
            }
            else if ( LA40_0 ==37 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                alt40=2;
            }
            else if ( LA40_0 ==38 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                alt40=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5822:4: ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5822:4: ({...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5823:5: {...}? => ( ( ( rule__NodeClass__Group_4_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                        throw new FailedPredicateException(input, "rule__NodeClass__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5823:106: ( ( ( rule__NodeClass__Group_4_0__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5824:6: ( ( rule__NodeClass__Group_4_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5830:6: ( ( rule__NodeClass__Group_4_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5832:7: ( rule__NodeClass__Group_4_0__0 )
                    {
                     before(grammarAccess.getNodeClassAccess().getGroup_4_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5833:7: ( rule__NodeClass__Group_4_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5833:8: rule__NodeClass__Group_4_0__0
                    {
                    pushFollow(FOLLOW_rule__NodeClass__Group_4_0__0_in_rule__NodeClass__UnorderedGroup_4__Impl11675);
                    rule__NodeClass__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNodeClassAccess().getGroup_4_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5839:4: ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5839:4: ({...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5840:5: {...}? => ( ( ( rule__NodeClass__Group_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                        throw new FailedPredicateException(input, "rule__NodeClass__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5840:106: ( ( ( rule__NodeClass__Group_4_1__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5841:6: ( ( rule__NodeClass__Group_4_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5847:6: ( ( rule__NodeClass__Group_4_1__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5849:7: ( rule__NodeClass__Group_4_1__0 )
                    {
                     before(grammarAccess.getNodeClassAccess().getGroup_4_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5850:7: ( rule__NodeClass__Group_4_1__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5850:8: rule__NodeClass__Group_4_1__0
                    {
                    pushFollow(FOLLOW_rule__NodeClass__Group_4_1__0_in_rule__NodeClass__UnorderedGroup_4__Impl11766);
                    rule__NodeClass__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNodeClassAccess().getGroup_4_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5856:4: ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5856:4: ({...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5857:5: {...}? => ( ( ( rule__NodeClass__Group_4_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                        throw new FailedPredicateException(input, "rule__NodeClass__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5857:106: ( ( ( rule__NodeClass__Group_4_2__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5858:6: ( ( rule__NodeClass__Group_4_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5864:6: ( ( rule__NodeClass__Group_4_2__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5866:7: ( rule__NodeClass__Group_4_2__0 )
                    {
                     before(grammarAccess.getNodeClassAccess().getGroup_4_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5867:7: ( rule__NodeClass__Group_4_2__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5867:8: rule__NodeClass__Group_4_2__0
                    {
                    pushFollow(FOLLOW_rule__NodeClass__Group_4_2__0_in_rule__NodeClass__UnorderedGroup_4__Impl11857);
                    rule__NodeClass__Group_4_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNodeClassAccess().getGroup_4_2()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNodeClassAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4__Impl"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5882:1: rule__NodeClass__UnorderedGroup_4__0 : rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__1 )? ;
    public final void rule__NodeClass__UnorderedGroup_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5886:1: ( rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__1 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5887:2: rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__1 )?
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__011916);
            rule__NodeClass__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5888:2: ( rule__NodeClass__UnorderedGroup_4__1 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( LA41_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                alt41=1;
            }
            else if ( LA41_0 ==37 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                alt41=1;
            }
            else if ( LA41_0 ==38 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5888:2: rule__NodeClass__UnorderedGroup_4__1
                    {
                    pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__1_in_rule__NodeClass__UnorderedGroup_4__011919);
                    rule__NodeClass__UnorderedGroup_4__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4__0"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5895:1: rule__NodeClass__UnorderedGroup_4__1 : rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__2 )? ;
    public final void rule__NodeClass__UnorderedGroup_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5899:1: ( rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5900:2: rule__NodeClass__UnorderedGroup_4__Impl ( rule__NodeClass__UnorderedGroup_4__2 )?
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__111944);
            rule__NodeClass__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5901:2: ( rule__NodeClass__UnorderedGroup_4__2 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( LA42_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 0) ) {
                alt42=1;
            }
            else if ( LA42_0 ==37 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 1) ) {
                alt42=1;
            }
            else if ( LA42_0 ==38 && getUnorderedGroupHelper().canSelect(grammarAccess.getNodeClassAccess().getUnorderedGroup_4(), 2) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5901:2: rule__NodeClass__UnorderedGroup_4__2
                    {
                    pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__2_in_rule__NodeClass__UnorderedGroup_4__111947);
                    rule__NodeClass__UnorderedGroup_4__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4__1"


    // $ANTLR start "rule__NodeClass__UnorderedGroup_4__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5908:1: rule__NodeClass__UnorderedGroup_4__2 : rule__NodeClass__UnorderedGroup_4__Impl ;
    public final void rule__NodeClass__UnorderedGroup_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5912:1: ( rule__NodeClass__UnorderedGroup_4__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5913:2: rule__NodeClass__UnorderedGroup_4__Impl
            {
            pushFollow(FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__211972);
            rule__NodeClass__UnorderedGroup_4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__UnorderedGroup_4__2"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5926:1: rule__PhysicalThread__UnorderedGroup_3 : rule__PhysicalThread__UnorderedGroup_3__0 {...}?;
    public final void rule__PhysicalThread__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5931:1: ( rule__PhysicalThread__UnorderedGroup_3__0 {...}?)
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5932:2: rule__PhysicalThread__UnorderedGroup_3__0 {...}?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__0_in_rule__PhysicalThread__UnorderedGroup_312002);
            rule__PhysicalThread__UnorderedGroup_3__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3", "getUnorderedGroupHelper().canLeave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__Impl"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5943:1: rule__PhysicalThread__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) ) ) ;
    public final void rule__PhysicalThread__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5948:1: ( ( ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5949:3: ( ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5949:3: ( ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) ) )
            int alt43=6;
            int LA43_0 = input.LA(1);

            if ( LA43_0 ==39 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 ==40 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt43=2;
            }
            else if ( LA43_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt43=3;
            }
            else if ( LA43_0 ==42 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt43=4;
            }
            else if ( LA43_0 ==43 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt43=5;
            }
            else if ( LA43_0 ==44 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt43=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5951:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5951:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5952:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5952:111: ( ( ( rule__PhysicalThread__Group_3_0__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5953:6: ( ( rule__PhysicalThread__Group_3_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5959:6: ( ( rule__PhysicalThread__Group_3_0__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5961:7: ( rule__PhysicalThread__Group_3_0__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_0()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5962:7: ( rule__PhysicalThread__Group_3_0__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5962:8: rule__PhysicalThread__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_0__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12091);
                    rule__PhysicalThread__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5968:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5968:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5969:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5969:111: ( ( ( rule__PhysicalThread__Group_3_1__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5970:6: ( ( rule__PhysicalThread__Group_3_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5976:6: ( ( rule__PhysicalThread__Group_3_1__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5978:7: ( rule__PhysicalThread__Group_3_1__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_1()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5979:7: ( rule__PhysicalThread__Group_3_1__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5979:8: rule__PhysicalThread__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_1__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12182);
                    rule__PhysicalThread__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5985:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5985:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5986:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5986:111: ( ( ( rule__PhysicalThread__Group_3_2__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5987:6: ( ( rule__PhysicalThread__Group_3_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5993:6: ( ( rule__PhysicalThread__Group_3_2__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5995:7: ( rule__PhysicalThread__Group_3_2__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_2()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5996:7: ( rule__PhysicalThread__Group_3_2__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:5996:8: rule__PhysicalThread__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_2__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12273);
                    rule__PhysicalThread__Group_3_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6002:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6002:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6003:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6003:111: ( ( ( rule__PhysicalThread__Group_3_3__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6004:6: ( ( rule__PhysicalThread__Group_3_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6010:6: ( ( rule__PhysicalThread__Group_3_3__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6012:7: ( rule__PhysicalThread__Group_3_3__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_3()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6013:7: ( rule__PhysicalThread__Group_3_3__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6013:8: rule__PhysicalThread__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_3__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12364);
                    rule__PhysicalThread__Group_3_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6019:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6019:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6020:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6020:111: ( ( ( rule__PhysicalThread__Group_3_4__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6021:6: ( ( rule__PhysicalThread__Group_3_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6027:6: ( ( rule__PhysicalThread__Group_3_4__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6029:7: ( rule__PhysicalThread__Group_3_4__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_4()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6030:7: ( rule__PhysicalThread__Group_3_4__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6030:8: rule__PhysicalThread__Group_3_4__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_4__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12455);
                    rule__PhysicalThread__Group_3_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_4()); 

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6036:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) )
                    {
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6036:4: ({...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6037:5: {...}? => ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                        throw new FailedPredicateException(input, "rule__PhysicalThread__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5)");
                    }
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6037:111: ( ( ( rule__PhysicalThread__Group_3_5__0 ) ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6038:6: ( ( rule__PhysicalThread__Group_3_5__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6044:6: ( ( rule__PhysicalThread__Group_3_5__0 ) )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6046:7: ( rule__PhysicalThread__Group_3_5__0 )
                    {
                     before(grammarAccess.getPhysicalThreadAccess().getGroup_3_5()); 
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6047:7: ( rule__PhysicalThread__Group_3_5__0 )
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6047:8: rule__PhysicalThread__Group_3_5__0
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__Group_3_5__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12546);
                    rule__PhysicalThread__Group_3_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPhysicalThreadAccess().getGroup_3_5()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__Impl"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6062:1: rule__PhysicalThread__UnorderedGroup_3__0 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__1 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6066:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__1 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6067:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__012605);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6068:2: ( rule__PhysicalThread__UnorderedGroup_3__1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( LA44_0 ==39 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 ==40 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt44=1;
            }
            else if ( LA44_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt44=1;
            }
            else if ( LA44_0 ==42 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt44=1;
            }
            else if ( LA44_0 ==43 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt44=1;
            }
            else if ( LA44_0 ==44 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6068:2: rule__PhysicalThread__UnorderedGroup_3__1
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__1_in_rule__PhysicalThread__UnorderedGroup_3__012608);
                    rule__PhysicalThread__UnorderedGroup_3__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__0"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6075:1: rule__PhysicalThread__UnorderedGroup_3__1 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__2 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6079:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__2 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6080:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__2 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__112633);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6081:2: ( rule__PhysicalThread__UnorderedGroup_3__2 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 ==39 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 ==40 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt45=1;
            }
            else if ( LA45_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt45=1;
            }
            else if ( LA45_0 ==42 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt45=1;
            }
            else if ( LA45_0 ==43 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt45=1;
            }
            else if ( LA45_0 ==44 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6081:2: rule__PhysicalThread__UnorderedGroup_3__2
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__2_in_rule__PhysicalThread__UnorderedGroup_3__112636);
                    rule__PhysicalThread__UnorderedGroup_3__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__1"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6088:1: rule__PhysicalThread__UnorderedGroup_3__2 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__3 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6092:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__3 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6093:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__3 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__212661);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6094:2: ( rule__PhysicalThread__UnorderedGroup_3__3 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( LA46_0 ==39 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt46=1;
            }
            else if ( LA46_0 ==40 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt46=1;
            }
            else if ( LA46_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt46=1;
            }
            else if ( LA46_0 ==42 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt46=1;
            }
            else if ( LA46_0 ==43 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt46=1;
            }
            else if ( LA46_0 ==44 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6094:2: rule__PhysicalThread__UnorderedGroup_3__3
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__3_in_rule__PhysicalThread__UnorderedGroup_3__212664);
                    rule__PhysicalThread__UnorderedGroup_3__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__2"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6101:1: rule__PhysicalThread__UnorderedGroup_3__3 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__4 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6105:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__4 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6106:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__4 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__312689);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6107:2: ( rule__PhysicalThread__UnorderedGroup_3__4 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( LA47_0 ==39 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt47=1;
            }
            else if ( LA47_0 ==40 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt47=1;
            }
            else if ( LA47_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt47=1;
            }
            else if ( LA47_0 ==42 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt47=1;
            }
            else if ( LA47_0 ==43 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt47=1;
            }
            else if ( LA47_0 ==44 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6107:2: rule__PhysicalThread__UnorderedGroup_3__4
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__4_in_rule__PhysicalThread__UnorderedGroup_3__312692);
                    rule__PhysicalThread__UnorderedGroup_3__4();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__3"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6114:1: rule__PhysicalThread__UnorderedGroup_3__4 : rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__5 )? ;
    public final void rule__PhysicalThread__UnorderedGroup_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6118:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__5 )? )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6119:2: rule__PhysicalThread__UnorderedGroup_3__Impl ( rule__PhysicalThread__UnorderedGroup_3__5 )?
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__412717);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6120:2: ( rule__PhysicalThread__UnorderedGroup_3__5 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( LA48_0 ==39 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 0) ) {
                alt48=1;
            }
            else if ( LA48_0 ==40 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 1) ) {
                alt48=1;
            }
            else if ( LA48_0 ==41 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 2) ) {
                alt48=1;
            }
            else if ( LA48_0 ==42 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 3) ) {
                alt48=1;
            }
            else if ( LA48_0 ==43 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 4) ) {
                alt48=1;
            }
            else if ( LA48_0 ==44 && getUnorderedGroupHelper().canSelect(grammarAccess.getPhysicalThreadAccess().getUnorderedGroup_3(), 5) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6120:2: rule__PhysicalThread__UnorderedGroup_3__5
                    {
                    pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__5_in_rule__PhysicalThread__UnorderedGroup_3__412720);
                    rule__PhysicalThread__UnorderedGroup_3__5();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__4"


    // $ANTLR start "rule__PhysicalThread__UnorderedGroup_3__5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6127:1: rule__PhysicalThread__UnorderedGroup_3__5 : rule__PhysicalThread__UnorderedGroup_3__Impl ;
    public final void rule__PhysicalThread__UnorderedGroup_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6131:1: ( rule__PhysicalThread__UnorderedGroup_3__Impl )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6132:2: rule__PhysicalThread__UnorderedGroup_3__Impl
            {
            pushFollow(FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__512745);
            rule__PhysicalThread__UnorderedGroup_3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__UnorderedGroup_3__5"


    // $ANTLR start "rule__PhysicalModel__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6151:1: rule__PhysicalModel__NameAssignment_1 : ( ruleFQN ) ;
    public final void rule__PhysicalModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6155:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6156:1: ( ruleFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6156:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6157:1: ruleFQN
            {
             before(grammarAccess.getPhysicalModelAccess().getNameFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__PhysicalModel__NameAssignment_112785);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getNameFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__NameAssignment_1"


    // $ANTLR start "rule__PhysicalModel__ImportsAssignment_3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6166:1: rule__PhysicalModel__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__PhysicalModel__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6170:1: ( ( ruleImport ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6171:1: ( ruleImport )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6171:1: ( ruleImport )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6172:1: ruleImport
            {
             before(grammarAccess.getPhysicalModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__PhysicalModel__ImportsAssignment_312816);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getImportsImportParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__ImportsAssignment_3"


    // $ANTLR start "rule__PhysicalModel__SystemsAssignment_4_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6181:1: rule__PhysicalModel__SystemsAssignment_4_0 : ( rulePhysicalSystem ) ;
    public final void rule__PhysicalModel__SystemsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6185:1: ( ( rulePhysicalSystem ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6186:1: ( rulePhysicalSystem )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6186:1: ( rulePhysicalSystem )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6187:1: rulePhysicalSystem
            {
             before(grammarAccess.getPhysicalModelAccess().getSystemsPhysicalSystemParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_rulePhysicalSystem_in_rule__PhysicalModel__SystemsAssignment_4_012847);
            rulePhysicalSystem();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getSystemsPhysicalSystemParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__SystemsAssignment_4_0"


    // $ANTLR start "rule__PhysicalModel__NodeClassesAssignment_4_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6196:1: rule__PhysicalModel__NodeClassesAssignment_4_1 : ( ruleNodeClass ) ;
    public final void rule__PhysicalModel__NodeClassesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6200:1: ( ( ruleNodeClass ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6201:1: ( ruleNodeClass )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6201:1: ( ruleNodeClass )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6202:1: ruleNodeClass
            {
             before(grammarAccess.getPhysicalModelAccess().getNodeClassesNodeClassParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleNodeClass_in_rule__PhysicalModel__NodeClassesAssignment_4_112878);
            ruleNodeClass();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getNodeClassesNodeClassParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__NodeClassesAssignment_4_1"


    // $ANTLR start "rule__PhysicalModel__RuntimeClassesAssignment_4_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6211:1: rule__PhysicalModel__RuntimeClassesAssignment_4_2 : ( ruleRuntimeClass ) ;
    public final void rule__PhysicalModel__RuntimeClassesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6215:1: ( ( ruleRuntimeClass ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6216:1: ( ruleRuntimeClass )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6216:1: ( ruleRuntimeClass )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6217:1: ruleRuntimeClass
            {
             before(grammarAccess.getPhysicalModelAccess().getRuntimeClassesRuntimeClassParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_ruleRuntimeClass_in_rule__PhysicalModel__RuntimeClassesAssignment_4_212909);
            ruleRuntimeClass();

            state._fsp--;

             after(grammarAccess.getPhysicalModelAccess().getRuntimeClassesRuntimeClassParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalModel__RuntimeClassesAssignment_4_2"


    // $ANTLR start "rule__PhysicalSystem__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6226:1: rule__PhysicalSystem__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhysicalSystem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6230:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6231:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6231:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6232:1: RULE_ID
            {
             before(grammarAccess.getPhysicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhysicalSystem__NameAssignment_112940); 
             after(grammarAccess.getPhysicalSystemAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__NameAssignment_1"


    // $ANTLR start "rule__PhysicalSystem__DocuAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6241:1: rule__PhysicalSystem__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__PhysicalSystem__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6245:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6246:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6246:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6247:1: ruleDocumentation
            {
             before(grammarAccess.getPhysicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__PhysicalSystem__DocuAssignment_212971);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getPhysicalSystemAccess().getDocuDocumentationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__DocuAssignment_2"


    // $ANTLR start "rule__PhysicalSystem__NodeRefsAssignment_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6256:1: rule__PhysicalSystem__NodeRefsAssignment_4 : ( ruleNodeRef ) ;
    public final void rule__PhysicalSystem__NodeRefsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6260:1: ( ( ruleNodeRef ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6261:1: ( ruleNodeRef )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6261:1: ( ruleNodeRef )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6262:1: ruleNodeRef
            {
             before(grammarAccess.getPhysicalSystemAccess().getNodeRefsNodeRefParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleNodeRef_in_rule__PhysicalSystem__NodeRefsAssignment_413002);
            ruleNodeRef();

            state._fsp--;

             after(grammarAccess.getPhysicalSystemAccess().getNodeRefsNodeRefParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalSystem__NodeRefsAssignment_4"


    // $ANTLR start "rule__NodeRef__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6271:1: rule__NodeRef__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeRef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6275:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6276:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6276:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6277:1: RULE_ID
            {
             before(grammarAccess.getNodeRefAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NodeRef__NameAssignment_113033); 
             after(grammarAccess.getNodeRefAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__NameAssignment_1"


    // $ANTLR start "rule__NodeRef__TypeAssignment_3"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6286:1: rule__NodeRef__TypeAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__NodeRef__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6290:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6291:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6291:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6292:1: ( ruleFQN )
            {
             before(grammarAccess.getNodeRefAccess().getTypeNodeClassCrossReference_3_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6293:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6294:1: ruleFQN
            {
             before(grammarAccess.getNodeRefAccess().getTypeNodeClassFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__NodeRef__TypeAssignment_313068);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getNodeRefAccess().getTypeNodeClassFQNParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getNodeRefAccess().getTypeNodeClassCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__TypeAssignment_3"


    // $ANTLR start "rule__NodeRef__DocuAssignment_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6305:1: rule__NodeRef__DocuAssignment_4 : ( ruleDocumentation ) ;
    public final void rule__NodeRef__DocuAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6309:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6310:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6310:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6311:1: ruleDocumentation
            {
             before(grammarAccess.getNodeRefAccess().getDocuDocumentationParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__NodeRef__DocuAssignment_413103);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getNodeRefAccess().getDocuDocumentationParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__DocuAssignment_4"


    // $ANTLR start "rule__NodeClass__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6320:1: rule__NodeClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6324:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6325:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6325:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6326:1: RULE_ID
            {
             before(grammarAccess.getNodeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NodeClass__NameAssignment_113134); 
             after(grammarAccess.getNodeClassAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__NameAssignment_1"


    // $ANTLR start "rule__NodeClass__DocuAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6335:1: rule__NodeClass__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__NodeClass__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6339:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6340:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6340:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6341:1: ruleDocumentation
            {
             before(grammarAccess.getNodeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__NodeClass__DocuAssignment_213165);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__DocuAssignment_2"


    // $ANTLR start "rule__NodeClass__RuntimeAssignment_4_0_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6350:1: rule__NodeClass__RuntimeAssignment_4_0_2 : ( ( ruleFQN ) ) ;
    public final void rule__NodeClass__RuntimeAssignment_4_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6354:1: ( ( ( ruleFQN ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6355:1: ( ( ruleFQN ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6355:1: ( ( ruleFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6356:1: ( ruleFQN )
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_4_0_2_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6357:1: ( ruleFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6358:1: ruleFQN
            {
             before(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassFQNParserRuleCall_4_0_2_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__NodeClass__RuntimeAssignment_4_0_213200);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassFQNParserRuleCall_4_0_2_0_1()); 

            }

             after(grammarAccess.getNodeClassAccess().getRuntimeRuntimeClassCrossReference_4_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__RuntimeAssignment_4_0_2"


    // $ANTLR start "rule__NodeClass__PriominAssignment_4_1_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6369:1: rule__NodeClass__PriominAssignment_4_1_2 : ( rulePRIO ) ;
    public final void rule__NodeClass__PriominAssignment_4_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6373:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6374:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6374:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6375:1: rulePRIO
            {
             before(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_4_1_2_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__NodeClass__PriominAssignment_4_1_213235);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getPriominPRIOParserRuleCall_4_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__PriominAssignment_4_1_2"


    // $ANTLR start "rule__NodeClass__PriomaxAssignment_4_2_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6384:1: rule__NodeClass__PriomaxAssignment_4_2_2 : ( rulePRIO ) ;
    public final void rule__NodeClass__PriomaxAssignment_4_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6388:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6389:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6389:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6390:1: rulePRIO
            {
             before(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_4_2_2_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__NodeClass__PriomaxAssignment_4_2_213266);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getPriomaxPRIOParserRuleCall_4_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__PriomaxAssignment_4_2_2"


    // $ANTLR start "rule__NodeClass__ThreadsAssignment_5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6399:1: rule__NodeClass__ThreadsAssignment_5 : ( rulePhysicalThread ) ;
    public final void rule__NodeClass__ThreadsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6403:1: ( ( rulePhysicalThread ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6404:1: ( rulePhysicalThread )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6404:1: ( rulePhysicalThread )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6405:1: rulePhysicalThread
            {
             before(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_5_0()); 
            pushFollow(FOLLOW_rulePhysicalThread_in_rule__NodeClass__ThreadsAssignment_513297);
            rulePhysicalThread();

            state._fsp--;

             after(grammarAccess.getNodeClassAccess().getThreadsPhysicalThreadParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeClass__ThreadsAssignment_5"


    // $ANTLR start "rule__PhysicalThread__DefaultAssignment_0_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6414:1: rule__PhysicalThread__DefaultAssignment_0_0 : ( ( 'DefaultThread' ) ) ;
    public final void rule__PhysicalThread__DefaultAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6418:1: ( ( ( 'DefaultThread' ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6419:1: ( ( 'DefaultThread' ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6419:1: ( ( 'DefaultThread' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6420:1: ( 'DefaultThread' )
            {
             before(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6421:1: ( 'DefaultThread' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6422:1: 'DefaultThread'
            {
             before(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 
            match(input,58,FOLLOW_58_in_rule__PhysicalThread__DefaultAssignment_0_013333); 
             after(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 

            }

             after(grammarAccess.getPhysicalThreadAccess().getDefaultDefaultThreadKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__DefaultAssignment_0_0"


    // $ANTLR start "rule__PhysicalThread__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6437:1: rule__PhysicalThread__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhysicalThread__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6441:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6442:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6442:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6443:1: RULE_ID
            {
             before(grammarAccess.getPhysicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhysicalThread__NameAssignment_113372); 
             after(grammarAccess.getPhysicalThreadAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__NameAssignment_1"


    // $ANTLR start "rule__PhysicalThread__ExecmodeAssignment_3_0_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6452:1: rule__PhysicalThread__ExecmodeAssignment_3_0_2 : ( ruleExecMode ) ;
    public final void rule__PhysicalThread__ExecmodeAssignment_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6456:1: ( ( ruleExecMode ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6457:1: ( ruleExecMode )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6457:1: ( ruleExecMode )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6458:1: ruleExecMode
            {
             before(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_3_0_2_0()); 
            pushFollow(FOLLOW_ruleExecMode_in_rule__PhysicalThread__ExecmodeAssignment_3_0_213403);
            ruleExecMode();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getExecmodeExecModeEnumRuleCall_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__ExecmodeAssignment_3_0_2"


    // $ANTLR start "rule__PhysicalThread__TimeAssignment_3_1_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6467:1: rule__PhysicalThread__TimeAssignment_3_1_2 : ( ruleTIME ) ;
    public final void rule__PhysicalThread__TimeAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6471:1: ( ( ruleTIME ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6472:1: ( ruleTIME )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6472:1: ( ruleTIME )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6473:1: ruleTIME
            {
             before(grammarAccess.getPhysicalThreadAccess().getTimeTIMEParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleTIME_in_rule__PhysicalThread__TimeAssignment_3_1_213434);
            ruleTIME();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getTimeTIMEParserRuleCall_3_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__TimeAssignment_3_1_2"


    // $ANTLR start "rule__PhysicalThread__PrioAssignment_3_2_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6482:1: rule__PhysicalThread__PrioAssignment_3_2_2 : ( rulePRIO ) ;
    public final void rule__PhysicalThread__PrioAssignment_3_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6486:1: ( ( rulePRIO ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6487:1: ( rulePRIO )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6487:1: ( rulePRIO )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6488:1: rulePRIO
            {
             before(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_3_2_2_0()); 
            pushFollow(FOLLOW_rulePRIO_in_rule__PhysicalThread__PrioAssignment_3_2_213465);
            rulePRIO();

            state._fsp--;

             after(grammarAccess.getPhysicalThreadAccess().getPrioPRIOParserRuleCall_3_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__PrioAssignment_3_2_2"


    // $ANTLR start "rule__PhysicalThread__StacksizeAssignment_3_3_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6497:1: rule__PhysicalThread__StacksizeAssignment_3_3_2 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__StacksizeAssignment_3_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6501:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6502:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6502:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6503:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_3_3_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__StacksizeAssignment_3_3_213496); 
             after(grammarAccess.getPhysicalThreadAccess().getStacksizeINTTerminalRuleCall_3_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__StacksizeAssignment_3_3_2"


    // $ANTLR start "rule__PhysicalThread__MsgblocksizeAssignment_3_4_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6512:1: rule__PhysicalThread__MsgblocksizeAssignment_3_4_2 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__MsgblocksizeAssignment_3_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6516:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6517:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6517:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6518:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_3_4_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgblocksizeAssignment_3_4_213527); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgblocksizeINTTerminalRuleCall_3_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__MsgblocksizeAssignment_3_4_2"


    // $ANTLR start "rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6527:1: rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2 : ( RULE_INT ) ;
    public final void rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6531:1: ( ( RULE_INT ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6532:1: ( RULE_INT )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6532:1: ( RULE_INT )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6533:1: RULE_INT
            {
             before(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_3_5_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgpoolsizeAssignment_3_5_213558); 
             after(grammarAccess.getPhysicalThreadAccess().getMsgpoolsizeINTTerminalRuleCall_3_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2"


    // $ANTLR start "rule__RuntimeClass__NameAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6542:1: rule__RuntimeClass__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RuntimeClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6546:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6547:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6547:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6548:1: RULE_ID
            {
             before(grammarAccess.getRuntimeClassAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RuntimeClass__NameAssignment_113589); 
             after(grammarAccess.getRuntimeClassAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__NameAssignment_1"


    // $ANTLR start "rule__RuntimeClass__DocuAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6557:1: rule__RuntimeClass__DocuAssignment_2 : ( ruleDocumentation ) ;
    public final void rule__RuntimeClass__DocuAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6561:1: ( ( ruleDocumentation ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6562:1: ( ruleDocumentation )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6562:1: ( ruleDocumentation )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6563:1: ruleDocumentation
            {
             before(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleDocumentation_in_rule__RuntimeClass__DocuAssignment_213620);
            ruleDocumentation();

            state._fsp--;

             after(grammarAccess.getRuntimeClassAccess().getDocuDocumentationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__DocuAssignment_2"


    // $ANTLR start "rule__RuntimeClass__ThreadModelAssignment_6"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6572:1: rule__RuntimeClass__ThreadModelAssignment_6 : ( ruleThreadModel ) ;
    public final void rule__RuntimeClass__ThreadModelAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6576:1: ( ( ruleThreadModel ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6577:1: ( ruleThreadModel )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6577:1: ( ruleThreadModel )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6578:1: ruleThreadModel
            {
             before(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleThreadModel_in_rule__RuntimeClass__ThreadModelAssignment_613651);
            ruleThreadModel();

            state._fsp--;

             after(grammarAccess.getRuntimeClassAccess().getThreadModelThreadModelEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuntimeClass__ThreadModelAssignment_6"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1_0_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6587:1: rule__Import__ImportedNamespaceAssignment_1_0_0 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6591:1: ( ( ruleImportedFQN ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6592:1: ( ruleImportedFQN )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6592:1: ( ruleImportedFQN )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6593:1: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_013682);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1_0_0"


    // $ANTLR start "rule__Import__ImportURIAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6602:1: rule__Import__ImportURIAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6606:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6607:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6607:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6608:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_213713); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportURIAssignment_2"


    // $ANTLR start "rule__KeyValue__KeyAssignment_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6620:1: rule__KeyValue__KeyAssignment_0 : ( RULE_ID ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6624:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6625:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6625:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6626:1: RULE_ID
            {
             before(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_013747); 
             after(grammarAccess.getKeyValueAccess().getKeyIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__KeyAssignment_0"


    // $ANTLR start "rule__KeyValue__ValueAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6635:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6639:1: ( ( ruleLiteral ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6640:1: ( ruleLiteral )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6640:1: ( ruleLiteral )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6641:1: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_213778);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__ValueAssignment_2"


    // $ANTLR start "rule__SimpleAnnotationAttribute__OptionalAssignment_0_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6656:1: rule__SimpleAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__SimpleAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6660:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6661:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6661:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6662:1: ( 'optional' )
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6663:1: ( 'optional' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6664:1: 'optional'
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,59,FOLLOW_59_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_013820); 
             after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 

            }

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__OptionalAssignment_0_0"


    // $ANTLR start "rule__SimpleAnnotationAttribute__NameAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6679:1: rule__SimpleAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6683:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6684:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6684:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6685:1: RULE_ID
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_213859); 
             after(grammarAccess.getSimpleAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__NameAssignment_2"


    // $ANTLR start "rule__SimpleAnnotationAttribute__TypeAssignment_4"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6694:1: rule__SimpleAnnotationAttribute__TypeAssignment_4 : ( ruleLiteralType ) ;
    public final void rule__SimpleAnnotationAttribute__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6698:1: ( ( ruleLiteralType ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6699:1: ( ruleLiteralType )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6699:1: ( ruleLiteralType )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6700:1: ruleLiteralType
            {
             before(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_413890);
            ruleLiteralType();

            state._fsp--;

             after(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeLiteralTypeEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleAnnotationAttribute__TypeAssignment_4"


    // $ANTLR start "rule__EnumAnnotationAttribute__OptionalAssignment_0_0"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6709:1: rule__EnumAnnotationAttribute__OptionalAssignment_0_0 : ( ( 'optional' ) ) ;
    public final void rule__EnumAnnotationAttribute__OptionalAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6713:1: ( ( ( 'optional' ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6714:1: ( ( 'optional' ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6714:1: ( ( 'optional' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6715:1: ( 'optional' )
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6716:1: ( 'optional' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6717:1: 'optional'
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 
            match(input,59,FOLLOW_59_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_013926); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 

            }

             after(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalOptionalKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__OptionalAssignment_0_0"


    // $ANTLR start "rule__EnumAnnotationAttribute__NameAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6732:1: rule__EnumAnnotationAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EnumAnnotationAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6736:1: ( ( RULE_ID ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6737:1: ( RULE_ID )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6737:1: ( RULE_ID )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6738:1: RULE_ID
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_213965); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__NameAssignment_2"


    // $ANTLR start "rule__EnumAnnotationAttribute__ValuesAssignment_5"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6747:1: rule__EnumAnnotationAttribute__ValuesAssignment_5 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6751:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6752:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6752:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6753:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_513996); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__ValuesAssignment_5"


    // $ANTLR start "rule__EnumAnnotationAttribute__ValuesAssignment_6_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6762:1: rule__EnumAnnotationAttribute__ValuesAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__EnumAnnotationAttribute__ValuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6766:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6767:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6767:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6768:1: RULE_STRING
            {
             before(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_114027); 
             after(grammarAccess.getEnumAnnotationAttributeAccess().getValuesSTRINGTerminalRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumAnnotationAttribute__ValuesAssignment_6_1"


    // $ANTLR start "rule__Documentation__LinesAssignment_2"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6777:1: rule__Documentation__LinesAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Documentation__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6781:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6782:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6782:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6783:1: RULE_STRING
            {
             before(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_214058); 
             after(grammarAccess.getDocumentationAccess().getLinesSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Documentation__LinesAssignment_2"


    // $ANTLR start "rule__BooleanLiteral__IsTrueAssignment_1_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6794:1: rule__BooleanLiteral__IsTrueAssignment_1_1 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteral__IsTrueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6798:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6799:1: ( ( 'true' ) )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6799:1: ( ( 'true' ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6800:1: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6801:1: ( 'true' )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6802:1: 'true'
            {
             before(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 
            match(input,60,FOLLOW_60_in_rule__BooleanLiteral__IsTrueAssignment_1_114096); 
             after(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 

            }

             after(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__IsTrueAssignment_1_1"


    // $ANTLR start "rule__RealLiteral__ValueAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6817:1: rule__RealLiteral__ValueAssignment_1 : ( ruleReal ) ;
    public final void rule__RealLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6821:1: ( ( ruleReal ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6822:1: ( ruleReal )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6822:1: ( ruleReal )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6823:1: ruleReal
            {
             before(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_114135);
            ruleReal();

            state._fsp--;

             after(grammarAccess.getRealLiteralAccess().getValueRealParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealLiteral__ValueAssignment_1"


    // $ANTLR start "rule__IntLiteral__ValueAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6832:1: rule__IntLiteral__ValueAssignment_1 : ( ruleInteger ) ;
    public final void rule__IntLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6836:1: ( ( ruleInteger ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6837:1: ( ruleInteger )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6837:1: ( ruleInteger )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6838:1: ruleInteger
            {
             before(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_114166);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntLiteralAccess().getValueIntegerParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteral__ValueAssignment_1"


    // $ANTLR start "rule__StringLiteral__ValueAssignment_1"
    // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6847:1: rule__StringLiteral__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6851:1: ( ( RULE_STRING ) )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6852:1: ( RULE_STRING )
            {
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6852:1: ( RULE_STRING )
            // ../org.eclipse.etrice.core.etphys.ui/src-gen/org/eclipse/etrice/core/etphys/ui/contentassist/antlr/internal/InternalETPhys.g:6853:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_114197); 
             after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__ValueAssignment_1"

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\12\uffff";
    static final String DFA14_eofS =
        "\5\uffff\1\6\1\uffff\1\10\2\uffff";
    static final String DFA14_minS =
        "\3\6\1\61\1\uffff\1\6\1\uffff\1\7\2\uffff";
    static final String DFA14_maxS =
        "\4\61\1\uffff\1\6\1\uffff\1\7\2\uffff";
    static final String DFA14_acceptS =
        "\4\uffff\1\2\1\uffff\1\3\1\uffff\1\1\1\4";
    static final String DFA14_specialS =
        "\12\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\3\7\uffff\1\1\1\2\41\uffff\1\4",
            "\1\3\52\uffff\1\4",
            "\1\3\52\uffff\1\4",
            "\1\5",
            "",
            "\1\7",
            "",
            "\1\11",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1376:1: rule__Real__Alternatives : ( ( ruleDecimal ) | ( ruleDotDecimal ) | ( ruleDecimalDot ) | ( ruleDecimalExp ) );";
        }
    }
 

    public static final BitSet FOLLOW_rulePhysicalModel_in_entryRulePhysicalModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__0_in_rulePhysicalModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_entryRulePhysicalSystem121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalSystem128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__0_in_rulePhysicalSystem154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_entryRuleNodeClass241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeClass248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__0_in_ruleNodeClass274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_entryRulePhysicalThread301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhysicalThread308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__0_in_rulePhysicalThread334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_entryRuleRuntimeClass361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuntimeClass368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__0_in_ruleRuntimeClass394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_entryRulePRIO426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePRIO433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__0_in_rulePRIO463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport490 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_entryRuleImportedFQN550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportedFQN557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0_in_ruleImportedFQN583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValue_in_entryRuleKeyValue672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValue679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0_in_ruleKeyValue705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationTargetType_in_entryRuleAnnotationTargetType734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationTargetType741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotationTargetType767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationAttribute_in_entryRuleAnnotationAttribute793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationAttribute800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AnnotationAttribute__Alternatives_in_ruleAnnotationAttribute826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_entryRuleSimpleAnnotationAttribute853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAnnotationAttribute860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0_in_ruleSimpleAnnotationAttribute886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_entryRuleEnumAnnotationAttribute913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumAnnotationAttribute920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0_in_ruleEnumAnnotationAttribute946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_entryRuleDocumentation973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentation980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0_in_ruleDocumentation1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTIME_in_entryRuleTIME1033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTIME1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Alternatives_in_ruleTIME1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0_in_ruleBooleanLiteral1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Alternatives_in_ruleNumberLiteral1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral1275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0_in_ruleRealLiteral1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral1335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0_in_ruleIntLiteral1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0_in_ruleStringLiteral1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger1455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_entryRuleSignedInteger1520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInteger1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0_in_ruleSignedInteger1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_entryRuleHexadecimal1589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexadecimal1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexadecimal1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_entryRuleReal1652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReal1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Real__Alternatives_in_ruleReal1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_entryRuleDecimal1717 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimal1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0_in_ruleDecimal1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_entryRuleDotDecimal1786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotDecimal1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0_in_ruleDotDecimal1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_entryRuleDecimalDot1855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalDot1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0_in_ruleDecimalDot1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_entryRuleDecimalExp1924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalExp1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0_in_ruleDecimalExp1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecMode__Alternatives_in_ruleExecMode1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ThreadModel__Alternatives_in_ruleThreadModel2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralType__Alternatives_in_ruleLiteralType2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__SystemsAssignment_4_0_in_rule__PhysicalModel__Alternatives_42105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__NodeClassesAssignment_4_1_in_rule__PhysicalModel__Alternatives_42123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__RuntimeClassesAssignment_4_2_in_rule__PhysicalModel__Alternatives_42141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__DefaultAssignment_0_0_in_rule__PhysicalThread__Alternatives_02174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__PhysicalThread__Alternatives_02193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__PRIO__Alternatives_02228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__PRIO__Alternatives_02248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0_in_rule__Import__Alternatives_12282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Import__Alternatives_12301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumAnnotationAttribute_in_rule__AnnotationAttribute__Alternatives2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__OptionalAssignment_0_0_in_rule__SimpleAnnotationAttribute__Alternatives_02385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SimpleAnnotationAttribute__Alternatives_02404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__OptionalAssignment_0_0_in_rule__EnumAnnotationAttribute__Alternatives_02438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__EnumAnnotationAttribute__Alternatives_02457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__0_in_rule__TIME__Alternatives2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__0_in_rule__TIME__Alternatives2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__0_in_rule__TIME__Alternatives2527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__0_in_rule__TIME__Alternatives2545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__Literal__Alternatives2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__Literal__Alternatives2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__BooleanLiteral__Alternatives_12645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__IsTrueAssignment_1_1_in_rule__BooleanLiteral__Alternatives_12664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rule__NumberLiteral__Alternatives2697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_rule__NumberLiteral__Alternatives2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInteger_in_rule__Integer__Alternatives2746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexadecimal_in_rule__Integer__Alternatives2763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__SignedInteger__Alternatives_02796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SignedInteger__Alternatives_02816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimal_in_rule__Real__Alternatives2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotDecimal_in_rule__Real__Alternatives2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalDot_in_rule__Real__Alternatives2884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalExp_in_rule__Real__Alternatives2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Decimal__Alternatives_02934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Decimal__Alternatives_02954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DotDecimal__Alternatives_02989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DotDecimal__Alternatives_03009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DecimalDot__Alternatives_03044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalDot__Alternatives_03064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DecimalExp__Alternatives_03099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DecimalExp__Alternatives_03119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ExecMode__Alternatives3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ExecMode__Alternatives3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ExecMode__Alternatives3196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ThreadModel__Alternatives3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ThreadModel__Alternatives3253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__LiteralType__Alternatives3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__LiteralType__Alternatives3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__LiteralType__Alternatives3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__LiteralType__Alternatives3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__0__Impl_in_rule__PhysicalModel__Group__03385 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__1_in_rule__PhysicalModel__Group__03388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__PhysicalModel__Group__0__Impl3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__1__Impl_in_rule__PhysicalModel__Group__13447 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__2_in_rule__PhysicalModel__Group__13450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__NameAssignment_1_in_rule__PhysicalModel__Group__1__Impl3477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__2__Impl_in_rule__PhysicalModel__Group__23507 = new BitSet(new long[]{0x00006004C0000000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__3_in_rule__PhysicalModel__Group__23510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__PhysicalModel__Group__2__Impl3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__3__Impl_in_rule__PhysicalModel__Group__33569 = new BitSet(new long[]{0x00006004C0000000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__4_in_rule__PhysicalModel__Group__33572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__ImportsAssignment_3_in_rule__PhysicalModel__Group__3__Impl3599 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__4__Impl_in_rule__PhysicalModel__Group__43630 = new BitSet(new long[]{0x00006004C0000000L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__5_in_rule__PhysicalModel__Group__43633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Alternatives_4_in_rule__PhysicalModel__Group__4__Impl3660 = new BitSet(new long[]{0x0000200480000002L});
    public static final BitSet FOLLOW_rule__PhysicalModel__Group__5__Impl_in_rule__PhysicalModel__Group__53691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__PhysicalModel__Group__5__Impl3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__0__Impl_in_rule__PhysicalSystem__Group__03762 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__1_in_rule__PhysicalSystem__Group__03765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__PhysicalSystem__Group__0__Impl3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__1__Impl_in_rule__PhysicalSystem__Group__13824 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__2_in_rule__PhysicalSystem__Group__13827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__NameAssignment_1_in_rule__PhysicalSystem__Group__1__Impl3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__2__Impl_in_rule__PhysicalSystem__Group__23884 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__3_in_rule__PhysicalSystem__Group__23887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__DocuAssignment_2_in_rule__PhysicalSystem__Group__2__Impl3914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__3__Impl_in_rule__PhysicalSystem__Group__33945 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__4_in_rule__PhysicalSystem__Group__33948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__PhysicalSystem__Group__3__Impl3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__4__Impl_in_rule__PhysicalSystem__Group__44007 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__5_in_rule__PhysicalSystem__Group__44010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__NodeRefsAssignment_4_in_rule__PhysicalSystem__Group__4__Impl4037 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__PhysicalSystem__Group__5__Impl_in_rule__PhysicalSystem__Group__54068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__PhysicalSystem__Group__5__Impl4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__04139 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__04142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__NodeRef__Group__0__Impl4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__14201 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__2_in_rule__NodeRef__Group__14204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NameAssignment_1_in_rule__NodeRef__Group__1__Impl4231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__2__Impl_in_rule__NodeRef__Group__24261 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__3_in_rule__NodeRef__Group__24264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__NodeRef__Group__2__Impl4292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__3__Impl_in_rule__NodeRef__Group__34323 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__4_in_rule__NodeRef__Group__34326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__TypeAssignment_3_in_rule__NodeRef__Group__3__Impl4353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__4__Impl_in_rule__NodeRef__Group__44383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__DocuAssignment_4_in_rule__NodeRef__Group__4__Impl4410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__0__Impl_in_rule__NodeClass__Group__04451 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__1_in_rule__NodeClass__Group__04454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__NodeClass__Group__0__Impl4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__1__Impl_in_rule__NodeClass__Group__14513 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__2_in_rule__NodeClass__Group__14516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__NameAssignment_1_in_rule__NodeClass__Group__1__Impl4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__2__Impl_in_rule__NodeClass__Group__24573 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__3_in_rule__NodeClass__Group__24576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__DocuAssignment_2_in_rule__NodeClass__Group__2__Impl4603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__3__Impl_in_rule__NodeClass__Group__34634 = new BitSet(new long[]{0x0000006800000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__4_in_rule__NodeClass__Group__34637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__NodeClass__Group__3__Impl4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__4__Impl_in_rule__NodeClass__Group__44696 = new BitSet(new long[]{0x0400000040002000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__5_in_rule__NodeClass__Group__44699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4_in_rule__NodeClass__Group__4__Impl4726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__5__Impl_in_rule__NodeClass__Group__54756 = new BitSet(new long[]{0x0400000040002000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__6_in_rule__NodeClass__Group__54759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__ThreadsAssignment_5_in_rule__NodeClass__Group__5__Impl4786 = new BitSet(new long[]{0x0400000000002002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group__6__Impl_in_rule__NodeClass__Group__64817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__NodeClass__Group__6__Impl4845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__0__Impl_in_rule__NodeClass__Group_4_0__04890 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__1_in_rule__NodeClass__Group_4_0__04893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__NodeClass__Group_4_0__0__Impl4921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__1__Impl_in_rule__NodeClass__Group_4_0__14952 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__2_in_rule__NodeClass__Group_4_0__14955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__NodeClass__Group_4_0__1__Impl4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__2__Impl_in_rule__NodeClass__Group_4_0__25014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__RuntimeAssignment_4_0_2_in_rule__NodeClass__Group_4_0__2__Impl5041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__0__Impl_in_rule__NodeClass__Group_4_1__05077 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__1_in_rule__NodeClass__Group_4_1__05080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__NodeClass__Group_4_1__0__Impl5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__1__Impl_in_rule__NodeClass__Group_4_1__15139 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__2_in_rule__NodeClass__Group_4_1__15142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__NodeClass__Group_4_1__1__Impl5170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__2__Impl_in_rule__NodeClass__Group_4_1__25201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__PriominAssignment_4_1_2_in_rule__NodeClass__Group_4_1__2__Impl5228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__0__Impl_in_rule__NodeClass__Group_4_2__05264 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__1_in_rule__NodeClass__Group_4_2__05267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__NodeClass__Group_4_2__0__Impl5295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__1__Impl_in_rule__NodeClass__Group_4_2__15326 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__2_in_rule__NodeClass__Group_4_2__15329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__NodeClass__Group_4_2__1__Impl5357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__2__Impl_in_rule__NodeClass__Group_4_2__25388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__PriomaxAssignment_4_2_2_in_rule__NodeClass__Group_4_2__2__Impl5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__0__Impl_in_rule__PhysicalThread__Group__05451 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__1_in_rule__PhysicalThread__Group__05454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Alternatives_0_in_rule__PhysicalThread__Group__0__Impl5481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__1__Impl_in_rule__PhysicalThread__Group__15511 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__2_in_rule__PhysicalThread__Group__15514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__NameAssignment_1_in_rule__PhysicalThread__Group__1__Impl5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__2__Impl_in_rule__PhysicalThread__Group__25571 = new BitSet(new long[]{0x00001F8000000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__3_in_rule__PhysicalThread__Group__25574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__PhysicalThread__Group__2__Impl5602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__3__Impl_in_rule__PhysicalThread__Group__35633 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__4_in_rule__PhysicalThread__Group__35636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3_in_rule__PhysicalThread__Group__3__Impl5663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group__4__Impl_in_rule__PhysicalThread__Group__45693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__PhysicalThread__Group__4__Impl5721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__0__Impl_in_rule__PhysicalThread__Group_3_0__05762 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__1_in_rule__PhysicalThread__Group_3_0__05765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__PhysicalThread__Group_3_0__0__Impl5793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__1__Impl_in_rule__PhysicalThread__Group_3_0__15824 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__2_in_rule__PhysicalThread__Group_3_0__15827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PhysicalThread__Group_3_0__1__Impl5855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__2__Impl_in_rule__PhysicalThread__Group_3_0__25886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__ExecmodeAssignment_3_0_2_in_rule__PhysicalThread__Group_3_0__2__Impl5913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__0__Impl_in_rule__PhysicalThread__Group_3_1__05949 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__1_in_rule__PhysicalThread__Group_3_1__05952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__PhysicalThread__Group_3_1__0__Impl5980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__1__Impl_in_rule__PhysicalThread__Group_3_1__16011 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__2_in_rule__PhysicalThread__Group_3_1__16014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PhysicalThread__Group_3_1__1__Impl6042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__2__Impl_in_rule__PhysicalThread__Group_3_1__26073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__TimeAssignment_3_1_2_in_rule__PhysicalThread__Group_3_1__2__Impl6100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__0__Impl_in_rule__PhysicalThread__Group_3_2__06136 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__1_in_rule__PhysicalThread__Group_3_2__06139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__PhysicalThread__Group_3_2__0__Impl6167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__1__Impl_in_rule__PhysicalThread__Group_3_2__16198 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__2_in_rule__PhysicalThread__Group_3_2__16201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PhysicalThread__Group_3_2__1__Impl6229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__2__Impl_in_rule__PhysicalThread__Group_3_2__26260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__PrioAssignment_3_2_2_in_rule__PhysicalThread__Group_3_2__2__Impl6287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__0__Impl_in_rule__PhysicalThread__Group_3_3__06323 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__1_in_rule__PhysicalThread__Group_3_3__06326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__PhysicalThread__Group_3_3__0__Impl6354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__1__Impl_in_rule__PhysicalThread__Group_3_3__16385 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__2_in_rule__PhysicalThread__Group_3_3__16388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PhysicalThread__Group_3_3__1__Impl6416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__2__Impl_in_rule__PhysicalThread__Group_3_3__26447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__StacksizeAssignment_3_3_2_in_rule__PhysicalThread__Group_3_3__2__Impl6474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__0__Impl_in_rule__PhysicalThread__Group_3_4__06510 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__1_in_rule__PhysicalThread__Group_3_4__06513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__PhysicalThread__Group_3_4__0__Impl6541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__1__Impl_in_rule__PhysicalThread__Group_3_4__16572 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__2_in_rule__PhysicalThread__Group_3_4__16575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PhysicalThread__Group_3_4__1__Impl6603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__2__Impl_in_rule__PhysicalThread__Group_3_4__26634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__MsgblocksizeAssignment_3_4_2_in_rule__PhysicalThread__Group_3_4__2__Impl6661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__0__Impl_in_rule__PhysicalThread__Group_3_5__06697 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__1_in_rule__PhysicalThread__Group_3_5__06700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__PhysicalThread__Group_3_5__0__Impl6728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__1__Impl_in_rule__PhysicalThread__Group_3_5__16759 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__2_in_rule__PhysicalThread__Group_3_5__16762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__PhysicalThread__Group_3_5__1__Impl6790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__2__Impl_in_rule__PhysicalThread__Group_3_5__26821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__MsgpoolsizeAssignment_3_5_2_in_rule__PhysicalThread__Group_3_5__2__Impl6848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__0__Impl_in_rule__RuntimeClass__Group__06884 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__1_in_rule__RuntimeClass__Group__06887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__RuntimeClass__Group__0__Impl6915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__1__Impl_in_rule__RuntimeClass__Group__16946 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__2_in_rule__RuntimeClass__Group__16949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__NameAssignment_1_in_rule__RuntimeClass__Group__1__Impl6976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__2__Impl_in_rule__RuntimeClass__Group__27006 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__3_in_rule__RuntimeClass__Group__27009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__DocuAssignment_2_in_rule__RuntimeClass__Group__2__Impl7036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__3__Impl_in_rule__RuntimeClass__Group__37067 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__4_in_rule__RuntimeClass__Group__37070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__RuntimeClass__Group__3__Impl7098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__4__Impl_in_rule__RuntimeClass__Group__47129 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__5_in_rule__RuntimeClass__Group__47132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RuntimeClass__Group__4__Impl7160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__5__Impl_in_rule__RuntimeClass__Group__57191 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__6_in_rule__RuntimeClass__Group__57194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__RuntimeClass__Group__5__Impl7222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__6__Impl_in_rule__RuntimeClass__Group__67253 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__7_in_rule__RuntimeClass__Group__67256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__ThreadModelAssignment_6_in_rule__RuntimeClass__Group__6__Impl7283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuntimeClass__Group__7__Impl_in_rule__RuntimeClass__Group__77313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__RuntimeClass__Group__7__Impl7341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__0__Impl_in_rule__PRIO__Group__07388 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__PRIO__Group__1_in_rule__PRIO__Group__07391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Alternatives_0_in_rule__PRIO__Group__0__Impl7418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PRIO__Group__1__Impl_in_rule__PRIO__Group__17449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PRIO__Group__1__Impl7476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__07509 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__07512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Import__Group__0__Impl7540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__17571 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__17574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Alternatives_1_in_rule__Import__Group__1__Impl7601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__27631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_2_in_rule__Import__Group__2__Impl7658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__0__Impl_in_rule__Import__Group_1_0__07694 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1_in_rule__Import__Group_1_0__07697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_0_0_in_rule__Import__Group_1_0__0__Impl7724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group_1_0__1__Impl_in_rule__Import__Group_1_0__17754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Import__Group_1_0__1__Impl7782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__0__Impl_in_rule__ImportedFQN__Group__07817 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1_in_rule__ImportedFQN__Group__07820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__ImportedFQN__Group__0__Impl7847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportedFQN__Group__1__Impl_in_rule__ImportedFQN__Group__17876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ImportedFQN__Group__1__Impl7905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__07942 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__07945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl7972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__18001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl8028 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__08063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__08066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__FQN__Group_1__0__Impl8094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__18125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl8152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__0__Impl_in_rule__KeyValue__Group__08188 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1_in_rule__KeyValue__Group__08191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__KeyAssignment_0_in_rule__KeyValue__Group__0__Impl8218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__1__Impl_in_rule__KeyValue__Group__18248 = new BitSet(new long[]{0x100200000004C160L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2_in_rule__KeyValue__Group__18251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__KeyValue__Group__1__Impl8279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__Group__2__Impl_in_rule__KeyValue__Group__28310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__KeyValue__ValueAssignment_2_in_rule__KeyValue__Group__2__Impl8337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__0__Impl_in_rule__SimpleAnnotationAttribute__Group__08376 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1_in_rule__SimpleAnnotationAttribute__Group__08379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Alternatives_0_in_rule__SimpleAnnotationAttribute__Group__0__Impl8406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__1__Impl_in_rule__SimpleAnnotationAttribute__Group__18436 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2_in_rule__SimpleAnnotationAttribute__Group__18439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__SimpleAnnotationAttribute__Group__1__Impl8467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__2__Impl_in_rule__SimpleAnnotationAttribute__Group__28498 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3_in_rule__SimpleAnnotationAttribute__Group__28501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__NameAssignment_2_in_rule__SimpleAnnotationAttribute__Group__2__Impl8528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__3__Impl_in_rule__SimpleAnnotationAttribute__Group__38558 = new BitSet(new long[]{0x000000000F000000L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4_in_rule__SimpleAnnotationAttribute__Group__38561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__SimpleAnnotationAttribute__Group__3__Impl8589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__Group__4__Impl_in_rule__SimpleAnnotationAttribute__Group__48620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleAnnotationAttribute__TypeAssignment_4_in_rule__SimpleAnnotationAttribute__Group__4__Impl8647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__0__Impl_in_rule__EnumAnnotationAttribute__Group__08687 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1_in_rule__EnumAnnotationAttribute__Group__08690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Alternatives_0_in_rule__EnumAnnotationAttribute__Group__0__Impl8717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__1__Impl_in_rule__EnumAnnotationAttribute__Group__18747 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2_in_rule__EnumAnnotationAttribute__Group__18750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__EnumAnnotationAttribute__Group__1__Impl8778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__2__Impl_in_rule__EnumAnnotationAttribute__Group__28809 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3_in_rule__EnumAnnotationAttribute__Group__28812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__NameAssignment_2_in_rule__EnumAnnotationAttribute__Group__2__Impl8839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__3__Impl_in_rule__EnumAnnotationAttribute__Group__38869 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4_in_rule__EnumAnnotationAttribute__Group__38872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EnumAnnotationAttribute__Group__3__Impl8900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__4__Impl_in_rule__EnumAnnotationAttribute__Group__48931 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5_in_rule__EnumAnnotationAttribute__Group__48934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__EnumAnnotationAttribute__Group__4__Impl8962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__5__Impl_in_rule__EnumAnnotationAttribute__Group__58993 = new BitSet(new long[]{0x0008000040000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6_in_rule__EnumAnnotationAttribute__Group__58996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_5_in_rule__EnumAnnotationAttribute__Group__5__Impl9023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__6__Impl_in_rule__EnumAnnotationAttribute__Group__69053 = new BitSet(new long[]{0x0008000040000000L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7_in_rule__EnumAnnotationAttribute__Group__69056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0_in_rule__EnumAnnotationAttribute__Group__6__Impl9083 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group__7__Impl_in_rule__EnumAnnotationAttribute__Group__79114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EnumAnnotationAttribute__Group__7__Impl9142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__0__Impl_in_rule__EnumAnnotationAttribute__Group_6__09189 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1_in_rule__EnumAnnotationAttribute__Group_6__09192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__EnumAnnotationAttribute__Group_6__0__Impl9220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__Group_6__1__Impl_in_rule__EnumAnnotationAttribute__Group_6__19251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumAnnotationAttribute__ValuesAssignment_6_1_in_rule__EnumAnnotationAttribute__Group_6__1__Impl9278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__0__Impl_in_rule__Documentation__Group__09312 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1_in_rule__Documentation__Group__09315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__1__Impl_in_rule__Documentation__Group__19373 = new BitSet(new long[]{0x0020000000000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2_in_rule__Documentation__Group__19376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__Documentation__Group__1__Impl9404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__Group__2__Impl_in_rule__Documentation__Group__29435 = new BitSet(new long[]{0x0020000000000100L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3_in_rule__Documentation__Group__29438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Documentation__LinesAssignment_2_in_rule__Documentation__Group__2__Impl9465 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Documentation__Group__3__Impl_in_rule__Documentation__Group__39496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__Documentation__Group__3__Impl9524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__0__Impl_in_rule__TIME__Group_0__09563 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__1_in_rule__TIME__Group_0__09566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_0__0__Impl9593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_0__1__Impl_in_rule__TIME__Group_0__19622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__TIME__Group_0__1__Impl9650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__0__Impl_in_rule__TIME__Group_1__09685 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__1_in_rule__TIME__Group_1__09688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_1__0__Impl9715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_1__1__Impl_in_rule__TIME__Group_1__19744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__TIME__Group_1__1__Impl9772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__0__Impl_in_rule__TIME__Group_2__09807 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__1_in_rule__TIME__Group_2__09810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_2__0__Impl9837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_2__1__Impl_in_rule__TIME__Group_2__19866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__TIME__Group_2__1__Impl9894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__0__Impl_in_rule__TIME__Group_3__09929 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__1_in_rule__TIME__Group_3__09932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TIME__Group_3__0__Impl9959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TIME__Group_3__1__Impl_in_rule__TIME__Group_3__19988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__TIME__Group_3__1__Impl10016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__0__Impl_in_rule__BooleanLiteral__Group__010053 = new BitSet(new long[]{0x1000000000040000L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1_in_rule__BooleanLiteral__Group__010056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Group__1__Impl_in_rule__BooleanLiteral__Group__110114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__Alternatives_1_in_rule__BooleanLiteral__Group__1__Impl10141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__0__Impl_in_rule__RealLiteral__Group__010175 = new BitSet(new long[]{0x000200000000C060L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1_in_rule__RealLiteral__Group__010178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__Group__1__Impl_in_rule__RealLiteral__Group__110236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteral__ValueAssignment_1_in_rule__RealLiteral__Group__1__Impl10263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__0__Impl_in_rule__IntLiteral__Group__010297 = new BitSet(new long[]{0x000000000000C060L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1_in_rule__IntLiteral__Group__010300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__Group__1__Impl_in_rule__IntLiteral__Group__110358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntLiteral__ValueAssignment_1_in_rule__IntLiteral__Group__1__Impl10385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__0__Impl_in_rule__StringLiteral__Group__010419 = new BitSet(new long[]{0x100200000004C160L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1_in_rule__StringLiteral__Group__010422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__Group__1__Impl_in_rule__StringLiteral__Group__110480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_1_in_rule__StringLiteral__Group__1__Impl10507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__0__Impl_in_rule__SignedInteger__Group__010541 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1_in_rule__SignedInteger__Group__010544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Alternatives_0_in_rule__SignedInteger__Group__0__Impl10571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SignedInteger__Group__1__Impl_in_rule__SignedInteger__Group__110602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SignedInteger__Group__1__Impl10629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__0__Impl_in_rule__Decimal__Group__010662 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1_in_rule__Decimal__Group__010665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Alternatives_0_in_rule__Decimal__Group__0__Impl10692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__1__Impl_in_rule__Decimal__Group__110723 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2_in_rule__Decimal__Group__110726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__1__Impl10753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__2__Impl_in_rule__Decimal__Group__210782 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3_in_rule__Decimal__Group__210785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Decimal__Group__2__Impl10813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decimal__Group__3__Impl_in_rule__Decimal__Group__310844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Decimal__Group__3__Impl10871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__0__Impl_in_rule__DotDecimal__Group__010908 = new BitSet(new long[]{0x000200000000C000L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1_in_rule__DotDecimal__Group__010911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Alternatives_0_in_rule__DotDecimal__Group__0__Impl10938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__1__Impl_in_rule__DotDecimal__Group__110969 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2_in_rule__DotDecimal__Group__110972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__DotDecimal__Group__1__Impl11000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DotDecimal__Group__2__Impl_in_rule__DotDecimal__Group__211031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DotDecimal__Group__2__Impl11058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__0__Impl_in_rule__DecimalDot__Group__011093 = new BitSet(new long[]{0x000000000000C040L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1_in_rule__DecimalDot__Group__011096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Alternatives_0_in_rule__DecimalDot__Group__0__Impl11123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__1__Impl_in_rule__DecimalDot__Group__111154 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2_in_rule__DecimalDot__Group__111157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalDot__Group__1__Impl11184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalDot__Group__2__Impl_in_rule__DecimalDot__Group__211213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__DecimalDot__Group__2__Impl11241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__0__Impl_in_rule__DecimalExp__Group__011278 = new BitSet(new long[]{0x000200000000C060L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1_in_rule__DecimalExp__Group__011281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Alternatives_0_in_rule__DecimalExp__Group__0__Impl11308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__1__Impl_in_rule__DecimalExp__Group__111339 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2_in_rule__DecimalExp__Group__111342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__1__Impl11369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__2__Impl_in_rule__DecimalExp__Group__211398 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3_in_rule__DecimalExp__Group__211401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__DecimalExp__Group__2__Impl11429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__3__Impl_in_rule__DecimalExp__Group__311460 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4_in_rule__DecimalExp__Group__311463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DecimalExp__Group__3__Impl11490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalExp__Group__4__Impl_in_rule__DecimalExp__Group__411519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXP_in_rule__DecimalExp__Group__4__Impl11546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__0_in_rule__NodeClass__UnorderedGroup_411586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_0__0_in_rule__NodeClass__UnorderedGroup_4__Impl11675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_1__0_in_rule__NodeClass__UnorderedGroup_4__Impl11766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__Group_4_2__0_in_rule__NodeClass__UnorderedGroup_4__Impl11857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__011916 = new BitSet(new long[]{0x0000006800000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__1_in_rule__NodeClass__UnorderedGroup_4__011919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__111944 = new BitSet(new long[]{0x0000006800000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__2_in_rule__NodeClass__UnorderedGroup_4__111947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeClass__UnorderedGroup_4__Impl_in_rule__NodeClass__UnorderedGroup_4__211972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__0_in_rule__PhysicalThread__UnorderedGroup_312002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_0__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_1__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_2__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_3__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_4__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__Group_3_5__0_in_rule__PhysicalThread__UnorderedGroup_3__Impl12546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__012605 = new BitSet(new long[]{0x00001F8000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__1_in_rule__PhysicalThread__UnorderedGroup_3__012608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__112633 = new BitSet(new long[]{0x00001F8000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__2_in_rule__PhysicalThread__UnorderedGroup_3__112636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__212661 = new BitSet(new long[]{0x00001F8000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__3_in_rule__PhysicalThread__UnorderedGroup_3__212664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__312689 = new BitSet(new long[]{0x00001F8000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__4_in_rule__PhysicalThread__UnorderedGroup_3__312692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__412717 = new BitSet(new long[]{0x00001F8000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__5_in_rule__PhysicalThread__UnorderedGroup_3__412720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhysicalThread__UnorderedGroup_3__Impl_in_rule__PhysicalThread__UnorderedGroup_3__512745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__PhysicalModel__NameAssignment_112785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PhysicalModel__ImportsAssignment_312816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalSystem_in_rule__PhysicalModel__SystemsAssignment_4_012847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeClass_in_rule__PhysicalModel__NodeClassesAssignment_4_112878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuntimeClass_in_rule__PhysicalModel__RuntimeClassesAssignment_4_212909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhysicalSystem__NameAssignment_112940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__PhysicalSystem__DocuAssignment_212971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rule__PhysicalSystem__NodeRefsAssignment_413002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NodeRef__NameAssignment_113033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__NodeRef__TypeAssignment_313068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__NodeRef__DocuAssignment_413103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NodeClass__NameAssignment_113134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__NodeClass__DocuAssignment_213165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__NodeClass__RuntimeAssignment_4_0_213200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__NodeClass__PriominAssignment_4_1_213235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__NodeClass__PriomaxAssignment_4_2_213266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhysicalThread_in_rule__NodeClass__ThreadsAssignment_513297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__PhysicalThread__DefaultAssignment_0_013333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhysicalThread__NameAssignment_113372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecMode_in_rule__PhysicalThread__ExecmodeAssignment_3_0_213403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTIME_in_rule__PhysicalThread__TimeAssignment_3_1_213434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePRIO_in_rule__PhysicalThread__PrioAssignment_3_2_213465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__StacksizeAssignment_3_3_213496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgblocksizeAssignment_3_4_213527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PhysicalThread__MsgpoolsizeAssignment_3_5_213558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RuntimeClass__NameAssignment_113589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentation_in_rule__RuntimeClass__DocuAssignment_213620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThreadModel_in_rule__RuntimeClass__ThreadModelAssignment_613651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportedFQN_in_rule__Import__ImportedNamespaceAssignment_1_0_013682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_213713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__KeyValue__KeyAssignment_013747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__KeyValue__ValueAssignment_213778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__SimpleAnnotationAttribute__OptionalAssignment_0_013820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleAnnotationAttribute__NameAssignment_213859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralType_in_rule__SimpleAnnotationAttribute__TypeAssignment_413890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__EnumAnnotationAttribute__OptionalAssignment_0_013926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EnumAnnotationAttribute__NameAssignment_213965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_513996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumAnnotationAttribute__ValuesAssignment_6_114027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Documentation__LinesAssignment_214058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__BooleanLiteral__IsTrueAssignment_1_114096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReal_in_rule__RealLiteral__ValueAssignment_114135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__IntLiteral__ValueAssignment_114166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment_114197 = new BitSet(new long[]{0x0000000000000002L});

}
