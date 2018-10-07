package com.india.engin.jumbledwords;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Play extends AppCompatActivity {
    TextView shuffled,topp,score;
    EditText guessed;
    String value,currentWord,shuffleit;
    Random r;
    String[] med={"disease", "breast", "combine", "collect", "correct", "parking", "quickly", "stupid", "credit", "elderly", "victim", "whereas", "speaker", "vision", "recipe", "withdraw", "entirely", "organic", "estate", "dining", "slowly", "suspect", "coffee", "basket", "external", "mother", "serious", "soccer", "tactic", "analyst", "expand", "motion", "compose", "shadow", "barely", "project", "testify", "victory", "whenever", "window", "worried", "historic", "Indian", "usually", "tendency", "cancer", "cotton", "myself", "offense", "bullet", "somewhat", "tobacco", "merely", "qualify", "similar", "species", "unknown", "street", "convince", "educate", "feature", "campaign", "recruit", "contact", "crisis", "episode", "nothing", "reaction", "opening", "thousand", "together", "collapse", "target", "alliance", "deserve", "pressure", "revenue", "degree", "conflict", "wander", "general", "delivery", "handful", "standard", "divide", "Islamic", "perhaps", "arrival", "salary", "battle", "exciting", "assume", "quietly", "minute", "smooth", "release", "twelve", "pretend", "contain", "problem", "talent", "magazine", "career", "expert", "vehicle", "contrast", "cheese", "scheme", "little", "changing", "number", "suicide", "potato", "variety", "shortly", "numerous", "activity", "beside", "approval", "blanket", "welfare", "consumer", "nation", "branch", "matter", "script", "sequence", "result", "exchange", "politics", "around", "gallery", "lovely", "arrest", "plastic", "rating", "slightly", "language", "unlikely", "dispute", "southern", "writer", "Chinese", "advocate", "garden", "valuable", "properly", "regular", "distance", "monitor", "phrase", "academic", "familiar", "largely", "mission", "former", "except", "despite", "everyone", "predict", "annual", "approach", "ethics", "everyday", "pregnant", "effort", "surprise", "straight", "Soviet", "afraid", "engine", "growth", "operator", "insight", "carbon", "dialogue", "internal", "pattern", "senior", "miracle", "poetry", "struggle", "amount", "finger", "attitude", "mixture", "athlete", "fabric", "national", "German", "should", "belief", "stranger", "retire", "reform", "benefit", "entire", "priority", "solution", "garage", "domestic", "succeed", "Israeli", "museum", "negative", "fellow", "hardly", "quarter", "weapon", "marriage", "unusual", "afford", "creature", "change", "evening", "painful", "escape", "nobody", "conduct", "detailed", "passion", "sudden", "teenager", "manner", "birthday", "strongly", "invasion", "tomorrow", "holiday", "request", "inside", "derive", "useful", "hunter", "totally", "recent", "employee", "amazing", "neighbor", "already", "friendly", "belong", "select", "fortune", "pleasure", "admire", "destroy", "forest", "pepper", "agency", "border", "roughly", "schedule", "sentence", "public", "source", "series", "review", "thirty", "tissue", "industry", "describe", "device", "shooting", "single", "breath", "report", "faculty", "actually", "veteran", "violate", "strength", "chapter", "neither", "observe", "include", "opponent", "payment", "software", "thinking", "exercise", "business", "Olympic", "deficit", "opposite", "accurate", "attach", "proposal", "shelter", "audience", "primary", "office", "vessel", "expense", "locate", "hunting", "scared", "school", "history", "security", "employer", "library", "install", "action", "champion", "extent", "hungry", "member", "nuclear", "legend", "colonial", "guilty", "sacred", "nervous", "period", "chairman", "invite", "heaven", "brother", "yourself", "weekly", "decline", "massive", "edition", "reason", "highway", "client", "disagree", "fairly", "trouble", "visible", "lawyer", "comfort", "protein", "beneath", "sister", "artistic", "couple", "critical", "article", "cooking", "treaty", "through", "possibly", "separate", "certain", "letter", "habitat", "private", "director", "arrive", "proceed", "vacation", "define", "differ", "decrease", "unless", "purpose", "towards", "finding", "standing", "message", "deeply", "session", "enable", "terrible", "passage", "weight", "ongoing", "argument", "working", "strong", "apparent", "speech", "consider", "testing", "although", "exposure", "produce", "absence", "control", "present", "strategy", "designer", "advance", "market", "heavily", "origin", "policy", "thanks", "virtue", "lifetime", "string", "divorce", "mention", "gifted", "organize", "killer", "assign", "involve", "plenty", "however", "privacy", "citizen", "concert", "instead", "relative", "sanction", "ability", "camera", "occasion", "shoulder", "literary", "aspect", "traffic", "supply", "abortion", "defend", "formal", "global", "parent", "division", "signal", "clearly", "emerge", "equally", "health", "affair", "heritage", "mutual", "quality", "decide", "resource", "taxpayer", "honest", "regime", "fighting", "anywhere", "closer", "expose", "factor", "picture", "fashion", "creative", "flight", "defense", "hospital", "sexual", "distant", "liberal", "village", "bathroom", "critic", "contest", "freedom", "medical", "location", "tunnel", "mostly", "greatest", "junior", "button", "column", "reveal", "athletic", "funeral", "studio", "normal", "headline", "terror", "American", "always", "center", "energy", "suggest", "gender", "spending", "generate", "building", "lesson", "society", "African", "founder", "oppose", "pursue", "announce", "element", "symbol", "relation", "square", "cultural", "analyze", "impact", "Jewish", "partly", "simply", "decision", "moment", "evolve", "ticket", "recall", "existing", "running", "reflect", "century", "another", "twenty", "emphasis", "continue", "channel", "innocent", "repeat", "confirm", "prefer", "provide", "native", "severe", "Muslim", "various", "incident", "college", "handle", "musician", "variable", "council", "bother", "danger", "absolute", "drawing", "capacity", "stroke", "platform", "modest", "clinical", "somehow", "chemical", "slight", "double", "graduate", "artist", "briefly", "electric", "threat", "section", "abandon", "express", "stomach", "income", "gently", "shopping", "patient", "asleep", "interest", "commit", "planet", "likely", "grocery", "poverty", "promote", "wisdom", "season", "travel", "Congress", "engineer", "identity", "teacher", "resident", "choice", "context", "nature", "itself", "strange", "really", "charge", "special", "climate", "disaster", "careful", "friend", "before", "remind", "resort", "surface", "Democrat", "setting", "surgery", "fourth", "enough", "constant", "profit", "workshop", "spring", "anyway", "winner", "nearby", "northern", "closely", "lawsuit", "protect", "resemble", "teaching", "appoint", "online", "damage", "employ", "perceive", "people", "wedding", "access", "training", "length", "fiction", "measure", "operate", "curious", "island", "author", "bombing", "behind", "consist", "modern", "courage", "relate", "success", "morning", "stable", "require", "discuss", "election", "receive", "screen", "advice", "country", "finance", "accept", "ground", "medium", "permit", "stretch", "entrance", "nearly", "explain", "economic", "convert", "foreign", "opinion", "resist", "Russian", "widely", "embrace", "married", "penalty", "intend", "concept", "military", "mental", "beyond", "clinic", "factory", "achieve", "religion", "violence", "welcome", "network", "record", "finally", "practice", "producer", "deliver", "medicine", "submit", "tomato", "crucial", "complete", "occupy", "hearing", "follow", "counter", "broken", "writing", "meaning", "funding", "effect", "painting", "advanced", "search", "fifteen", "painter", "threaten", "illness", "disorder", "living", "person", "captain", "instance", "moreover", "scandal", "product", "Japanese", "frequent", "billion", "galaxy", "ultimate", "coverage", "attack", "expect", "fantasy", "healthy", "recover", "survival", "French", "partner", "Senate", "spirit", "summit", "proposed", "battery", "future", "teaspoon", "without", "comedy", "anymore", "demand", "proper", "rarely", "several", "though", "wooden", "engage", "Mexican", "balance", "function", "either", "symptom", "tragedy", "arrange", "retain", "compete", "sustain", "chamber", "decade", "easily", "fishing", "complain", "mortgage", "versus", "province", "better", "adequate", "cabinet", "editor", "publish", "unique", "answer", "address", "eastern", "barrier", "dealer", "culture", "identify", "barrel", "increase", "sector", "consume", "therapy", "overcome", "alcohol", "custom", "central", "accident", "complex", "criteria", "gesture", "radical", "science", "service", "behavior", "social", "anybody", "yellow", "segment", "uniform", "famous", "impose", "burden", "church", "ancient", "muscle", "suppose", "refuse", "profile", "somebody", "dominant", "civilian", "adjust", "return", "status", "earnings", "capital", "previous", "routine", "settle", "invest", "simple", "utility", "whether", "believe", "indicate", "supposed", "propose", "specific", "beauty", "perfect", "moderate", "overall", "confront", "popular", "approve", "devote", "distinct", "replace", "circle", "downtown", "powder", "directly", "family", "assess", "outside", "ordinary", "exceed", "portray", "helpful", "attend", "prevent", "subject", "manage", "choose", "comment", "estimate", "diverse", "explore", "extreme", "intense", "racial", "reader", "horizon", "European", "bright", "capture", "meeting", "account", "secret", "thought", "emotion", "inspire", "herself", "mirror", "original", "chicken", "prospect", "toward", "legacy", "surely", "chance", "rapidly", "suddenly", "dramatic", "wealthy", "whisper", "favorite", "tongue", "breathe", "reading", "survive", "throat", "garlic", "leading", "pretty", "growing", "attorney", "depict", "genetic", "darkness", "leader", "depend", "content", "summer", "universe", "position", "version", "forget", "student", "cousin", "portrait", "besides", "detail", "display", "mystery", "overlook", "protest", "satisfy", "surround", "actress", "license", "memory", "pocket", "Italian", "silence", "enormous", "natural", "tennis", "unlike", "Internet", "league", "player", "theater", "cookie", "housing", "reject", "assert", "station", "witness", "secure", "fitness", "movement", "undergo", "across", "educator", "feeling", "prayer", "finish", "bottle", "golden", "refugee", "leather", "stress", "wonder", "active", "transfer", "minority", "purchase", "customer", "visual", "e-mail", "involved", "property", "driver", "worker", "regional", "visitor", "bridge", "prepare", "Catholic", "official", "obtain", "steady", "husband", "creation", "restore", "daughter", "planning", "warning", "normally", "homeless", "anxiety", "million", "journal", "launch", "facility", "portion", "stream", "dinner", "impress", "mistake", "capable", "program", "recovery", "improve", "criminal", "second", "possess", "against", "ensure", "ethnic", "document", "spread", "dominate", "flower", "clothes", "probably", "flavor", "federal", "option", "process", "between", "register", "analysis", "officer", "height", "formula", "addition", "concern", "mainly", "positive", "prison", "provider", "silent", "infant", "preserve", "relevant", "musical", "doctor", "initial", "outcome", "promise", "animal", "minister", "possible", "perform", "remote", "budget", "learning", "weekend", "method", "violent", "contract", "majority", "romantic", "valley", "direct", "illegal", "object", "question", "assure", "compare", "survivor", "machine", "freeze", "kitchen", "mm-hmm", "desert", "failure", "respond", "happen", "squeeze", "prisoner", "father", "boundary", "notion", "scenario", "please", "justice", "notice", "defeat", "female", "company", "classic", "campus", "reality", "computer", "gather", "insist", "response", "maintain", "hundred", "realize", "accuse", "football", "county", "jacket", "common", "missile", "package", "assist", "reporter", "indeed", "debate", "tension", "physical", "western", "judgment", "exactly", "affect", "weather", "margin", "fighter", "multiple", "ceremony", "mountain", "obvious", "regulate", "listen", "activist", "typical", "because", "emission", "inform", "category", "within", "figure", "makeup", "survey", "relief", "respect", "switch", "journey", "observer", "rather", "police", "viewer", "airline", "someone", "farmer", "carrier", "actual", "develop", "economy", "support", "borrow", "glance", "unable", "safety", "example", "digital", "extend", "remove", "regard", "evidence", "during", "murder", "corner", "assault", "highly", "orange", "persuade", "scholar", "English", "evaluate", "Spanish", "shower", "charity", "attract", "middle", "tourist", "United", "British", "airport", "appear", "himself", "adviser", "injury", "manager", "forever", "anyone", "bedroom", "tonight", "district", "agenda", "volume", "connect", "acquire", "clothing", "discover", "dismiss", "rhythm", "sample", "abroad", "remain", "nowhere", "examine", "reduce", "whatever", "command", "forward", "silver", "governor", "conclude", "winter", "recently", "presence", "wealth", "master", "willing", "region", "justify", "design", "course", "Supreme", "current", "butter", "investor", "scream", "theory", "anything", "remember", "almost", "personal", "narrow", "deputy", "advise", "research", "soldier", "desire", "publicly", "storage", "suffer", "venture", "exhibit", "detect", "average", "limited", "become", "absorb", "Canadian", "cluster", "enhance", "priest", "explode", "inquiry", "resolve", "saving", "senator", "strike", "system", "killing", "bottom", "prompt", "ceiling", "others", "aircraft", "appeal", "attempt", "concrete", "create", "progress", "imagine", "declare", "horror", "material", "baseball", "powerful", "singer", "latter"};
    String[] diffi = {"necessary", "carefully", "cholesterol", "Palestinian", "opposition", "yesterday", "personality", "successfully", "determine", "afternoon", "advantage", "assistant", "immediate", "interested", "exhibition", "concentrate", "dimension", "expansion", "eventually", "institutional", "passenger", "corporate", "enforcement", "significant", "interpret", "alternative", "apartment", "cigarette", "consensus", "throughout", "experience", "commitment", "maintenance", "depending", "colleague", "commission", "philosophy", "encounter", "precisely", "negotiation", "instruction", "department", "something", "virtually", "architect", "temporary", "suggestion", "engineering", "assistance", "explanation", "permission", "seriously", "membership", "calculate", "conclusion", "permanent", "insurance", "celebrity", "translate", "distinguish", "percentage", "incentive", "transform", "complaint", "attractive", "marketing", "defendant", "discussion", "nomination", "capability", "satellite", "distribution", "representative", "interesting", "incorporate", "narrative", "Christian", "admission", "themselves", "certainly", "apparently", "technique", "literature", "accompany", "electronic", "restriction", "measurement", "surprisingly", "territory", "girlfriend", "initiative", "nevertheless", "mechanism", "initially", "sometimes", "background", "gradually", "literally", "comprehensive", "efficiency", "therefore", "component", "provision", "independent", "impressive", "impression", "reference", "remaining", "congressional", "technical", "candidate", "photographer", "available", "championship", "technology", "biological", "collection", "criticize", "representation", "contemporary", "principal", "assignment", "obviously", "dangerous", "spiritual", "constitute", "guideline", "previously", "participate", "everybody", "atmosphere", "political", "commercial", "surprised", "formation", "opportunity", "spokesman", "desperate", "government", "principle", "development", "pollution", "African-American", "beginning", "tradition", "explosion", "concerned", "economics", "prescription", "medication", "involvement", "basketball", "difficulty", "everywhere", "publisher", "improvement", "instructor", "relationship", "wonderful", "structure", "strategic", "democracy", "participant", "immigration", "satisfaction", "pregnancy", "education", "developing", "so-called", "coalition", "collective", "comfortable", "evolution", "conservative", "existence", "legislation", "increasingly", "arrangement", "quarterback", "phenomenon", "operation", "increased", "proportion", "unfortunately", "long-term", "secretary", "researcher", "president", "prosecutor", "recommendation", "emotional", "headquarters", "potential", "requirement", "consumption", "disappear", "construct", "continued", "environmental", "reduction", "attention", "beautiful", "transition", "investment", "successful", "procedure", "potentially", "tournament", "scientific", "testimony", "terrorist", "concentration", "supporter", "organization", "influence", "instrument", "protection", "imagination", "communication", "conversation", "consciousness", "resistance", "container", "entertainment", "cognitive", "religious", "transportation", "defensive", "reasonable", "publication", "appreciate", "presidential", "confusion", "expectation", "essentially", "appropriate", "administration", "preference", "conviction", "excellent", "celebration", "international", "infection", "authority", "establishment", "advertising", "important", "occupation", "Republican", "politically", "corporation", "scholarship", "educational", "approximately", "fundamental", "immigrant", "circumstance", "legitimate", "financial", "including", "democratic", "enterprise", "variation", "tablespoon", "childhood", "generation", "frequency", "definitely", "sensitive", "complicated", "communicate", "controversy", "significantly", "challenge", "negotiate", "respondent", "performance", "consequence", "personally", "statement", "telephone", "conference", "attribute", "intervention", "direction", "absolutely", "sophisticated", "institution", "reinforce", "significance", "knowledge", "volunteer", "obligation", "necessarily", "individual", "difference", "description", "recording", "independence", "foundation", "investigator", "electricity", "aggressive", "limitation", "effectively", "consistent", "physically", "dramatically", "violation", "represent", "classroom", "recognition", "boyfriend", "statistics", "assumption", "constitutional", "reflection", "telescope", "encourage", "reputation", "universal", "basically", "gentleman", "expensive", "professor", "adventure", "destruction", "inflation", "possibility", "friendship", "illustrate", "experiment", "psychology", "responsibility", "difficult", "household", "employment", "prominent", "correspondent", "furniture", "regularly", "revolution", "consideration", "meanwhile", "breakfast", "implication", "temperature", "eliminate", "exception", "operating", "ultimately", "intelligence", "presentation", "appointment", "vegetable", "industrial", "effective", "establish", "sufficient", "comparison", "participation", "newspaper", "characterize", "discovery", "punishment", "frustration", "community", "differently", "landscape", "reservation", "university", "discourse", "television", "appearance", "occasionally", "scientist", "interview", "everything", "considerable", "strengthen", "emphasize", "additional", "currently", "discrimination", "extensive", "understand", "composition", "interpretation", "professional", "assessment", "controversial", "cooperation", "recommend", "celebrate", "adolescent", "criticism", "similarly", "awareness", "information", "associate", "specialist", "extraordinary", "physician", "contribute", "competition", "manufacturer", "generally", "disability", "definition", "historical", "helicopter", "politician", "anticipate", "characteristic", "furthermore", "leadership", "consultant", "competitor", "constantly", "counselor", "neighborhood", "psychologist", "regulation", "accomplish", "chocolate", "acknowledge", "demonstration", "surprising", "importance", "repeatedly", "brilliant", "completely", "vulnerable", "framework", "efficient", "objective", "extension", "nonetheless", "economist", "widespread", "regarding", "immediately", "motivation", "terrorism", "grandfather", "journalist", "connection", "depression", "discipline", "committee", "impossible", "perception", "production", "combination", "especially", "commander", "elementary", "executive", "hypothesis", "achievement", "introduce", "responsible", "practical", "photograph", "management", "examination", "otherwise", "remarkable", "retirement", "condition", "orientation", "distinction", "particular", "recognize", "grandmother", "partnership", "historian", "typically", "substance", "equipment", "subsequent", "expression", "interaction", "highlight", "perspective", "regardless", "selection", "extremely", "agricultural", "conventional", "frequently", "according", "following", "introduction", "different", "evaluation", "particularly", "construction", "application", "contribution", "perfectly", "traditional", "administrator", "observation", "stability", "implement", "agreement", "intention", "resolution", "essential", "diversity", "environment", "manufacturing", "naturally", "lifestyle", "specifically", "increasing", "confidence", "investigate", "profession", "originally", "population", "treatment", "offensive", "incredible", "understanding", "substantial", "identification", "confident", "restaurant", "character", "distribute", "dependent", "elsewhere", "transformation", "ourselves", "ingredient", "laboratory", "tremendous", "situation", "emergency", "demonstrate", "indication", "anniversary", "guarantee", "competitive", "adjustment", "association", "investigation", "primarily", "curriculum", "preparation", "relatively", "psychological", "settlement", "somewhere", "personnel", "intellectual", "intensity", "Christmas", "convention"};
    String[] easy = {"menu", "maker", "win", "solve", "front", "gun", "paint", "gray", "bet", "there", "foot", "cheap", "dish", "gap", "talk", "value", "hang", "rain", "wait", "boy", "coal", "farm", "delay", "green", "ought", "arm", "less", "glove", "shall", "twice", "board", "brown", "ghost", "dirty", "elite", "fence", "its", "check", "feel", "press", "sing", "turn", "warm", "serve", "fee", "plate", "inner", "wound", "nut", "odd", "vote", "dear", "alive", "shock", "urge", "steel", "room", "sky", "fire", "cycle", "yard", "climb", "entry", "honey", "thick", "band", "high", "awful", "sun", "mode", "page", "ten", "bag", "blood", "cat", "knee", "flow", "speak", "far", "coat", "still", "noise", "sign", "size", "some", "shit", "fresh", "hair", "often", "avoid", "party", "film", "apart", "eat", "share", "wing", "juice", "lose", "same", "ready", "trick", "lie", "along", "seed", "act", "until", "ideal", "boom", "onto", "shade", "bar", "tired", "flag", "king", "wash", "not", "couch", "gift", "cool", "brain", "dance", "via", "even", "just", "grab", "mouse", "fair", "pipe", "rough", "mouth", "rush", "stair", "would", "extra", "eye", "fall", "cope", "glass", "lucky", "night", "club", "heel", "name", "soul", "rural", "long", "lots", "index", "stage", "game", "limit", "focus", "style", "lap", "pitch", "urban", "weak", "lab", "strip", "album", "corn", "lost", "below", "meat", "ball", "shirt", "burn", "maybe", "aware", "rule", "hear", "cite", "hire", "jury", "wheel", "man", "sharp", "wear", "where", "bit", "pride", "once", "bus", "goal", "again", "stake", "joint", "drink", "vast", "red", "usual", "bad", "era", "late", "wide", "food", "badly", "birth", "forth", "file", "sleep", "group", "bone", "clear", "money", "tip", "cop", "human", "while", "fund", "heavy", "truly", "none", "cause", "smell", "good", "guide", "rope", "bomb", "labor", "else", "myth", "start", "voter", "main", "chair", "fly", "see", "newly", "sigh", "land", "poet", "male", "sir", "cheek", "fate", "music", "many", "ugly", "vital", "proud", "sand", "sale", "why", "learn", "luck", "tail", "job", "mix", "smoke", "shut", "both", "those", "false", "army", "may", "ice", "faith", "total", "sad", "gene", "law", "worry", "bowl", "cloud", "legal", "craft", "tend", "dress", "pile", "sell", "brick", "fill", "fade", "actor", "kid", "east", "slow", "kind", "block", "cast", "beach", "dry", "naked", "movie", "all", "prior", "push", "wife", "hand", "base", "agent", "host", "shoot", "baby", "enter", "honor", "coast", "lemon", "minor", "pet", "smart", "bird", "sweep", "but", "idea", "relax", "event", "pray", "treat", "will", "yes", "used", "wet", "jail", "say", "gang", "down", "score", "touch", "join", "title", "trace", "lack", "metal", "mask", "south", "fix", "war", "basic", "ahead", "cake", "flesh", "hot", "diet", "tap", "media", "class", "hello", "vary", "stick", "left", "habit", "site", "frame", "hero", "stone", "rich", "child", "force", "more", "trend", "rid", "crop", "Mrs", "out", "shake", "owner", "rapid", "thus", "unit", "works", "given", "black", "give", "duty", "sea", "pack", "clue", "off", "speed", "sound", "two", "elect", "daily", "rise", "send", "slave", "trip", "clean", "here", "toe", "ring", "could", "wrap", "fish", "bear", "neck", "might", "most", "about", "voice", "apply", "DNA", "think", "girl", "key", "row", "suit", "alone", "tell", "fifth", "lead", "hate", "trial", "gaze", "quit", "blow", "iron", "being", "set", "wise", "cash", "stand", "lot", "state", "peak", "grass", "knife", "exist", "rub", "who", "field", "allow", "prove", "tale", "big", "depth", "soft", "river", "zone", "CEO", "month", "upper", "chef", "Bible", "tree", "stuff", "flat", "floor", "they", "asset", "yield", "onion", "real", "worth", "claim", "gold", "watch", "firm", "gear", "stock", "heat", "flame", "piano", "cell", "cable", "day", "cost", "dream", "ever", "least", "error", "range", "water", "lower", "map", "odds", "adapt", "math", "mad", "fine", "self", "marry", "you", "copy", "hell", "nice", "taste", "among", "point", "star", "yours", "tank", "egg", "free", "port", "work", "award", "horse", "keep", "tooth", "wind", "year", "bring", "load", "funny", "open", "shout", "the", "paper", "order", "abuse", "admit", "blade", "milk", "buy", "argue", "soil", "sugar", "sense", "tire", "super", "few", "any", "come", "woman", "giant", "crime", "poll", "rely", "lip", "image", "risk", "ban", "label", "park", "six", "ski", "user", "happy", "knock", "best", "angle", "hall", "swear", "offer", "skill", "want", "drive", "bond", "drag", "next", "eager", "leg", "then", "death", "grain", "bury", "spend", "swing", "buyer", "plane", "role", "slide", "joke", "study", "chain", "car", "her", "yet", "hill", "pink", "joy", "into", "pop", "drug", "hide", "palm", "bike", "city", "sin", "chief", "fiber", "lawn", "what", "born", "side", "seek", "house", "cream", "pound", "AIDS", "pool", "form", "pick", "trail", "troop", "color", "link", "stay", "roof", "debt", "every", "shape", "old", "tight", "loss", "fit", "run", "under", "them", "boat", "bite", "nose", "sit", "pain", "world", "track", "rail", "tone", "mere", "terms", "know", "bed", "doubt", "folk", "root", "slice", "sort", "age", "mine", "per", "step", "rifle", "after", "write", "way", "case", "walk", "cross", "judge", "layer", "bake", "love", "tribe", "pot", "scope", "show", "eight", "raw", "much", "skin", "virus", "save", "feed", "split", "call", "this", "near", "piece", "race", "that", "anger", "mess", "light", "yell", "post", "huge", "shell", "thin", "brush", "ago", "safe", "dozen", "live", "poor", "plant", "dirt", "find", "nine", "drama", "read", "print", "leave", "mail", "hour", "humor", "tear", "lean", "soup", "spin", "cold", "west", "fast", "Latin", "kiss", "need", "place", "nor", "mayor", "mass", "dog", "each", "take", "begin", "easy", "hope", "mood", "tie", "die", "word", "bill", "quick", "lung", "count", "peace", "route", "visit", "blue", "chest", "never", "jump", "scene", "ride", "peer", "rice", "sheet", "sure", "tea", "tower", "dead", "wave", "deer", "pour", "tour", "warn", "small", "help", "fewer", "plus", "view", "mall", "solid", "time", "card", "whole", "life", "lover", "enjoy", "chip", "pan", "pie", "sport", "week", "model", "wild", "face", "brief", "other", "right", "story", "seat", "guess", "chart", "news", "hotel", "phase", "acid", "play", "first", "sex", "moon", "seize", "ship", "poem", "hey", "fully", "loud", "wire", "aim", "song", "glad", "cow", "deck", "item", "date", "text", "photo", "add", "shine", "bean", "cabin", "three", "make", "rest", "owe", "with", "rank", "crew", "chase", "sales", "hit", "fail", "last", "mind", "shelf", "care", "react", "salt", "sick", "end", "cook", "court", "crack", "desk", "bread", "fault", "motor", "wish", "door", "occur", "due", "God", "new", "tube", "thing", "their", "only", "task", "his", "top", "five", "pair", "teach", "Iraqi", "fact", "tax", "coach", "cover", "fruit", "use", "adopt", "hip", "head", "basis", "storm", "leaf", "team", "dare", "throw", "apple", "jet", "toy", "wage", "porch", "cut", "pale", "bell", "term", "guard", "today", "topic", "above", "brand", "hard", "our", "have", "one", "mount", "adult", "pole", "radio", "shore", "pause", "low", "deal", "put", "blame", "lunch", "part", "phone", "uncle", "stare", "how", "fuel", "sake", "these", "whose", "favor", "young", "wall", "armed", "must", "golf", "sue", "pace", "thank", "crazy", "for", "lady", "tape", "proof", "get", "data", "very", "full", "roll", "crash", "angry", "fear", "civil", "draw", "empty", "blind", "novel", "pose", "quote", "space", "rock", "tall", "also", "shot", "gay", "lay", "than", "shrug", "local", "essay", "wrong", "since", "tough", "float", "over", "great", "home", "grave", "pine", "art", "third", "true", "area", "kick", "rare", "she", "wake", "sweet", "yeah", "not", "etc", "cry", "fat", "staff", "catch", "crowd", "beer", "ocean", "panel", "your", "look", "shoe", "price", "draft", "core", "heart", "son", "snap", "spot", "try", "stir", "buck", "grant", "issue", "gate", "line", "code", "refer", "laugh", "rose", "prime", "major", "trust", "book", "power", "Arab", "theme", "lock", "now", "truth", "let", "hat", "sorry", "wood", "alter", "gas", "hurt", "plan", "dig", "quiet", "body", "oil", "enemy", "path", "ratio", "which", "short", "stop", "seven", "kill", "from", "slip", "quite", "tent", "pant", "break", "own", "camp", "moral", "twin", "carry", "earn", "guy", "back", "white", "whom", "toss", "ally", "okay", "bunch", "pay", "gain", "move", "meet", "seem", "town", "list", "agree", "union", "upon", "when", "hold", "boot", "mean", "weigh", "meal", "miss", "exact", "sight", "tiny", "past", "tool", "scale", "smile", "steal", "truck", "deny", "four", "pass", "waste", "table", "youth", "raise", "shift", "dark", "mom", "nerve", "half", "edge", "pilot", "teen", "fight", "grow", "north", "bend", "patch", "soon", "early", "train", "level", "store", "pull", "test", "reply", "earth", "bench", "close", "nurse", "lake", "solar", "dad", "type", "dust", "guest", "match", "round", "net", "aid", "found", "cap", "like", "drop", "can", "note", "oven", "bank", "later", "wine", "ease", "away", "grand", "him", "too", "trade", "air", "video", "aide", "able", "deep", "large", "arise", "ear", "mark", "build", "boss", "holy", "shop", "and", "Irish", "rate", "grade", "meter", "broad", "beat", "fifty", "Jew", "loose", "nod", "swim", "bind", "busy", "clock", "such", "lift", "wipe", "well", "loan", "sauce", "sink", "auto", "belt", "imply", "final", "flee", "hole", "pure", "road", "fan", "box", "salad", "plot", "snow", "equal", "cup", "fun", "reach"};
    int Score=0,Lives=2,difficultty;
    Button next;
    ImageView l1,l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        l1=(ImageView)findViewById(R.id.live1);
        l2=(ImageView)findViewById(R.id.live2);
        score = (TextView)findViewById(R.id.textView4);
        next = (Button)findViewById(R.id.button6);
        topp = (TextView)findViewById(R.id.topper);
        shuffled = (TextView)findViewById(R.id.word_shuffled);
        guessed = (EditText)findViewById(R.id.answer_finder);
        r = new Random();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("difficulty");
            switch (value) {
                case "1":
                    topp.setText("Easy Mode - Jumbling"+" ");
                    difficultty=1;
                    easier();

                    break;
                case "2":
                    topp.setText("Normal Mode - Jumbling"+" ");
                    difficultty=2;
                    normal();
                    break;
                case "3":
                    topp.setText("Difficult Mode - Jumbling"+" ");
                    difficultty=3;
                    difficult();
                    break;
            }
        }


    }

    private void normal() {
        currentWord = med[r.nextInt(med.length)];
        shuffleit=shuffleWord(currentWord);
        if (shuffleit.equals(currentWord)){
            shuffleit=shuffleWord(currentWord);
        }
        shuffled.setText(shuffleit);
        Log.d(currentWord,"word");
        checkans(currentWord,2);
    }

    private void easier() {
        currentWord = easy[r.nextInt(easy.length)];
        shuffleit=shuffleWord(currentWord);
        if (shuffleit.equals(currentWord)){
            shuffleit=shuffleWord(currentWord);
        }
        shuffled.setText(shuffleit);
        Log.d(currentWord,"word");
        checkans(currentWord,1);
    }
    private void difficult(){
        currentWord = diffi[r.nextInt(diffi.length)];
        shuffleit=shuffleWord(currentWord);
        if (shuffleit.equals(currentWord)){
            shuffleit=shuffleWord(currentWord);
        }
        shuffled.setText(shuffleit);
        Log.d(currentWord,"word");
        checkans(currentWord,3);
    }
    private void checkans(final String crctans, final int difficulty){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Lives>0){
                    if (guessed.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(),"Please Enter your Anser in the Textbox",Toast.LENGTH_SHORT).show();
                    }
                    else if(guessed.getText().toString().equalsIgnoreCase(crctans)){
                        Toast.makeText(getApplicationContext(),"You are Awesome!!",Toast.LENGTH_SHORT).show();
                        if (difficulty == 1){
                            Score = Score+10;
                            score.setText(Score+" ");
                            guessed.setText("");
                            easier();
                        }
                        else if (difficulty == 2){
                            Score = Score+20;
                            score.setText(Score+" ");
                            guessed.setText("");
                            normal();
                        }else if (difficulty == 3){
                            Score = Score+30;
                            score.setText(Score+" ");
                            guessed.setText("");
                            difficult();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Oh..That is incorrect.",Toast.LENGTH_SHORT).show();
                        Lives = Lives -1;
                        guessed.setText("");
                        if(Lives==1){
                            l2.setImageResource(R.drawable.ic_like_none);
                        }
                        if (Lives<=0){
                            l1.setImageResource(R.drawable.ic_like_none);
                            Toast.makeText(getApplicationContext(),"Well sorry but you lost",Toast.LENGTH_SHORT).show();
                            //still need to create a score board
                            //lives image has to be changes
                            //if lives are over it should be able to start the game
                            next.setVisibility(View.INVISIBLE);
                            scoreboard(Score);
                        }
                    }
                }
                else{

                    restart(difficulty);

                }
            }
        });

    }

    private void restart(int difficulty) {
        next.setText("Next");
        l1.setImageResource(R.drawable.ic_like);
        l2.setImageResource(R.drawable.ic_like);
        Lives=2;
        Score=0;
        score.setText(Score+" ");
        guessed.setText("");
        next.setVisibility(View.VISIBLE);
        if (difficulty ==1){
            easier();
        }
        else if(difficulty==2){
            normal();
        }
        else if (difficulty==3){
            difficult();
        }
    }

    @Override
    public void onBackPressed() {

        quitbefrcnfrm();
    }
    private String shuffleWord(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for(String letter : letters){
            shuffled += letter;
        }
        return  shuffled;
    }

    public void quitt(View view) {
        quitbefrcnfrm();
        /*Intent i = new Intent(Play.this, MainActivity.class);
        startActivity(i);*/
    }

    /*private void newGame(){
        currentWord = dictionary[r.nextInt(dictionary.length)];
        tv_word.setText(shuffleWord(currentWord));
        et_guess.setText("");
        b_new.setEnabled(false);
        b_check.setEnabled(true);
    }*/
    private void quitbefrcnfrm(){
        final Dialog dialog = new Dialog(Play.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Play.this, MainActivity.class);
                startActivity(i);
                dialog.cancel();
            }
        });
        Button dialogButton1 = (Button) dialog.findViewById(R.id.no_dialog);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }


    public void scoreboard(int s){
        final String send = "Your Score is: " + s;
        final Dialog dialog = new Dialog(Play.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.score_board);
        TextView scr = (TextView)dialog.findViewById(R.id.score_brd);
        scr.setText(send);
        Button rstrt = (Button) dialog.findViewById(R.id.restart);
        rstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart(difficultty);
                dialog.cancel();
            }
        });
        dialog.show();

    }
}
