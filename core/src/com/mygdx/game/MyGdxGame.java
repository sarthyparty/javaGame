package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation<TextureRegion> animation;
	private float elapsedTime = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/spritesheet.atlas"));
		animation = new Animation(1/15f, textureAtlas.getRegions());
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
		batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
	}
}
