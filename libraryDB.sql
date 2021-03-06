﻿create database Kindle_U
go
use Kindle_U
go 
--drop database Kindle_U
-------------------管理员-----------------------------
create table manager(
ManagerID char(10) primary key  not null,
ManagerName char(10) not null,
ManagerMobile char(11) not null,
ManagerPassword char(30) not null,
ManagerPost char(10) null
)
go

insert into manager values 
(10086,'张全',17854238888,'zhangquan','馆长'),
(10010,'王铁',17854266666,'wangtie','管理员'),
(10000,'西门子',17854299999,'ximenzi','管理员')
go

select * from manager
go
-------------------读者--------------------------------
create table readers(
ReadID char(12) primary key not null,
ReadName char(10) not null,
ReadAddress char(20),
ReadMobile char(11),
ReadBalance int ,
ReadPassword char(20),
Portrait char(30)
)
go
insert into readers values 
('20114070001','李白','青岛大学泓园6号楼',17854200001,5,123,'portrait/李白.jpg'),
('20114070002','妲己','青岛大学泓园7号楼',17854200002,100,321,'portrait/妲己.jpg'),
('20114070003','貂蝉','青岛大学泓园5号楼',17854200003,200,1234,'portrait/貂蝉.jpg'),
('20114070004','吕布','青岛大学泓园6号楼',17854200004,300,12345,'portrait/吕布.jpg'),
('20114070005','韩信','中国海洋大学一栋',17854200005,50,123,'portrait/韩信.jpg'),
('20114070006','孙尚香','中国海洋大学二栋',17854200006,100,1234,'portrait/孙尚香.jpg'),
('20114070007','赵云','中国海洋大学一栋',17854200007,50,321,'portrait/赵云.jpg'),
('20114070008','荆轲','中国海洋大学二栋',17854200008,200,123456,'portrait/荆轲.jpg'),
('20114070009','高渐离','中国海洋大学三栋',17854200009,300,178,'portrait/高渐离.jpg'),
('20114070010','嬴政','青岛大学汇园2号楼',17854200010,500,1785,'portrait/嬴政.jpg'),
('20114070011','露娜','青岛大学泓园5号楼',17854200011,150,1234,'portrait/露娜.jpg'),
('20114070012','安琪拉','中国海洋大学二栋',17854200012,150,12356,'portrait/安琪拉.jpg'),
('20114070013','王昭君','青岛大学汇园一号楼',17854200013,500,17854,'portrait/王昭君.jpg'),
('20114070014','甄姬','青岛大学泓园7号楼',17854200014,50,187,'portrait/甄姬.jpg'),
('20114070015','武则天','中国海洋大学二栋',17854200015,450,1258,'portrait/武则天.jpg'),
('20114070016','花木兰','青岛科技大学崂山校区',17854200016,150,1234,'portrait/花木兰.jpg'),
('20114070017','蔡文姬','青岛科技大学四方校区',17854200017,200,123,'portrait/蔡文姬.jpg'),
('20114070018','不知火舞','青岛大学崂山校区',17854200018,100,218,'portrait/不知火舞.jpg'),
('20114070019','娜可露露','青岛大学崂山校区',17854200019,150,542,'portrait/娜可露露.jpg'),
('20114070020','橘右京','青岛大学崂山校区',17854200020,150,1236,'portrait/橘右京.jpg')

go
--drop table readers
select* from readers
go 
----------------------图书信息-------------------------------
create table books
(
BookID char(6) primary key not null,
BookName  char(30) not null,
WriterName char(30) not null,
PublishDate date not null,
Press char(30) not null,
Country char(10) not null,
Category char(10) not null,
PictureUrl char(40) not null,
PictureUrl_Big char(40) not null,
BookDescription nvarchar(300) not null,
BookStaus char(10)
)
go
alter table books
	add constraint DF_books_book default('在库')for BookStaus
