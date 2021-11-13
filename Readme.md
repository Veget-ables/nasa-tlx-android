# NASA-TLX for Android
Android端末によってNASA-TLXによる一連の評価を行う．またTLXの厳密な検証方法により，Nexus7のタブレット以上の画面サイズを有するデバイスを使用する必要がある．


## メンタルワークロード
ストレスを人間工学分野で取り扱う際の名称であり，作業に関わる精神的な要因の総称．同じレベルの精神的負荷を与えても人によって感じる精神的負担は異なる．近年，メンタルワークロードを評価した論文の数が増加している．


## NASA-TLX (National Aeronautics and Space Administration Task Load Index)
NASA-TLXはメンタルワークロードの評価手法で最も利用されている手法である．40以上の研究所の協力のもと，1969年に，NASAのエイムズ研究センターのHuman Performance Groupが開発した．  
近年，TLXの使用割合は急激に増加しており，2009-2012年の時点では評価手法の中でも約70％を占めている． 
TLXは表に示す6つの評価尺度（以下，下位尺度）による主観的評価をつけ，各評価尺度に対する重みづけを行い，その平均値を算出する．平均値は小さいほど良い結果となる．  

主観評価では通常，Likertスケールと呼ばれる何段階かの評定尺度法が用いられるが，TLXはVAS（Visual Analog Scale）により評定を行う．TLXはVASによる100点満点の評価により離散的な結果を得ることが特徴であり，目盛線を引かないことが推奨されている．  


|Item|Endpoints|Description|
|:---|:---|:---|
|精神的要求(MD:mental demand)|低い / 高い|どの程度，精神的かつ知覚的活動が要求されましたか？（例．思考，意志決定，計算，記憶，観察，検索，等）作業は容易でしたか，それとも困難でしたか．単純でしたか，それとも複雑でしたか．苛酷でしたか，それとも寛大でしたか．|
|身体的要求(PD:physical demand)|低い / 高い|どの程度，身体的活動が必要でしたか？（例．押す，引く，回す， 操作する等）作業は容易でしたか，それとも困難でしたか．ゆっくりしていましたか，それともきびきびしていましたか．ゆるやかでしたか，それとも努力を要するものでしたか．落ち着いたものでしたか，それとも骨の折れるものでしたか．|
|時間切迫感(TD: temporal demand)|低い / 高い|作業や要素作業の頻度や速さにどの程度，時間的圧迫感を感じましたか？作業ペースはゆっくりしていて暇でしたか，それとも急速で大変でしたか．|
|作業達成度(OP: own performance)|良い / 悪い|実験者（あるいは，あなた自身）によって設定された作業の達成目標の遂行について，どの程度成功したと思いますか？この目標達成における作業成績にどのくらい満足していますか？|
|努力(EF: effort)|低い / 高い|あなたの作業達成レベルに到達するのにどのくらい一生懸命（精神的および身体的に）作業を行わなければなりませんでしたか？|
|不満(FR: frustration level)|低い / 高い|作業中，どのくらい，不安，落胆，いらいら，ストレス，不快感，あるいは安心，喜び，満足，リラックス，自己満足を感じましたか？|


## WWL
TLXでは，一対比較を用いた重み付け係数による平均値WWL（Weighted Workload）を用いる．
WWLは6つの下位尺度の全てのペア15組について，ワークロードへの関わりが大きいと思う方を選択させ，各下位尺度の選択された回数（0-5）をその尺度の重み係数wiとする．各下位尺度の評定値をviとすると，WWLは以下の式で算出され1~100の値となる．分母の重み係数wiの総和はペアの数と同じ15である．  
一対比較は被験者ごとに作業後に行ってもらう．　

<div align="center">
<img src="https://latex.codecogs.com/gif.latex?WWL=\frac{\sum_{i-1}^{6}(wivi)}{\sum_{i-1}^{6}wi}"/> 
</div>

## アプリの利用方法
1. アプリを起動してNASA-TLXの評価を開始する
2. 評価終了のメッセージ表示後、結果はデバイス内の`data/data/com.slpl.nasa_tlx/files/RatingScale.csv`に保存される
   - すでにcsvファイルが存在する場合は、前回の結果の次の行から記録されていく
3. アプリを手動で終了する

実験協力者毎に1-3を繰り返す。
評価結果のcsvファイルはAndroidStudioのDevice File Explorerか、またはadbコマンドで端末から取り出す。

