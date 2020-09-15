見ていただきましてありがとうございます。
ここにはポートフォリオとして作成したecサイトと、ecサイト運営アプリケーションのコードを載せています。
ecサイトの画面遷移とクラスの関係について説明します。

(初回リクエスト時)         servlet.Info.java  --->  info.jsp  --->  home画面 & 商品一覧を表示  
(商品クリック時)         　servlet.Detail.java  --->  detail.jsp  --->  商品詳細を表示  
(カートに入れるクリック時)  　servlet.Basket.java  --->  basket.jsp  --->  カートの中身を表示  
(取消しクリック時)         servlet.Basket.java  --->  basket.jsp  --->  カートの中身を表示  
(注文するクリック時)      　servlet.Confirm.java  --->  confirm.jsp  --->  お客様情報入力画面 & 商品内容確認画面を表示  
(注文を確定するクリック時)   servlet.Thanks.java  --->  thanks.jsp  --->  『ありがとうございました。』を表示  