go
insert into books values
('B001','明朝那些事儿（壹）', '当年明月', '2006-9-2' ,'中国友谊出版公司','中国' ,'历史','images/明朝那些事儿（壹）.jpg','images/明朝那些事儿（壹）_1.jpg','从朱元璋的出身开始写起，到永乐大帝夺位的靖难之役结束为止。叙述了明朝最艰苦卓绝的开国过程。朱元璋pk陈友谅，谁堪问鼎天下？战太平、太湖大决战。卧榻之侧埋恶虎，铲除张士诚。徐达、常遇春等不世名将乘胜逐北破北元。更有明朝最大的谜团——永乐夺位、建文失踪的靖难之役。',default),
('B002','十二幅地图中的世界史','杰里·布罗顿','2016-8-2','后浪出版公司','美国','历史','images/十二幅地图中的世界史.jpg','images/十二幅地图中的世界史_1.jpg','地图专家、《十二幅地图中的世界史》作者杰里·布罗顿（Jerry Brotton）教授向我们揭示地图的奥秘——地图是如何制成的？制图方法如何发展？地图又为我们带来了什么？地图不仅仅是帮助我们从甲地到乙地的工具，更是伟大历史时刻的缩影，是政治权力的强大手段。地图可以给人们美好的愿景，却又可以是极具毁灭性的政治势力的工具，能引起偏见，使世界扭曲变形。',default),
('B003','漫长的中场休息','本.方登','2016-11-1','南海出版公司','外国','文学','images/漫长的中场休息.jpg','images/漫长的中场休息_1.jpg','比利•林恩所在的B班士兵，在伊拉克赢得了一场3分43秒的短暂胜利。一夜间，他们成了美国的英雄。<br/>每个人都说着“感谢你们”，记者、好莱坞导演蜂拥而至。他们甚至还被邀请参加超级碗的中场秀。绚丽的烟花在耳边炸响，伴舞身上的亮片在身畔旋转，战争仿佛无比遥远。但有那么一刹那，比利觉得还是打仗好，总比被人当舞台布景挪来挪去爽多了。老天作证，打仗确实烂透了，可他实在看不出这种无聊的和平生活又有什么好的。这一天，比利•林恩遭遇了人生中最大的挑战。','借出'),
('B004','京料理','千澄子','2016-10-1','新星出版社','日本','美食','images/京料理.jpg','images/京料理_1.jpg','料理，就是“料想”并“合乎”食物之道理。而只有用京都的菜、京都的水烹饪出的料理，才能叫做“京料理”。四季流转，尊重自然的京都人应季而烹、应季而食。春天的味道犹如嫩芽萌发般细腻，竹笋的鲜甜激荡在舌尖；夏天的蔬果和鱼虾吸足了雨水，充满大地的力量；硕果累累的秋天浓缩万物精华，松茸和日本柚子的清香耐人回味；冬天的美味有如佳酿，娇嫩的笔头菜又满含人们对春回大地的期待。代代传承的京都味道，都蕴蓄着古老的历史与传统，亦饱含着京都人享受四季的心境与况味。',default),
('B005','人人都有妄想症','弗兰·克劳斯','2016-10-8','中信出版社','美国','心理学','images/人人都有妄想症.jpg','images/人人都有妄想症_1.jpg','这部漫画收集了101个古怪的妄想。作者弗兰·克劳斯一开始只是将自己担心的那些不可理喻的奇怪想法画成漫画发布在网络上，引起众多网友关注。越来越多的网友看到以后，开始把自己内心深处荒唐又羞于告人的妄想发给作者，于是有了这一本有趣的《人人都有妄想症》。在100余幅作品中，每幅作品都描述了一种每个人都曾有过的，幻想出来的有趣又带点荒谬的画面，“睡觉的时候，我总是小心摆放自己的胳膊和腿，不让他们伸出床外。我担心上面会有一个断头台，等着我好奇心泛滥的那一刻”。“我使劲地跑，终于赶上了那趟列车。可是一上车我就开始担心，我本不应该赶上，这趟车下一站就会撞毁”。','借出'),
('B006','皮囊','蔡崇达','2014-12-1','天津人民出版社','中国','文学','images/皮囊.jpg','images/皮囊_1.jpg','一部有着小说阅读质感的散文集，也是一本“认心又认人”的书。作者蔡崇达，本着对故乡亲人的情感，用一种客观、细致、冷静的方式，讲述了一系列刻在骨肉间故事。一个福建渔业小镇上的风土人情和时代变迁，在这些温情而又残酷的故事中一一体现。用《皮囊》这个具有指向本质意味的书名，来 表达作者对父母、家乡而原本友好的同学也开始以欺负正雄为乐。正雄默默忍受着这一切，直到有一天，一个从未见过的绿脸男孩出现在他眼前……',default),
('B013','解忧杂货店','东野圭吾','2014-5-10','南海出版公司','日本','推理','images/解忧杂货店.jpg','images/解忧杂货店_1.jpg','现代人内心流失的东西，这家杂货店能帮你找回——>僻静的街道旁有一家杂货店，只要写下烦恼投进卷帘门的投信口，第二天就会在店后的牛奶箱里得到回答。因男友身患绝症，年轻女孩静子在爱情与梦想间徘徊；克郎为了音乐梦想离家漂泊，却在现实中寸步难行；少年浩介面临家庭巨变，挣扎在亲情与未来的迷茫中……他们将困惑写成信投进杂货店，随即奇妙的事情竟不断发生。',default),
('B014','三体Ⅱ','刘慈欣','2008-5-16','人民文学出版社','中国','科幻','images/三体Ⅱ.jpg','images/三体Ⅱ_1.jpg','三体人在利用魔法般的科技锁死了地球人的科学之后，庞大的宇宙舰队杀气腾腾地直扑太阳系，意欲清除地球文明。面对前所未有的危局，经历过无数磨难的地球人组建起同样庞大的太空舰队，同时，利用三体人思维透明的致命缺陷，制订了神秘莫测的“面壁计划”，精选出四位“面壁者”。秘密展开对三体人的反击。三体人自身虽然无法识破人类的诡谲计谋，却依靠由地球人中的背叛者挑选出的“破壁人”，与“面壁者”展开智慧博弈……',default),
('B015','三体','刘慈欣','2006-1-14','人民文学出版社','中国','科幻','images/三体.jpg','images/三体_1.jpg','文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……',default),
('B016','史蒂夫·乔布斯传','沃尔特·艾萨克森','2011-10-24','中国友谊出版公司','美国','传记','images/史蒂夫·乔布斯传.jpg','images/史蒂夫·乔布斯传_1.jpg','这本乔布斯唯一授权的官方传记，在2011年上半年由美国出版商西蒙舒斯特对外发布出版消息以来，备受全球媒体和业界瞩目，这本书的全球出版日期最终确定为2011年11月21日，简体中文版也将同步上市。两年多的时间，与乔布斯40多次的面对面倾谈，以及与乔布斯一百多个家庭成员、 朋友、的缅怀，对朋友命运的关切，同时也回答那些我们始终要回答的问题。',default),
('B007','茧','张悦然','2016-8-1','人民文学出版社','中国','文学','images/茧.jpg','images/茧_1.jpg','两个生于八十年代的年轻人，遭受着缺失父辈之爱的痛苦。他们追寻上一代的足迹，循着线索不断走向秘密的核心，最终发现了一个庞大而不堪的真相。1967年雨夜，废弃的德军建造的水塔内究竟发生了什么？一根铁钉如何造就了两个家族截然不同的命运？荣耀的背后又隐藏着怎样的悲剧？一个是受人敬仰的院士，一个是意识全无的植物人。两人的交缠，渗透在儿孙背后的绵长岁月中，使他们永远活在爱与罪的阴影里……',default),
('B008','我是猫','夏目漱石','2015-6-4','浙江文艺出版社','日本','文学','images/我是猫.jpg','images/我是猫_1.jpg','《我是猫》是日本“国民大师”夏目漱石的代表成名作，对日本文学有着极深远的影响。《我是猫》的写作角度很新颖，从一只猫的视角来观察身边的人和事。这只猫生活在一个教师家中，见识了形形色色各种文人：没心没肺无厘头，唯恐天下不乱的迷亭；古板又一丝不苟，有点不知变通的寒月；理想主义，空有理论不实践的独仙……','借出'),
('B009','万物静默如谜','维斯拉瓦?辛波斯卡','2012-8-3','中国友谊出版公司','波兰','诗歌','images/万物静默如谜.jpg','images/万物静默如谜_1.jpg','《辛波斯卡诗选：万物静默如谜》收录辛波斯卡各阶段名作75首，包括激发知名绘本作家幾米创作出《向左走，向右走》的《一见钟情》，收录高中语文教材的《底片》，网上广为流传的《在一颗小星星下》《种种可能》等，曾获得《洛杉矶时报》年度最佳图书。','借出'),
('B010','哥儿','夏目漱石','1987-4-29','浙江文艺出版社','日本','文学','images/哥儿.jpg','images/哥儿_1.jpg','夏目漱石是日本现代文学的重要奠基人之一。本书收录的《哥儿》与《心》都是作者以特有的东方情调和西方现代创作手法创作的不朽名篇。作者以细腻的壁橱，或激越或诙谐，批判社会现实抑或人性深处的丑恶。《哥儿》中所创造的艺术形象集中反映了日本国民性中明朗的一面，成为日本文学史册上永久可爱的形象。在《心》中生动细密的心理描写，则韵味深厚，深刻刺目，回味无穷。',default),
('B011','在黑暗中等待','乙一','2014-7-9','广西师范大学出版社','日本','推理','images/在黑暗中等待.jpg','images/在黑暗中等待_1.jpg','阿滿失去了視力，一個人靜靜地過日子；而明宏則為工作職場人際關係所惱。車站月台所發生的殺人事件將兩個寂寞的人兜在一起。被當成犯人追捕的明宏逃進阿滿的家，蜷縮在起居室的角落。感受有外人存在的氣息而心生膽怯的阿滿為了自保，決定裝作不知情。於是兩人就此展開了一段奇妙的同居生活──',default),
('B012','濒死之绿','乙一','2014-7-7','广西师范大学出版社','日本','悬疑','images/濒死之绿.jpg','images/濒死之绿_1.jpg','此时，他是冷酷暗黑系的“黑乙一”，释放着看似弱小无援者的暴力意识到有一个比自己更差劲的人存在，是这个世界顺利运转的秘密法则新来的班主任羽田老师，风趣外向极受同学欢迎。为了维护自己在学生心目中的形象，他选中懦弱的正雄作为班级负面情绪的发泄口，争对手、同事的不受限的采访，造就了这本独家传记。',default),
('B017','鱼羊野史·第6卷','高晓松','2016-6-10','后浪出版公司','中国','历史','images/鱼羊野史·第6卷.jpg','images/鱼羊野史·第6卷_1.jpg','人类，有的时候聪明，有的时候傻，但始终在进化。历史不是镜子，历史是开了又落的花，朝花夕拾跟高晓松一起，重温故国、故城、故人芳华刹那作为一名文艺青年，宋徽宗如何来治国？对于肯尼迪总统被刺这一谜案，晓松有哪些猜想呢？清洁工为什么会将纽约时代艺术博物馆里的藏品误当垃圾清理走？晓松差点儿成为中央空调和插卡电表的发明推广者，作为科学家的外公为何要制止？',default),
('B018','如丧','高晓松','2012-4-9','后浪出版公司','中国','随笔','images/如丧.jpg','images/如丧_1.jpg','第一部分小说：以高晓松成长的青春时代为背景，展现高晓松、老狼、郑钧等一代人的文艺青春及属于那个年代的特殊氛围第二部分电影故事：全面收录了高晓松多年来创作的电影剧本原型故事第三部分杂文：随笔散文，前后时间跨度颇大，记录成长、变老是件琐屑的事第四部分媒体专访：收录高晓松最袒露心声的两篇专访随书附赠精心收录的高晓松歌词创作作品29首',default),
('B019','睡在我上铺的兄弟','高晓松','2016-3-10','后浪出版公司','中国','青春','images/睡在我上铺的兄弟.jpg','images/睡在我上铺的兄弟_1.jpg','我只是用最为真实的故事讲述了当年最为真实的我们，也是最为真实的你们。和兄弟有关的故事尚未讲完，和青春有关的岁月仍在上演。让我们用理想，写下永不服输，让我们为我们的青春欢呼！',default),
('B020','哈佛极简中国','史阿尔伯特·克雷格','2016-11-19','中信出版社','美国','历史','images/哈佛极简中国.jpg','images/哈佛极简中国_1.jpg','汉学巨擘写给普通读者的中国史入门读物，哈佛燕京学社社长、东亚史大家阿尔伯特•克雷格毕生研究淬炼而成的经典力作。以全球史的视野、大历史的格局，突破传统中国史学叙事，280 页图文并茂，重新认识中华五千年文明的兴衰荣辱。《哈佛中国史》经典导读，“极简阅读”畅销读物。',default),
('B021','活着为了讲述','加西亚·马尔克斯','2016-4-9','天津人民出版社','哥伦比亚','传记','images/活着为了讲述.jpg','images/活着为了讲述_1.jpg','加西亚•马尔克斯1927年出生于哥伦比亚马格达莱纳海滨小镇阿拉卡塔卡。童年与外祖父母一起生活。    1936年随父母迁居苏克雷。1947年考入波哥大国立大学。1948年进入报界。五十年代开始出版文学作品。1967年《百年孤独》问世。1982年获诺贝尔文学奖。2002年出版自传《活着为了讲述》。2014年4月17日于墨西哥病逝。',default),
('B022','新日之书（全4册）','吉恩·沃尔夫','2014-10-7','中信出版社','美国','科幻','images/新日之书（全4册）.jpg','images/新日之书（全4册）_1.jpg','数百万年后的未来，太阳中心出现了一个不断吞噬能量的黑洞，人类的摇篮“兀司”（即地球）已成为一潭被遗忘的死水。由于日光渐暗、能源枯竭，文明全面衰退，人类重回蒙昧时代。故事发生在南美大陆上最繁华的城市涅索斯，主角塞万里安是一个出身卑贱的拷刑吏学徒。出于青春期的热血和冲动，他救下了叛军首领沃达勒斯，后又因触犯会规而遭流放。',default),
('B023','万物：创世','延斯·哈德','2015-4-26','南海出版公司','德国','漫画','images/万物：创世.jpg','images/万物：创世_1.jpg','一部来自人类智识又挑战人类智识上限的野心之作<br/>“漫画宇宙史”三部曲震撼开篇之作2000多幅手绘漫画诠释140亿年宇宙进化史···',default),
('B024','霍乱时期的爱情','加西亚·马尔克斯','2012-9-1','天津人民出版社','哥伦比亚','文学','images/霍乱时期的爱情.jpg','images/霍乱时期的爱情_1.jpg','《霍乱时期的爱情》是加西亚•马尔克斯获得诺贝尔文学奖之后完成的第一部小说。讲述了一段跨越半个多世纪的爱情史诗，穷尽了所有爱情的可能性：忠贞的、隐秘的、粗暴的、羞怯的、柏拉图式的、放荡的、转瞬即逝的、生死相依的……再现了时光的无情流逝，被誉为“人类有史以来最伟大的爱情小说”，是20世纪最重要的经典文学巨著之一。',default),
('B025','泛若不系之舟','傅真','2014-8-6','中信出版社','中国','旅行','images/泛若不系之舟.jpg','images/泛若不系之舟_1.jpg','在《泛若不系之舟》里，傅真与毛铭基行走于印度、泰国、缅甸、老挝等亚洲国家，最后回到二人初见的拉萨。这本书的文字跟随他们颠沛流离，在记事本、电脑、夜车、小旅馆和咖啡店中辗转漂泊，诚实地记录着他们一路的见闻故事，探索着信仰、精神与内心价值，也见证着普通小人物身上顽强的生存本领。无论生活多么沉重、艰辛或不公，他们奋力向前，笑着流泪，珍视情感，保有尊严。',default),
('B026','一定要画出来才好玩：伦敦','叶纸君','2016-9-1','浙江文艺出版社','中国','旅行','images/一定要画出来才好玩：伦敦.jpg','images/一定要画出来才好玩：伦敦_1.jpg','人们常说“如果你厌倦了伦敦，你就厌倦了生活”，这里有逛不完的博物馆和吃不完的各国美食，逛街从不担心没有去处，周末天气好去海德公园散步骑单车也非常惬意。来到了这个美得像电影一样的城市，这里的人善良可爱，在伦敦的日子好像是做了一个不真实的美梦。',default),
('B027','滚蛋吧!肿瘤君','熊顿','2012-9-1','广西师范大学出版社','中国','励志','images/滚蛋吧!肿瘤君.jpg','images/滚蛋吧!肿瘤君_1.jpg','滚蛋吧!肿瘤君:我与癌症斗争的一年里》由熊顿本人创作，以她治疗的过程和内心感触为素材，讲述了一个癌症患者笑对生活的感人纪实。在睁眼就是治疗室，入耳就是化疗、吃药、体温、白细胞增减的环境里，她乐观的记录了自己的每一段经历，用画笔细心捕捉了来自父母、亲人、朋友的关怀和生活中的点滴感动。',default),
('B028','无人生还','阿加莎·克里斯蒂','2016-10-9','后浪出版公司','英国','推理','images/无人生还.jpg','images/无人生还_1.jpg','十个相互陌生、身份各异的人受邀前往德文郡海岸边一座孤岛上的豪宅。客人到齐后，主人却没有出现。当晚，一个神秘的声音发出指控，分别说出每个人心中罪恶的秘密。接着，一位客人离奇死亡。暴风雨让小岛与世隔绝，《十个小士兵》——这首古老的童谣成了死亡咒语。如同歌谣中所预言的，客人一个接一个死去……杀人游戏结束后，竟无一人生还！','借出'),
('B029','许三观卖血记','余华','1998-9-1','南海出版公司','中国','文学','images/许三观卖血记.jpg','images/许三观卖血记_1.jpg','《许三观卖血记》是余华1995年创作的一部长篇小说，它以博大的温情描绘了磨难中的人生，以激烈的故事形式表达了人在面对厄运时求生的欲望。小说讲述了许三观靠着卖血渡过了人生的一个个难关，战胜了命运强加给他的惊涛骇浪，而当他老了，知道自己的血再也没有人要时，精神却崩溃了。',default),
('B030','质数的孤独','保罗·乔尔达诺','2011-3-20','广西师范大学出版社','意大利','文学','images/质数的孤独.jpg','images/质数的孤独_1.jpg','《质数的孤独》是意大利八〇后作家、粒子物理学博士保罗·乔尔达诺的处女作，2008年出版后，即获得意大利最高文学奖斯特雷加奖，并迅速成为欧美超级畅销书，迄今在欧洲销量已超过500万册。同名电影于今年9月在威尼斯电影节首映。',default)

go
--drop table books
select*from books
go

----------------------图书类别-------------------------------
create table BookCategory(
ID int identity(1,1) primary key,
BookID char(6) not null,
CategoryNo int ,
CategoryContent nvarchar(20)
)
insert into BookCategory values
('B001',1,'明朝那些事儿（壹）'),
('B001',2,'当年明月'),
('B001',3,'中国友谊出版公司'),
('B001',4,'中国'),
('B001',5,'历史'),
('B002',1,'十二幅地图中的世界史'),
('B002',2,'本.方登'),
('B002',3,'后浪出版公司'),
('B002',4,'美国'),
('B002',5,'历史'),
('B003',1,'漫长的中场休息'),
('B003',2,'本.方登'),
('B003',3,'南海出版公司'),
('B003',4,'外国'),
('B003',5,'文学'),
('B004',1,'京料理'),
('B004',2,'千澄子'),
('B004',3,'新星出版社'),
('B004',4,'日本'),
('B004',5,'美食'),
('B005',1,'人人都有妄想症'),
('B005',2,'弗兰·克劳斯'),
('B005',3,'中信出版社'),
('B005',4,'美国'),
('B005',5,'心理学'),
('B006',1,'皮囊'),
('B006',2,'蔡崇达'),
('B006',3,'天津人民出版社'),
('B006',4,'中国'),
('B006',5,'文学'),
('B007',1,'茧'),
('B007',2,'张悦然'),
('B007',3,'人民文学出版社'),
('B007',4,'中国'),
('B007',5,'文学'),
('B008',1,'我是猫'),
('B008',2,'夏目漱石'),
('B008',3,'浙江文艺出版社'),
('B008',4,'日本'),
('B008',5,'文学'),
('B009',1,'万物静默如谜'),
('B009',2,'维斯拉瓦?辛波斯卡'),
('B009',3,'中国友谊出版公司'),
('B009',4,'波兰'),
('B009',5,'诗歌'),
('B010',1,'哥儿'),
('B010',2,'夏目漱石'),
('B010',3,'浙江文艺出版社'),
('B010',4,'日本'),
('B010',5,'文学'),
('B011',1,'在黑暗中等待'),
('B011',2,'乙一'),
('B011',3,'广西师范大学出版社'),
('B011',4,'日本'),
('B011',5,'推理'),
('B012',1,'濒死之绿'),
('B012',2,'乙一'),
('B012',3,'广西师范大学出版社'),
('B012',4,'日本'),
('B012',5,'悬疑'),
('B013',1,'解忧杂货店'),
('B013',2,'东野圭吾'),
('B013',3,'南海出版公司'),
('B013',4,'日本'),
('B013',5,'推理'),
('B014',1,'三体Ⅱ'),
('B014',2,'刘慈欣'),
('B014',3,'人民文学出版社'),
('B014',4,'中国'),
('B014',5,'科幻'),
('B015',1,'三体'),
('B015',2,'刘慈欣'),
('B015',3,'人民文学出版社'),
('B015',4,'中国'),
('B015',5,'科幻'),
('B016',1,'史蒂夫·乔布斯传'),
('B016',2,'沃尔特·艾萨克森'),
('B016',3,'中国友谊出版公司'),
('B016',4,'美国'),
('B016',5,'传记'),
('B017',1,'鱼羊野史·第6卷'),
('B017',2,'高晓松'),
('B017',3,'后浪出版公司'),
('B017',4,'中国'),
('B017',5,'历史'),
('B018',1,'如丧'),
('B018',2,'高晓松'),
('B018',3,'后浪出版公司'),
('B018',4,'中国'),
('B018',5,'随笔'),
('B019',1,'睡在我上铺的兄弟'),
('B019',2,'高晓松'),
('B019',3,'后浪出版公司'),
('B019',4,'中国'),
('B019',5,'青春'),
('B020',1,'哈佛极简中国'),
('B020',2,'史阿尔伯特·克雷格'),
('B020',3,'中信出版社'),
('B020',4,'美国'),
('B020',5,'历史'),
('B021',1,'活着为了讲述'),
('B021',2,'加西亚·马尔克斯'),
('B021',3,'天津人民出版社'),
('B021',4,'哥伦比亚'),
('B021',5,'传记'),
('B022',1,'新日之书（全4册）'),
('B022',2,'吉恩·沃尔夫'),
('B022',3,'中信出版社'),
('B022',4,'美国'),
('B022',5,'科幻'),
('B023',1,'万物：创世'),
('B023',2,'延斯·哈德'),
('B023',3,'南海出版公司'),
('B023',4,'德国'),
('B023',5,'漫画'),
('B024',1,'霍乱时期的爱情'),
('B024',2,'加西亚·马尔克斯'),
('B024',3,'天津人民出版社'),
('B024',4,'哥伦比亚'),
('B024',5,'文学'),
('B025',1,'泛若不系之舟'),
('B025',2,'傅真'),
('B025',3,'中信出版社'),
('B025',4,'中国'),
('B025',5,'旅行'),
('B026',1,'一定要画出来才好玩：伦敦'),
('B026',2,'叶纸君'),
('B026',3,'浙江文艺出版社'),
('B026',4,'中国'),
('B026',5,'旅行'),
('B027',1,'滚蛋吧!肿瘤君'),
('B027',2,'熊顿'),
('B027',3,'广西师范大学出版社'),
('B027',4,'中国'),
('B027',5,'励志'),
('B028',1,'无人生还'),
('B028',2,'阿加莎·克里斯蒂'),
('B028',3,'后浪出版公司'),
('B028',4,'英国'),
('B028',5,'推理'),
('B029',1,'许三观卖血记'),
('B029',2,'余华'),
('B029',3,'南海出版公司'),
('B029',4,'中国'),
('B029',5,'文学'),
('B030',1,'质数的孤独'),
('B030',2,'保罗·乔尔达诺'),
('B030',3,'广西师范大学出版社'),
('B030',4,'意大利'),
('B030',5,'文学')

--drop table BookCategory
----------------------借阅信息-------------------------------

create table borrow(
ID int identity(1,1)  primary key ,
ReadID char(12),
BookID char(6),
BorrowDate char(20),
ReturnDate char(20)
)
alter table borrow
	add constraint DF_borrow_bo default('未还')for ReturnDate
go
insert into borrow values 
('20114070001','B003','2008-12-1',default),
('20114070001','B005','2008-12-1',default),
('20114070001','B009','2009-12-1',default),
('20114070001','B008','2015-1-1',default),
('20114070002','B004','2010-8-9',default),
('20114070007','B011','2009-8-3',default)
--drop table borrow
select*from borrow

----------------------评论关系-----------------------------------
create table comment(
ID int identity(1,1) primary key,
ReadID char(12),
BookID char(6),
ReadName char(10) not null,
BookName char(30) not null,
Caption nchar(20) not null,
Content nchar(200) not null,
CommentDate char(20),
Portrait char(30)
)
insert into comment values 
('20114070001','B003','李白','漫长的中场休息','如果战场更安全危险的是什么？','战争也是经济。而有人聚集的地方，也会成为战场。战后的大兵日常让我想起《Generation Kill》。而比利的冲撞式身心，又是一个每个人都是冲破名为自我的牢笼的越狱犯。 ','2016-11-2','portrait/李白.jpg'),
('20114070011','B003','露娜','漫长的中场休息','时代里的小人物 ','人能知道什么呢——过去是一片迷雾，吐出一个接一个的幽灵，将来是深不见底的黑洞，任何猜测都是徒劳的。','2011-3-3','portrait/露娜.jpg'),
('20114070005','B028','韩信','无人生还','道德的流放地万物萧条 ','这本书真的是一部不错的作品，前后呼应，在细节方面也处理的很好，那一首童谣更是增添了一些趣味性，是一本很值得一读的佳作。','2015-9-8','portrait/韩信.jpg'),
('20114070001','B028','李白','无人生还','一本小说对我的意义 ','《无人生还》不是一部完美的小说，但构思巧妙的故事、细腻的心理刻画和生动的场景描写都非常吸引我，周日晚上我本来想睡前随便翻一翻这本小说，没想到拿起来就一直读到两点钟，在寂静的深夜之中，有些段落还让我有毛骨悚然的感觉。','2008-10-8','portrait/李白.jpg'),
('20114070003','B028','貂蝉','无人生还','最后死去的不是凶手，而凶手确实在最后死去 ','最好看的一本悬疑推理小说，知道看到最后才知道真相，之前自己的各种揣测推测都都不对，曾经一度认为谜底应该是其中有一个人是精神分裂，但却不是这样，不多剧透。。。作者所揭晓的真相，逻辑还是挺严谨，能经得起推敲自圆其说，感觉应该被拍成电影！','2010-12-12','portrait/貂蝉.jpg'),
('20114070015','B028','武则天','无人生还','隐秘的欲望，迷人的犯罪 ','不过相比于柯南道尔，他的同胞兼同行阿加莎女士写起犯罪来更加地迷人而优雅。英国人那种古怪的性情在她的笔下转化为一种精细的变态。那些鲜血淋漓的故事在她讲来，沉稳而缓慢，带着英国的雾气，阴冷潮湿，慢慢地在你周围弥漫。
','2009-2-23','portrait/武则天.jpg'),
('20114070013','B008','王昭君','我是猫','激荡三十年后，静思 ','虽是猫眼看人，其实也不过安插寥寥几笔让人料知这猫的存在，更多的，是方寸之地几个所谓文人的交谈。聊得海阔天空，足见夏目漱石知识的渊博，但掉书袋的刻意，其实也恰好顺着主旨营造出某种迂腐无聊的氛围。以苦沙弥为首的知识分子，大多平凡、庸俗、聒噪，有些无聊，有些陈腐，但也确实是某一群人的特写吧。','2004-1-2','portrait/王昭君.jpg'),
('20114070020','B011','橘右京','在黑暗中等待','白乙一式的光明 ','人和人的相遇有时候真的很神奇。被怀疑为某杀人案件的犯人的男人擅自躲到失明女人的家里，然后发生的一系列故事。故事很平淡，没有太大波澜，连找出真凶的方法都很随意。但是看到最后会有治愈的感觉。','2014-3-12','portrait/橘右京.jpg'),
('20114070019','B002','娜可露露','十二幅地图中的世界史','你看到的世界不是真实的世界 ','在我看来，地图本身蕴含着普世性，从古至今，这种普适性在基督教的大公性、东亚的天下体系、大航海时代的世界观、民族国家的地缘政治和网络时代的开放信息社会。所以，我认为地图尽管各自不同，但还是有着一以贯之的东西的。','2015-1-24','portrait/娜可露露.jpg'),
('20114070018','B001','不知火舞','明朝那些事儿（壹）','成功者往往都有潜心努力的漫漫日子','把历史以讲故事的方式阐述，的确很有趣。唯一不太喜欢的是主观方面有点强势，让我这呆子容易混淆历史与故事。以至于这一部给人感觉主要讲了两点：帝王身上呈现的要么就是军事天才，要么就是残暴至极之徒。而后者让人印象更甚，痛感与厌感升级。唯一的美感只有在战争过程中体现。','2012-10-7','portrait/不知火舞.jpg'),
('20114070004','B015','吕布','三体','《三体》：当代史的科幻书写 ','三体是我看完几年后还难以忘怀的一部小说。这部小说中讲得一些情节也许刚开始看时会让人感到不那么舒服，但只要细细想来就会觉得其实这些情节是很有道理的。我是一个文科生，对书中描述的物理学等知识不是很了解。因而我更关注的是作者通过故事对社会人文、哲学方面的描绘。至今对黑暗森林理论记忆犹','2014-8-8','portrait/吕布.jpg')
select *from comment
--drop table comment


----------------------------作者信息--------------
create table author(
AuthorName char(16) primary key not null,
AuthorNationality char(6) not null,
BirthDate char(10) null,
AepresentativeBooks char(20) not null,
AuthorPhoto char(40) null,
AboutAuthor nvarchar(500) null

)
go
insert into author values
('当年明月','中国','1979','《明朝那些事儿》','','当年明月，本名石悦。1979年出生在宜昌一个普通干部家庭，曾经是广东顺德海关公务员，以《明朝那些事儿》成名于互联网。'),
('高晓松','中国','1969-11-14','《如丧》','','高晓松，1969年11月14日生于北京，祖籍浙江杭州。音乐人、词曲创作者、制作人、导演、脱口秀节目主持人。
1988年考入清华大学电子工程系，后退学进入北京电影学院导演系研究生预备班学习。早期事业以电视编剧、音乐创作及制作人为主。1994年出版《校园民谣》合辑，
1996年推出个人作品集《青春无悔》。1996年高晓松和宋柯创办了“麦田音乐”独立品牌，后发展成唱片公司太合麦田。1999年自编自导爱情电影《那时花开》。
2002年自编自导并作曲电影《我心飞翔》，该片获得法国里昂电影节最高奖和美国雪城电影节评委会奖。时常担任各大选秀比赛评委。
2011年9月9日自编自导电影《大武生》上映。2012年3月主持脱口秀栏目《晓说》开始播出。
2015年7月15日下午阿里巴巴集团宣布，成立阿里音乐集团，高晓松加盟阿里音乐，出任董事长  ')

go
select * from author
drop table author
go


